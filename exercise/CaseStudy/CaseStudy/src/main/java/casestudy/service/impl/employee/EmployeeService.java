package casestudy.service.impl.employee;

import casestudy.model.employee.Employee;
import casestudy.model.facility.Facility;
import casestudy.repository.employee.EmployeeRepository;
import casestudy.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public List<Employee> findListAll() {
        return employeeRepository.findAll();
    }
}
