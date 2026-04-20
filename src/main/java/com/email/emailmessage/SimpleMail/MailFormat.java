package com.email.emailmessage.SimpleMail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MailFormat {
    private String to;
    private String subject;
    private String body;
}
