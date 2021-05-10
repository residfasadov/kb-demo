package az.kapitalbank.kapitalbank.demo.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException() {
    }

    public EmployeeNotFoundException(Long employeeId ) {
        super("Employee: " +employeeId +" not found.");
    }
}
