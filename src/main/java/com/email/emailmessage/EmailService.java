package com.email.emailmessage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(MailFormat mailFormat){
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom("khatiwadasandesh501@gmail.com");
            simpleMailMessage.setTo(mailFormat.getTo());
            simpleMailMessage.setSubject(mailFormat.getSubject());
            simpleMailMessage.setText(mailFormat.getBody());
            javaMailSender.send(simpleMailMessage);
        } catch (Exception e) {
            log.error("Couldn't send message to {}", mailFormat.getTo(), e);
        }
    }
}
