package in.ashokit.__Customer_API.serviceImpl;

import in.ashokit.__Customer_API.dto.ShippingAddressDto;
import in.ashokit.__Customer_API.entity.Customer;
import in.ashokit.__Customer_API.entity.ShippingAddress;
import in.ashokit.__Customer_API.mapper.ShippingAddressMapper;
import in.ashokit.__Customer_API.repository.CustomerRepository;
import in.ashokit.__Customer_API.repository.ShippingAddressRepository;
import in.ashokit.__Customer_API.service.ShippingAddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ShippingAddressImpl implements ShippingAddressService {

    @Autowired
    private ShippingAddressRepository shippingAddressRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public ShippingAddressDto savedAddress(ShippingAddressDto shippingAddressDto ,Integer customerId) {
        Customer customerEntity=customerRepository.findById(customerId).orElseThrow();
        ShippingAddress shippingAddressEntity=ShippingAddressMapper.convertToEntity(shippingAddressDto);
        shippingAddressEntity.setCustomer(customerEntity);
        shippingAddressEntity.setDeleteSw("N");
        ShippingAddress savedAddress=shippingAddressRepository.save(shippingAddressEntity);
        return ShippingAddressMapper.convertToDto(savedAddress);

    }

    @Override
    public ShippingAddressDto getAddress(Integer addressId) {
        Optional<ShippingAddress> addressEntity = shippingAddressRepository.findById(addressId);
        if (addressEntity.isPresent()) {
            return ShippingAddressMapper.convertToDto(addressEntity.get());

        }
        return null;
    }

    @Override
    public List<ShippingAddressDto> getCustomerAddress(Integer customerId) {
        List<ShippingAddress> addressEntityList=shippingAddressRepository.findByCustomerCustomerIdAndDeleteSw(customerId,"N");
        return addressEntityList.stream().map(ShippingAddressMapper::convertToDto).toList();
    }

    @Override
    public boolean deleteAddress(Integer addressId) {
//        if(shippingAddressRepository.existsById(addressId)){
//            shippingAddressRepository.deleteById(addressId);
//
//        }
        Optional<ShippingAddress> byId=shippingAddressRepository.findById(addressId);
        if(byId.isPresent()){
            ShippingAddress addressEntity=byId.get();
            addressEntity.setDeleteSw("Y");
            shippingAddressRepository.save(addressEntity);
            return true;
        }
        return false;
    }
}
