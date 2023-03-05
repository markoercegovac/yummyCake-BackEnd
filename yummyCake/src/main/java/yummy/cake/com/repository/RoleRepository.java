package yummy.cake.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yummy.cake.com.bom.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
