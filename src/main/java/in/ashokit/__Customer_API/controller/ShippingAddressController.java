package in.ashokit.__Customer_API.controller;

import in.ashokit.__Customer_API.dto.CustomerDto;
import in.ashokit.__Customer_API.dto.ShippingAddressDto;
import in.ashokit.__Customer_API.entity.ShippingAddress;
import in.ashokit.__Customer_API.response.ApiResponse;
import in.ashokit.__Customer_API.service.ShippingAddressService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ShippingAddressController {

    @Autowired
    private ShippingAddressService shippingAddressService;

    @PostMapping("/savedAddress/{customerId}")
    public ResponseEntity<ApiResponse<ShippingAddressDto>> savedAddress(@RequestBody ShippingAddressDto shippingAddressDto, @PathVariable Integer customerId){

        ApiResponse<ShippingAddressDto> response=new ApiResponse<>();
        ShippingAddressDto shippingAddressDto1=shippingAddressService.savedAddress(shippingAddressDto,customerId);

        if(shippingAddressDto!=null){
            response.setMsg("Addess saved succesfully");
            response.setData(shippingAddressDto1);
            response.setStatus(201);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        else{
            response.setMsg("failed to save the address");
            response.setData(null);
            response.setStatus(500);
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //-------------------------------------------------------------------------------------------------

    @GetMapping("/address/{addressId}")
    public ResponseEntity<ApiResponse<ShippingAddressDto>> getAddress( @PathVariable Integer addressId){

        ApiResponse<ShippingAddressDto> response=new ApiResponse<>();
        ShippingAddressDto shippingAddressDto1=shippingAddressService.getAddress(addressId);

        if(shippingAddressDto1!=null){
            response.setMsg("Addess fetched succesfully");
            response.setData(shippingAddressDto1);
            response.setStatus(201);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        else{
            response.setMsg("failed to fetched the address");
            response.setData(null);
            response.setStatus(500);
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //------------------------------------------------------------------------------------------------

    @GetMapping("/address/{customerId}")
    public ResponseEntity<ApiResponse<List<ShippingAddressDto>>> getCustomerAddresses(@PathVariable Integer customerId){

        ApiResponse<List<ShippingAddressDto>> response=new ApiResponse<>();
        List<ShippingAddressDto> customerAddresses =shippingAddressService.getCustomerAddress(customerId);

        if(customerAddresses.isEmpty()){
            response.setMsg("Addesses fetched succesfully");
            response.setData(customerAddresses);
            response.setStatus(201);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        else{
            response.setMsg("failed to fetched the addresses");
            response.setData(null);
            response.setStatus(500);
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//----------------------------------------------------------------------------------------------


    @PostMapping("/savedAddress/{customerId}")
    public ResponseEntity<ApiResponse<ShippingAddressDto>> updateAddress(@RequestBody ShippingAddressDto shippingAddressDto, @PathVariable Integer customerId){

        ApiResponse<ShippingAddressDto> response=new ApiResponse<>();
        ShippingAddressDto shippingAddressDto1=shippingAddressService.savedAddress(shippingAddressDto,customerId);

        if(shippingAddressDto!=null){
            response.setMsg("Addess saved succesfully");
            response.setData(shippingAddressDto1);
            response.setStatus(201);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        else{
            response.setMsg("failed to save the address");
            response.setData(null);
            response.setStatus(500);
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //-----------------------------------------------------------------------------------------


    @PostMapping("/deleteAddress/{addressId}")
    public ResponseEntity<ApiResponse<ShippingAddressDto>> deleteAddress( @PathVariable Integer addressId){

        ApiResponse<ShippingAddressDto> response=new ApiResponse<>();
       boolean isDeleted=shippingAddressService.deleteAddress(addressId);

        if(isDeleted){
            response.setMsg("Addess deleted succesfully");
            response.setStatus(201);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        else{
            response.setMsg("failed to delete the address");
            response.setData(null);
            response.setStatus(500);
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
