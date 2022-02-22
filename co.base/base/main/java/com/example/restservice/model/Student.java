package base.main.java.com.example.restservice.model;
import java.util.Collection;
import javax.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String first_name;
    private String last_name;
    private static String email;
    private String password;

    public Student(){

    }


    public Student(String first_name, String last_name, String email, String password){
        this.first_name = first_name;
        this.last_name = last_name;
        Student.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public  String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public static String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
