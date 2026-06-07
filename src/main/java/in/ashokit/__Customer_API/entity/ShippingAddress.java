package in.ashokit.__Customer_API.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShippingAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer addressId;
    private Integer houseNumber;
    private String city;
    private String street;
    private String state;
    private String country;
    private Long zipCode;
    private String addressType;
    private String deleteSw;

    @ManyToOne
    @JoinColumn(name="customer_Id")
    private Customer customer;
}
