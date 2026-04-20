package com.email.emailmessage.mimemessage;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    private MimeMailService mailService;
    public MailController(MimeMailService mailService){
        this.mailService = mailService;
    }

    @PostMapping("/gmailWithHTML")
    public String sendGmail(@RequestBody MailEntity mailEntity) throws Exception {
        mailService.doMailService(mailEntity);
        return "Operation Performed";
    }
}

