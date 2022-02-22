package base.main.java.com.example.restservice.web;

import base.main.java.com.example.restservice.dao.StudentDao;
import base.main.java.com.example.restservice.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentDao studentDao;

    @GetMapping
    public String listofStudents(Model model){
        List<Student> studentList = studentDao.getterStudents();
        model.addAttribute("students",studentList);
        return "students";
    }
}
