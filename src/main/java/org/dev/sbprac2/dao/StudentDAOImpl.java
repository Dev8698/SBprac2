package org.dev.sbprac2.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.dev.sbprac2.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{
    private final EntityManager entityManager;

    @Override
    @Transactional
    public List<Student> findAll() {

        TypedQuery<Student> query = entityManager.createQuery("FROM Student order by lastName", Student.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public List<Student> findByName(String firstName) {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student where firstName = :firstName", Student.class);
        query.setParameter("firstName", firstName);
        return query.getResultList();
    }

    @Override
    public List<Student> findByEmail(String email) {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student where email = :email", Student.class);
        query.setParameter("email", email);
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student where lastName = :lastName", Student.class);
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }


    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    @Transactional
    public Student findById(int id) {

        return entityManager.find(Student.class, id);
    }
}
