package az.kapitalbank.kapitalbank.demo.controller;

import az.kapitalbank.kapitalbank.demo.dto.EmployeeDTO;
import az.kapitalbank.kapitalbank.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping()
    public List<EmployeeDTO> all() {
        return employeeService.findAll();
    }


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.save(employeeDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping()
    public void get(@RequestBody EmployeeDTO employeeDTO) {
//        Employee employee = EmployeeMapper.INSTANCE.toEntity(employeeDTO);
//        System.out.println(employee.toString());
//        employeeRepository.save(employee);
    }
}
