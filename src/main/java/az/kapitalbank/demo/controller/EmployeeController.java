package az.kapitalbank.demo.controller;

import az.kapitalbank.demo.domain.Employee;
import az.kapitalbank.demo.dto.EmployeeDTO;
import az.kapitalbank.demo.mapper.EmployeeMapper;
import az.kapitalbank.demo.repository.EmployeeRepository;
import az.kapitalbank.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDTO> all() {
        return employeeService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveOrUpdate(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.save(employeeDTO);
    }

    @GetMapping({"/{id}"})
    public EmployeeDTO getById(@PathVariable Long id) {
        return employeeService.getById(id);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<EmployeeDTO> deleteTodo(@PathVariable Long id) {
        employeeService.delete(id);
        return new ResponseEntity<EmployeeDTO>(HttpStatus.NO_CONTENT);
    }
}
