package pl.pwn.reaktor.challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.pwn.reaktor.challenge.model.Contact;


@Component
public class EmailService {

    private static final String TO = "pawel.gaudziak@gmail.com";
    private static final String SUBJECT = "Kontakt z odpadów";

    @Autowired
    public JavaMailSender mailSender;

    public void sentMessage(Contact contact) {
        System.out.println("Email");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(TO);
        message.setSubject(SUBJECT);
        message.setText(contact.getMessage());
        message.setReplyTo(contact.getEmail());

        try {
            mailSender.send(message);
        } catch (MailException e) {
            e.printStackTrace();
        }
    }
}
