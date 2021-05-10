package az.kapitalbank.kapitalbank.demo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class EmployeeDTO {

    private Long id;
    private String name;
    private String surname;
    private String position;
}
