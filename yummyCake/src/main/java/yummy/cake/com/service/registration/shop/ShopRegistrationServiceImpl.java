package yummy.cake.com.service.registration.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yummy.cake.com.bom.Address;
import yummy.cake.com.bom.Shop;
import yummy.cake.com.dto.shopRegistration.ShopRegistrationRequest;
import yummy.cake.com.repository.ShopRepository;

@Service
@RequiredArgsConstructor
public class ShopRegistrationServiceImpl implements ShopRegistrationService {

    private final ShopRepository repository;

    @Override
    public void register(ShopRegistrationRequest request) {
        Address address = createAddress(request);

        Shop shop = new Shop();
        shop.setName(request.getName());
        shop.setAddress(address);

        repository.save(shop);
    }

    private Address createAddress(ShopRegistrationRequest request){
        Address address = new Address();

        address.setCountry(request.getCountry());
        address.setCity(request.getCity());
        address.setPostalCode(request.getZip());
        address.setAddress(request.getAddress());
        address.setAdditionalAddress(request.getAdditionalAddress());

        return address;
    }
}
