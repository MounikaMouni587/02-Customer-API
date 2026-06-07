package in.ashokit.__Customer_API.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ApiResponse <T> {

    private String msg;

    private Integer status;

    private T data;
}
