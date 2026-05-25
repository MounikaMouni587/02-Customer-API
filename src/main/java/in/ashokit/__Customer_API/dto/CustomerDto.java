package in.ashokit.__Customer_API.dto;

import jakarta.persistence.Column;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Data
public class CustomerDto {

    private Integer Id;
    private String Name;
    private String email;
    private String password;
    private Long phoneNumber;
    private String pwdUpdated;
    private LocalDate dateCreated;

    private LocalDate lastUpdated;
}
