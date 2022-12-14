package casestudy.service.employee;

import casestudy.model.employee.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(int id);
}
