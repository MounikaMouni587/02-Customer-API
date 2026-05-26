package in.ashokit.__Customer_API.dto;

import lombok.Data;

@Data
public class ResetPwdDto {

    private String email;
    private String newPwd;
    private String confirmPwd;
}
