package az.kapitalbank.demo.service;

import az.kapitalbank.demo.domain.Employee;
import az.kapitalbank.demo.dto.EmployeeDTO;
import az.kapitalbank.demo.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    public void when_save_return_employee() {

        EmployeeDTO request = new EmployeeDTO();
        request.setName("test");
        request.setSurname("test");
        request.setPosition("test");

        Employee response = new Employee();
        response.setName("test");
        response.setSurname("test");
        response.setPosition("test");

        when(employeeRepository.save(any(Employee.class)))
                .thenReturn(response);

        EmployeeDTO created = employeeService.save(request);
        assertThat(created.getName()).isSameAs(request.getName());
        assertThat(created.getSurname()).isSameAs(request.getSurname());
        assertThat(created.getPosition()).isSameAs(request.getPosition());
    }

    @Test
    public void should_return_listEmployes() {

        when(employeeRepository.findAll()).thenReturn(Arrays.asList(new Employee()));
        List<EmployeeDTO> employeeDTOList = employeeService.findAll();
        assertFalse(employeeDTOList.isEmpty());
        verify(employeeRepository, times(1)).findAll();
    }

    @Test
    public void find_employee_byId() {
        Employee response = new Employee();
        response.setId(1l);
        Employee employee = employeeRepository.findById(1l).orElse(response);
        assertThat(employee.getId()).isEqualTo(1l);
    }


    @Test
    public void when_givenId_should_delete_user_ifFound() {
        Employee employee = new Employee();
        employee.setId(1L);
        when(employeeRepository.findById(employee.getId())).thenReturn(Optional.of(employee));
        employeeService.delete(employee.getId());
        verify(employeeRepository).deleteById(employee.getId());
    }

}



