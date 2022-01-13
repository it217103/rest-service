package base.main.java.com.example.restservice.service;

import base.main.java.com.example.restservice.model.Student;
import base.main.java.com.example.restservice.web.StudentRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface StudentService extends UserDetailsService {
    Student findbyEmail(String email);
    Student findbyId(long id);
    Student save(StudentRegistrationDto Student_registration);


}
