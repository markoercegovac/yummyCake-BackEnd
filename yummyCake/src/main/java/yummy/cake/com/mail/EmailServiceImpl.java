package yummy.cake.com.mail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService{

    private final JavaMailSender javaMailSender;

    private final static String SENDER_MAIL = "official2yummycake@gmail.com";
    private final static String ENCODER = "utf-8";

    @Override
    public void sendSimpleMessage(String to, String subject, String text) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            mimeMessage.setContent(text,"text/html; charset=utf-8");
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
            helper.setFrom(SENDER_MAIL);
            helper.setTo(to);
            helper.setSubject(subject);

            javaMailSender.send(mimeMessage);

        } catch (MailException | MessagingException exception) {
            exception.printStackTrace();
        }
    }
}
