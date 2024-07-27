package net.engineeringdigest.journalApp.service;

import com.pranav.journalApp.JournalApplication;
import com.pranav.journalApp.entity.User;
import com.pranav.journalApp.repository.UserRepository;
import com.pranav.journalApp.service.UserService;
import javafx.application.Application;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = JournalApplication.class)
public class UserServiceTests {



//    @Autowired
//    private UserRepository userRepository;
//    @Test
//    public void findByUserName() {
//        assertNotNull(userRepository.findByUsername("ravi"));
//    }

}
