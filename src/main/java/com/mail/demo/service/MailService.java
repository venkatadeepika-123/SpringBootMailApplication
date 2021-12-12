package com.mail.demo.service;

import com.mail.demo.model.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import java.util.*;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@Service
public class MailService {
    
    /*
	 * The Spring Framework provides an easy abstraction for sending email by using
	 * the JavaMailSender interface, and Spring Boot provides auto-configuration for
	 * it as well as a starter module.
	 */
    Scanner in = new Scanner(System.in);
	private JavaMailSender javaMailSender;

    @Autowired
    public MailService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(user userName) throws MailException {

       /* SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(userName.getEmailId());
        System.out.println("enter the subject of the email: ");
        String sub = in.nextLine();
		mail.setSubject(sub);
        System.out.println("enter the text of the email: ");
        String txt = in.nextLine();
		mail.setText(txt);*/

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(userName.getEmailId());
		mail.setSubject("Testing Mail API");
		mail.setText("Hurray ! You have done that dude...");

		/*
		 * This send() contains an Object of SimpleMailMessage as an Parameter
		 */
		//javaMailSender.send(mail);

		/*
		 * This send() contains an Object of SimpleMailMessage as an Parameter
		 */
		javaMailSender.send(mail);
	}
	public void sendMailWithAttachment(user userName) throws MailException, MessagingException {

		/*MimeMessage mail = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mail, true);

		helper.setTo(userName.getEmailId());
		helper.setSubject("Testing Mail API with Attachment");
		helper.setText("Please find the attached document below.");

		ClassPathResource classPathResource = new ClassPathResource("a.pdf");
		helper.addAttachment((classPathResource.getFilename()), classPathResource);
		javaMailSender.send(mail);*/
		MimeMessage mail = javaMailSender.createMimeMessage();
		MimeMessageHelper help = new MimeMessageHelper(mail,true);
		help.setTo(userName.getEmailId());
		help.setSubject("Testing my mailApi with a attachment");
		help.setText("Please find the attachment below");

		ClassPathResource r = new ClassPathResource("AttachmentFile.pdf");
		help.addAttachment((r.getFilename()),r);
		javaMailSender.send(mail);
	}
}
