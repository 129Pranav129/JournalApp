package net.engineeringdigest.journalApp.service;

import com.pranav.journalApp.JournalApplication;
import com.pranav.journalApp.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = JournalApplication.class)
public class EmailServiceTests {

    @Autowired
    private EmailService emailService;

    @Test
    public void testEmailService() {
        emailService.sendSimpleMessage("random@gmail.com",
                "test","hi, ap kaise ho");
    }
}
