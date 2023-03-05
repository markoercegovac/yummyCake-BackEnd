package yummy.cake.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yummy.cake.com.bom.RegistrationRequest;

import java.util.UUID;

public interface RegistrationRequestRepository extends JpaRepository<RegistrationRequest, UUID> {
}
