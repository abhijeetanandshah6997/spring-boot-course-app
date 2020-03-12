package com.abhijeet.course.email;

import com.abhijeet.course.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    public void sendEmail(User user) throws MailException {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmail());
        mail.setSubject("Testing Mail API");
        mail.setText("Hurray ! You have done that dude...");
        javaMailSender.send(mail);
    }

    public void sendEmailWithAttachment(User user) throws MailException, MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setTo(user.getEmail());
        helper.setSubject("Testing Mail API with Attachment");
        helper.setText("Please find the attached document below.");
        ClassPathResource classPathResource = new ClassPathResource("Attachment.pdf");
        helper.addAttachment(classPathResource.getFilename(), classPathResource);
        javaMailSender.send(mimeMessage);
    }

    public void sendHtmlMail(User user, String templateName, Context context) throws MailException, MessagingException {
        MimeMessage mail = javaMailSender.createMimeMessage();
        String body = templateEngine.process(templateName, context);
        MimeMessageHelper helper = new MimeMessageHelper(mail, true);
        helper.setTo(user.getEmail());
        helper.setSubject("Testing Mail API with HTML");
        helper.setText(body, true);
        javaMailSender.send(mail);
    }

}
