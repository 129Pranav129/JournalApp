package com.pranav.journalApp.scheduler;

import com.pranav.journalApp.entity.JournalEntry;
import com.pranav.journalApp.entity.User;
import com.pranav.journalApp.repository.JournalEntryRepository;
import com.pranav.journalApp.repository.UserRepository;
import com.pranav.journalApp.repository.UserRepositoryImpl;
import com.pranav.journalApp.service.EmailService;
import com.pranav.journalApp.service.SentimentAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserScheduler {
    @Autowired
    private UserRepositoryImpl userRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private SentimentAnalysisService sentimentAnalysisService;

    @Scheduled(cron = "0 9 * * SUN")
    public void fetchUsersAndSendMail(){
        List<User> user = userRepository.getUserForSA();
        String entry="";
        for (User u: user){
            List<JournalEntry> journalEntries = u.getJournalEntries();
            for (JournalEntry journalEntry: journalEntries){
                 entry = String.join(" ",journalEntry.getContent());
            }
            String sentiment= sentimentAnalysisService.getSentiment(entry);
            emailService.sendSimpleMessage(u.getEmail(),"Sentiment for last 7 days",sentiment);

        }

    }
}
