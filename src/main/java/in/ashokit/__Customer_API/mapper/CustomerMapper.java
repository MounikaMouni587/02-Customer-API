package in.ashokit.__Customer_API.mapper;

import in.ashokit.__Customer_API.dto.CustomerDto;
import in.ashokit.__Customer_API.entity.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

   @Autowired
    private static ModelMapper mapper;

    public static CustomerDto convertToDto(Customer customer){
        return mapper.map(customer,CustomerDto.class);

    }


    public static Customer convertToEntity(CustomerDto customerDto){
        return mapper.map(customerDto,Customer.class);
    }
}
