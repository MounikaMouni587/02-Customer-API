package in.ashokit.__Customer_API.serviceImpl;

import in.ashokit.__Customer_API.dto.CustomerDto;
import in.ashokit.__Customer_API.dto.ResetPwdDto;
import in.ashokit.__Customer_API.entity.Customer;
import in.ashokit.__Customer_API.mapper.CustomerMapper;
import in.ashokit.__Customer_API.repository.CustomerRepository;
import in.ashokit.__Customer_API.service.CustomerService;
import in.ashokit.__Customer_API.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EmailService emailService;

    @Override
    public CustomerDto savedCustomer(CustomerDto customerDto) {
        Customer customer=CustomerMapper.convertToEntity(customerDto);
        String tempPwd=generateRandomPwd(6);
        customer.setPassword(tempPwd);
        customer.setPwdUpdated("No");
       Customer savedCustomer=customerRepository.save(customer);

       String subject="";
       String body="";
      boolean status= emailService.sendEmail(subject,body,customerDto.getEmail());

       if(status){
           return CustomerMapper.convertToDto(savedCustomer);
       }
        return null;
    }
//--------------------------------------------------------------------------------------------
    @Override
    public CustomerDto login(String email, String pwd) {
        Customer customer=customerRepository.findByEmailAndPwd(email,pwd);
       if(customer!=null){
           return CustomerMapper.convertToDto(customer);

       }

        return null;
    }
//-----------------------------------------------------------------------------------------
    @Override
    public boolean resetPwd(ResetPwdDto resetPwdDto) {

        Customer customer=customerRepository.findByEmail(resetPwdDto.getEmail());
        if(customer!=null){
            customer.setPassword(resetPwdDto.getNewPwd());
            customer.setPwdUpdated("Yes");
            Customer savedCustomer=customerRepository.save(customer);
            return true;
        }
        return false;
    }
//-----------------------------------------------------------------------------------------
    @Override
    public CustomerDto getCustomerByEmail(String email) {

       Customer customer= customerRepository.findByEmail(email);
       if(customer!=null){
           return CustomerMapper.convertToDto(customer);
       }
        return null;
    }
//-----------------------------------------------------------------------------------------
    @Override
    public CustomerDto updateCustomerDto(CustomerDto customerDto) {

        Customer customer=CustomerMapper.convertToEntity(customerDto);

        Customer savedCustomer=customerRepository.save(customer);

        return CustomerMapper.convertToDto(savedCustomer);
    }
//--------------------------------------------------------------------------------------------
    public String generateRandomPwd(int pwdLength){
        Random random=new Random();
        String chars="ABCDEFGHIJKLMNOPQRSTUVWXYZ123456";
        StringBuilder buffer=new StringBuilder(pwdLength);
        for(int i=0;i<pwdLength;i++){
            int randomIndex=random.nextInt(chars.length());
            char ch=chars.charAt(randomIndex);
            buffer.append(ch);
        }
        return buffer.toString();
    }
}
