package yummy.cake.com.service.notification;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yummy.cake.com.mail.EmailService;

@Service
@RequiredArgsConstructor
public class CustomerNotificationServiceImpl implements CustomerNotificationService {

    private final EmailService emailService;

    @Override
    public void notifyCustomer() {
        emailService.sendSimpleMessage("ercegovacmarko@yahoo.com", "test", "test");
    }
}
