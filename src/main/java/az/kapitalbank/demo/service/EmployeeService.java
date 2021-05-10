package az.kapitalbank.demo.service;

import az.kapitalbank.demo.domain.Employee;
import az.kapitalbank.demo.dto.EmployeeDTO;
import az.kapitalbank.demo.exception.EmployeeNotFoundException;
import az.kapitalbank.demo.mapper.EmployeeMapper;
import az.kapitalbank.demo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService implements EmployeeServiceImpl {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDTO> findAll() {
        return EmployeeMapper.INSTANCE.toEmployeeDTOList(employeeRepository.findAll());
    }

    @Override
    public void save(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.INSTANCE.toEntity(employeeDTO);
        employeeRepository.save(employee);
    }

    @Override
    public EmployeeDTO getById(Long id) {

        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent())
            return EmployeeMapper.INSTANCE.toDto(employeeOptional.get());
        throw new EmployeeNotFoundException();
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }
}



