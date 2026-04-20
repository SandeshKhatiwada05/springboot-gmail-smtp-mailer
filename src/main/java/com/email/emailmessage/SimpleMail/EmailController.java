package com.email.emailmessage.SimpleMail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class EmailController {

    private final EmailService emailService;
    public EmailController(EmailService emailService){
        this.emailService = emailService;
    }

    @PostMapping("/sendMail")
    public String mailSender(@RequestBody MailFormat mailFormat){
        emailService.sendEmail(mailFormat);
        log.info("ENV password: {}", System.getenv("APP_PASSWORD"));
        return "Mail sent to "+ mailFormat.getTo();
    }
}
