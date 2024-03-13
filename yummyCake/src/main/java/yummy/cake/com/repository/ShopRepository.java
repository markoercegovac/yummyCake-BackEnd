package yummy.cake.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yummy.cake.com.bom.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}
