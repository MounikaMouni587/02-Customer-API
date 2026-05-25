package in.ashokit.__Customer_API.dto;

import in.ashokit.__Customer_API.entity.Customer;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class ShippingAddressDto {

    private Integer address_Id;
    private Integer houseNumber;
    private String city;
    private String street;
    private String state;
    private String country;
    private Long zipCode;
    private String addressType;
}
