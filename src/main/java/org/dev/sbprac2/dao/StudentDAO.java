package org.dev.sbprac2.dao;

import java.util.*;
import org.dev.sbprac2.entity.Student;

public interface StudentDAO {

    void save(Student student);
    Student findById(int id);
    List<Student> findAll();

}
