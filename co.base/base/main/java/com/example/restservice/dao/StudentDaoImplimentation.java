package base.main.java.com.example.restservice.dao;

import base.main.java.com.example.restservice.model.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import org.hibernate.query.Query;
import javax.transaction.Transactional;
import java.util.List;
@Repository
public class StudentDaoImplimentation implements StudentDao{



    private SessionFactory sessionF;


    @Override
    @Transactional
    public List<Student> getterStudents() {
        //getting hibernate session
        Session curSession= sessionF.getCurrentSession();

        Query query = (Query) curSession.createQuery("fr Student",Student.class);

        List students = query.getResultList();
        return null;
    }
    public SessionFactory getSessionF() {
        return sessionF;
    }

    public void setSessionF(SessionFactory sessionF) {
        this.sessionF = sessionF;
    }

}
