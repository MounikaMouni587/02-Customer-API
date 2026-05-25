package in.ashokit.__Customer_API.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ShippingAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer address_Id;
    private Integer houseNumber;
    private String city;
    private String street;
    private String state;
    private String country;
    private Long zipCode;
    private String addressType;

    @ManyToOne
    @JoinColumn(name="customer_Id")
    private Customer customer;
}
