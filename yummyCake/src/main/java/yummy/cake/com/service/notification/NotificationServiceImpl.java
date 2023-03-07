package yummy.cake.com.service.notification;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yummy.cake.com.bom.Role;
import yummy.cake.com.dto.NotificationDto;
import yummy.cake.com.enums.RoleEnum;
import yummy.cake.com.mail.EmailService;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private static final String SUBJECT = "Activation of account";
    private static final String TEXT = "To activate your account please click on this link: ";

    private static final String DEAR = "Dear ";
    private static final String LINK_CUSTOMER = "http://localhost:3000/activate/customer/";
    private static final String LINK_OWNER = "http://localhost:3000/activate/owner/";

    private final EmailService emailService;

    @Override
    public void notifyUser(NotificationDto notification) {
        String url = LINK_CUSTOMER;
        if (notification.getType().equals(RoleEnum.ROLE_OWNER.value)) {
            url = LINK_OWNER;
        }

        url += notification.getId();
        String content = "<a href='" + url + "'>Activate account</a>";

        emailService.sendSimpleMessage(notification.getEmail(), SUBJECT,
                DEAR + notification.getFirstName() + " " + notification.getLastName() + "<br>" + TEXT + content);
    }
}
