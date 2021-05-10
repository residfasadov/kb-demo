package az.kapitalbank.demo.service;

import az.kapitalbank.demo.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeServiceImpl {

    List<EmployeeDTO> findAll();

    void save(EmployeeDTO employeeDTO);

    EmployeeDTO getById(Long id);

    void delete(Long id);
}
