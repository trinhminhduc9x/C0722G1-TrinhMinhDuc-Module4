package casestudy.service.employee;

import casestudy.model.customer.Customer;
import casestudy.model.employee.Employee;
import casestudy.model.facility.Facility;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findListAll();
}
