package com.mail.demo.controller;

import com.mail.demo.service.MailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mail.demo.model.user;

import javax.mail.MessagingException;

//this class contains mail api developed with the spring boot

@RestController
public class RegistrationController {

    @Autowired
    private MailService notificatinService;

    @Autowired
    private user userName;

    @RequestMapping("send-mail")
    public String sendmail() {

        userName.setEmailId("........@gmail.com");

        //Here we will call sendEmail() for Sending mail to the sender.
        try {
            notificatinService.sendEmail(userName);
        } catch (MailException mailException) {
            System.out.println("exception caught");
        }
        return "hurry!!! Mail has sent succesfully";
    }

    @RequestMapping("send-mail-withAttachment")
    public String sendMailWithAttachment() {
        userName.setEmailId("........@gmail.com");

        try {
            notificatinService.sendMailWithAttachment(userName);
        }
        catch (MailException ex) {
            System.out.println(ex);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        System.out.println("mail has sent succesfully....");
        return "hurry!!!! Mail has sent sucessfully with attachment..";
    }
}
