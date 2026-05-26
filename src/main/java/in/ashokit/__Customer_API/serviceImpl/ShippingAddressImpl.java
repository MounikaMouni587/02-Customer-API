package in.ashokit.__Customer_API.serviceImpl;

import in.ashokit.__Customer_API.dto.ShippingAddressDto;
import in.ashokit.__Customer_API.repository.ShippingAddressRepository;
import in.ashokit.__Customer_API.service.ShippingAddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ShippingAddressImpl implements ShippingAddressService {

    @Autowired
    private ShippingAddressRepository shippingAddressRepository;
    @Override
    public ShippingAddressDto savedAddress(ShippingAddressDto shippingAddressDto) {
        return null;
    }

    @Override
    public ShippingAddressDto getAddress(Integer addressId) {
        return null;
    }

    @Override
    public ShippingAddressDto updateAddress(ShippingAddressDto shippingAddressDto) {
        return null;
    }

    @Override
    public List<ShippingAddressDto> getCustomerAddress(Integer customerId) {
        return List.of();
    }

    @Override
    public ShippingAddressDto deleteAddress(Integer addressId) {
        return null;
    }
}
