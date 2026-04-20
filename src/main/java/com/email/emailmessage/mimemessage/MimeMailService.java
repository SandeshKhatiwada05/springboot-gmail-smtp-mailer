package com.email.emailmessage.mimemessage;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Slf4j
@Service
public class MimeMailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void doMailService(MailEntity mailEntity) throws Exception {
        try {
            log.info("Entered mail service");
            MimeMessage message = javaMailSender.createMimeMessage();
            message.setFrom(new InternetAddress("Khatiwadasandesh501@gmail.com"));
            message.setRecipients(MimeMessage.RecipientType.TO, mailEntity.getTo());
            message.setSubject("Hello from Sandesh!");

            log.info("Mail basics performed");
            ClassPathResource htmlPage = new ClassPathResource("templates/template.html");
            String htmlTemplate = new String(
                    htmlPage.getInputStream().readAllBytes(),
                    StandardCharsets.UTF_8
            );

            htmlTemplate = htmlTemplate.replace("${name}", mailEntity.getName());
            message.setContent(htmlTemplate, "text/html; charset=utf-8");
            log.info("Mail Content set");
            javaMailSender.send(message);
            log.info("Email Sent Sucessfully");
        } catch (Exception e){
            log.error("Mail sending failed", e);
            throw e;
        }
    }
}
