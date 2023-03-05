package yummy.cake.com.mail;

public interface EmailService {
    void sendSimpleMessage(String to,
                           String subject,
                           String text);
}
