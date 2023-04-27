package ks46team01.user.info.service;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmailService {

    private final JavaMailSenderImpl mailSender;

    public EmailService(JavaMailSenderImpl mailSender) {
        this.mailSender = mailSender;
    }

    public void sendTemporaryPassword(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ks46team01email@naver.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
    }
}
