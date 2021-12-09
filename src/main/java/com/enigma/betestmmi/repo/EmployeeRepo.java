package com.enigma.betestmmi.repo;

import com.enigma.betestmmi.config.HibernateConfiguration;
import com.enigma.betestmmi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class EmployeeRepo {
    private Session openSession() {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        return sessionFactory.openSession();
    }
    public List<Employee> getAllEmployee(){
        Session session = openSession();

        session.beginTransaction();
        String hql = "FROM Employee";
        List<Employee> employees = session.createQuery(hql).getResultList();

        for (Employee employee:employees) {
            System.out.println(employee);
        }
        session.close();
        return  employees;
    }

    public Employee addEmployee(Employee employee){
        Session session = openSession();

        Transaction tx = session.beginTransaction();
        session.save(employee);
        tx.commit();
        session.close();
        return employee;

    }
    public void deleteEmployeeById(Integer id){
        Session session = openSession();

        Transaction tx = session.beginTransaction();
        Employee employee = getEmployeeById(id);
        session.delete(employee);
        tx.commit();
        session.close();
        System.out.println("Employee "+id+" is deleted");
    }
    public Employee updateEmployee(Employee employee){
        Session session = openSession();

        Transaction tx = session.beginTransaction();
        session.update(employee);
        tx.commit();

        session.close();
        return employee;

    }
    public Employee getEmployeeById(Integer id){
        openSession();
        Session session = openSession();

        Transaction tx = session.beginTransaction();
        Employee employees = session.get(Employee.class, id);
        tx.commit();
        session.close();
        return employees;
    }
}
