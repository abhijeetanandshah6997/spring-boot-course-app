package com.abhijeet.course.email;

import com.abhijeet.course.user.User;
import com.abhijeet.course.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserService userService;

    private final String successMessage= "Email sent successfully...";

    @RequestMapping("/send-email")
    public String sendEmail() {
        User user = new User("abhijeet.shah", "abhijeet.shah@nineleaps.com", 24);
        try {
            emailService.sendEmail(user);
        }
        catch (MailException mailException) {
            System.out.println(mailException);
        }
        return successMessage;
    }

    @RequestMapping("/send-mail-attachment")
    public String sendWithAttachment() throws MessagingException {
        User user = new User("abhijeet.shah", "abhijeet.shah@nineleaps.com", 24);
        try {
            emailService.sendEmailWithAttachment(user);
        } catch (MailException mailException) {
            System.out.println(mailException);
        }
        return successMessage;
    }

    @RequestMapping("/send-mail-html")
    public String sendWithHtml() throws MessagingException {
        User user = new User("abhijeet.shah", "abhijeet.shah@nineleaps.com", 24);
        Context context = new Context();
        context.setVariable("username", user.getUserName());
        try {
            emailService.sendHtmlMail(user, "emailTemplate", context);
        } catch (MailException mailException) {
            System.out.println(mailException);
        }
        return successMessage;
    }
}
