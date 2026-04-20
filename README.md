# Spring Boot Gmail SMTP Mailer

A simple **Spring Boot project** demonstrating how to send emails using **Gmail SMTP**.

## Features
- Send **plain text emails** using `SimpleMailMessage`
- Send **HTML emails** using `MimeMessage`
- Use **HTML email template**
- Gmail SMTP integration

## Tech Stack
* Java  
* Spring Boot  
* Spring Mail (`JavaMailSender`)  
* Maven

## Project Structure

src/main/java
-- controller
-- service
-- entity

src/main/resources
-- templates/template.html
-- application.properties


## Gmail SMTP Configuration

Add the following to `application.properties`:

```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your_email@gmail.com
spring.mail.password=your_app_password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

Gmail requires an App Password for SMTP authentication.
