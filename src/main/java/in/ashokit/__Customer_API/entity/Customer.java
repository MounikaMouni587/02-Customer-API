package in.ashokit.__Customer_API.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name="customer_Id")
    private Integer Id;

    private String Name;
    private String email;
    private String password;
    private Long phoneNumber;

    private String pwdUpdated;
    @Column(name="date_Created")
    @CreationTimestamp
    private LocalDate dateCreated;


    @Column(name="last_Updated")
    @UpdateTimestamp
    private LocalDate lastUpdated;







}
