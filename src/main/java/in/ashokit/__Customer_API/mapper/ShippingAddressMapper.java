package in.ashokit.__Customer_API.mapper;

import in.ashokit.__Customer_API.dto.CustomerDto;
import in.ashokit.__Customer_API.dto.ShippingAddressDto;
import in.ashokit.__Customer_API.entity.Customer;
import in.ashokit.__Customer_API.entity.ShippingAddress;
import org.modelmapper.ModelMapper;

public class ShippingAddressMapper {

    public static final ModelMapper mapper= new ModelMapper();

    public static ShippingAddressDto convertToDto(ShippingAddress shippingAddress){
        return mapper.map(shippingAddress,ShippingAddressDto.class);

    }


    public static ShippingAddress convertToEntity(ShippingAddressDto shippingAddressDto){
        return mapper.map(shippingAddressDto,ShippingAddress.class);
    }
}
