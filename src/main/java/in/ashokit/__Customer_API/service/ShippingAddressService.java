package in.ashokit.__Customer_API.service;

import in.ashokit.__Customer_API.dto.ShippingAddressDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShippingAddressService {

    public ShippingAddressDto savedAddress(ShippingAddressDto shippingAddressDto,Integer cusotmerId);

    public ShippingAddressDto getAddress(Integer addressId);



    public List<ShippingAddressDto> getCustomerAddress(Integer customerId);

    public boolean deleteAddress(Integer addressId);

}
