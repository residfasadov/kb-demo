package az.kapitalbank.demo.mapper;


import az.kapitalbank.demo.domain.Employee;
import az.kapitalbank.demo.dto.EmployeeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    Employee toEntity(EmployeeDTO employeeDto);

    EmployeeDTO toDto(Employee employee);

    List<EmployeeDTO> toEmployeeDTOList(List<Employee> employeeList);

}
