package base.main.java.com.example.restservice.repo;

import base.main.java.com.example.restservice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}