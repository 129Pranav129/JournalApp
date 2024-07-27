package com.pranav.journalApp.service;

import com.pranav.journalApp.entity.JournalEntry;
import com.pranav.journalApp.entity.User;
import com.pranav.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;
    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(JournalEntryService.class);

    @Transactional
    public void saveEntry(JournalEntry journalEntry, String username) {
        try{
            User user = userService.findByUserName(username);
            JournalEntry save = journalEntryRepository.save(journalEntry);
            user.getJournalEntries().add(save);
            userService.saveEntry(user);
        }
        catch(Exception e){
            logger.error(e.getMessage());
            throw new RuntimeException("An error occured while saving journal entry");
        }

    }

    public void saveEntry(JournalEntry journalEntry) {
        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAll() {
        return journalEntryRepository.findAll();
    }

    public JournalEntry getById(ObjectId id) {
        return journalEntryRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteById(ObjectId id, String username) {
        try{
            journalEntryRepository.deleteById(id);
            User user = userService.findByUserName(username);
            user.getJournalEntries().removeIf(journalEntry -> journalEntry.getId().equals(id));
            userService.saveEntry(user);
        }
        catch(Exception e){
            System.out.println(e);
            throw new RuntimeException("Error deleting journal entry");
        }

    }


}
