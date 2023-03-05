package yummy.cake.com.service.notification;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yummy.cake.com.dto.NotificationDto;
import yummy.cake.com.mail.EmailService;

@Service
@RequiredArgsConstructor
public class CustomerNotificationServiceImpl implements CustomerNotificationService {

    private static final String SUBJECT = "Activation of account";
    private static final String TEXT = "To activate your account please click on this link: ";

    private static final String DEAR = "Dear ";
    private static final String LINK = "http://localhost:3000/activate/customer/";

    private final EmailService emailService;

    @Override
    public void notifyCustomer(NotificationDto notification) {
        String url = LINK + notification.getId();
        String content = "<a href='" + url + "'>Activate account</a>";

        emailService.sendSimpleMessage(notification.getEmail(),
                SUBJECT + " " + notification.getType(), DEAR + notification.getFirstName() + " " + notification.getLastName() + "<br>"
                        + TEXT + content);
    }
}
