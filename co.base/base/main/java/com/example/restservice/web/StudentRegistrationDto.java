package base.main.java.com.example.restservice.web;

import javax.validation.*;

import base.main.java.com.example.restservice.service.StudentService;
import base.main.java.com.example.restservice.model.Student;
import base.main.java.com.example.restservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.UserDetailsServiceConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adduser")
public class StudentRegistrationDto {


    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    private StudentService studentService;


    @ModelAttribute("student")
    public StudentRegistrationDto userRegistrationDto() {
        return new StudentRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "addstudent";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("Student") @Valid StudentRegistrationDto StudentDto,
                                      BindingResult result) {

        Student existing = (Student) getStudentService().findbyEmail((String) Student.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "Υπάρχει ήδη χρήστης στο σύστημα με το email" + Student.getEmail());
        }

        if (result.hasErrors()) {
            return "addstudent";
        }

        getStudentService().save(StudentDto);
        return "redirect:/addstudent?success";
    }

}


