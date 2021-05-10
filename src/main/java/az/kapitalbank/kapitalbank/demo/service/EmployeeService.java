package az.kapitalbank.kapitalbank.demo.service;

import az.kapitalbank.kapitalbank.demo.domain.Employee;
import az.kapitalbank.kapitalbank.demo.dto.EmployeeDTO;
import az.kapitalbank.kapitalbank.demo.mapper.EmployeeMapper;
import az.kapitalbank.kapitalbank.demo.repository.EmployeeRepository;
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
