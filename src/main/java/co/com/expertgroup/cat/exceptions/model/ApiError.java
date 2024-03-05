package co.com.expertgroup.cat.exceptions.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ApiError implements Serializable {

    private  LocalDateTime timestamp;
    private String message;
}
