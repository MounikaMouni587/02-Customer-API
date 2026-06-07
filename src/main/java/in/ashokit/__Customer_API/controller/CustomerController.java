package in.ashokit.__Customer_API.controller;

import in.ashokit.__Customer_API.dto.CustomerDto;
import in.ashokit.__Customer_API.dto.ResetPwdDto;
import in.ashokit.__Customer_API.entity.Customer;
import in.ashokit.__Customer_API.response.ApiResponse;
import in.ashokit.__Customer_API.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customer")
    public ResponseEntity<ApiResponse<CustomerDto>> saveCustomer(@RequestBody CustomerDto customerDto){
        ApiResponse<CustomerDto> response=new ApiResponse<>();
        CustomerDto savedCustomer=customerService.savedCustomer(customerDto);
        if(savedCustomer!=null){
            response.setStatus(201);
            response.setMsg("Customer Saved");
            response.setData(savedCustomer);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        else{
            response.setData(null);
            response.setStatus(500);
            response.setMsg("Failed to save the customer");
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//*************************************************************************************************
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<CustomerDto>> login(@RequestBody CustomerDto customerDto){
        ApiResponse<CustomerDto> response=new ApiResponse<>();
        CustomerDto customer=customerService.login(customerDto.getEmail(),customerDto.getPassword());
        if(customer!=null){
            response.setStatus(201);
            response.setMsg("Login Success");
            response.setData(customer);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        else{
            response.setData(null);
            response.setStatus(400);
            response.setMsg("failed to login");
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//***********************************************************************************
    @PostMapping("/reset-pwd")
    public ResponseEntity<ApiResponse<String>> resetPwd(@RequestBody ResetPwdDto resetPwdDto){
        ApiResponse<String> response=new ApiResponse<>();
        boolean isResetCompleted=customerService.resetPwd(resetPwdDto);
        if(isResetCompleted){
            response.setStatus(201);
            response.setMsg("PWD Updated");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        else{
            response.setData(null);
            response.setStatus(400);
            response.setMsg("failed to login");
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//*****************************************************************************************
    @PostMapping("/get-Customer/{email}")
    public ResponseEntity<ApiResponse<CustomerDto>> getCustomerByEmail(@PathVariable String email){
        ApiResponse<CustomerDto> response=new ApiResponse<>();
        CustomerDto customerDto =customerService.getCustomerByEmail(email);
        if(customerDto!=null){
            response.setStatus(201);
            response.setMsg("customer fetched sucessfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        else{
            response.setData(null);
            response.setStatus(400);
            response.setMsg("failed to fetch customer");
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//********************************************************************************************

    @PostMapping("/update-customer")
    public ResponseEntity<ApiResponse<CustomerDto>> updateCustomer(@RequestBody CustomerDto customerDto){
        ApiResponse<CustomerDto> response=new ApiResponse<>();
        CustomerDto updateCustomer=customerService.updateCustomerDto(customerDto);
        if(updateCustomer!=null){
            response.setStatus(200);
            response.setMsg("Customer updated");
            response.setData(updateCustomer);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        else{
            response.setData(null);
            response.setStatus(500);
            response.setMsg("Failed to update the customer");
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
