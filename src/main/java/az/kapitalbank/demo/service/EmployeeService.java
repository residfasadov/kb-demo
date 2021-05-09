package az.kapitalbank.demo.service;

import az.kapitalbank.demo.domain.Employee;
import az.kapitalbank.demo.dto.EmployeeDTO;
import az.kapitalbank.demo.mapper.EmployeeMapper;
import az.kapitalbank.demo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<EmployeeDTO> findAll(){
        return EmployeeMapper.INSTANCE.toEmployeeDTOList(employeeRepository.findAll());
    }

    public void save(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.INSTANCE.toEntity(employeeDTO);
        employeeRepository.save(employee);
    }

}
