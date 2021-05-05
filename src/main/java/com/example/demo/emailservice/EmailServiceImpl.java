package com.example.demo.emailservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;

public class EmailServiceImpl implements EmailService {
    
    @Autowired
    private JavaMailSender emailSender;

    // If get a request for this uri, then mapping the parameter from the web ap server, then send email and get back to result
    @Override
    @RequestMapping("/email")
    public String sendSimpleMessage() {
        String result = "";

        // This is totally easy way to send email to other person.
        SimpleMailMessage message = new SimpleMailMessage();

        // Email message form setting
        message.setFrom("commander@test.com");
        message.setTo("destination");
        message.setSubject("Hello This is spring boot mail Test");
        message.setText("This is test Message for spring boot email send server");

        // email send to people
        emailSender.send(message);

        // If mail send success, then send result OK, but not send to email return Fail
        return result;
    }

}
