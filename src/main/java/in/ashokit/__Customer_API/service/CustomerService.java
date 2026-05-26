package in.ashokit.__Customer_API.service;

import in.ashokit.__Customer_API.dto.CustomerDto;
import in.ashokit.__Customer_API.dto.ResetPwdDto;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    public CustomerDto savedCustomer(CustomerDto customerDto);

    public CustomerDto login(String email,String pwd);

    public boolean resetPwd(ResetPwdDto resetPwdDto);

    public CustomerDto getCustomerByEmail(String email);

    public CustomerDto updateCustomerDto(CustomerDto customerDto);


}
