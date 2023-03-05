package yummy.cake.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yummy.cake.com.bom.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    UserAccount findByUsername(String username);
}
