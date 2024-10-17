package org.example.myapp.dao.daoimpl;

import org.example.myapp.dao.EmployeeDao;
import org.example.myapp.entity.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private static final Logger log = LoggerFactory.getLogger(EmployeeDaoImpl.class);
    private final SessionFactory sessionFactory;

    @Autowired
    public EmployeeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Employee findEmployeeById(int id) {
        Session session = sessionFactory.openSession();
        Employee employee = null;
        try {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Employee.class);
            criteria.add(Restrictions.eq("id", id));
            employee = (Employee) criteria.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            log.error(e.getMessage());
        } finally {
            session.close();
        }
        return employee;
    }

    @Override
    public List<Employee> findAllEmployee() {
        Session session = sessionFactory.openSession();
        List<Employee> employees = new ArrayList<>();
        try {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Employee.class);
            employees = criteria.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            log.error(e.getMessage());
        } finally {
            session.close();
        }
        return employees;
    }

    @Override
    public Integer saveEmployee(Employee employee) {
        Session session = sessionFactory.openSession();
        Integer generatedId = null;
        try {
            session.beginTransaction();
            generatedId = (Integer) session.save(employee);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            log.error(e.getMessage());
        } finally {
            session.close();
        }
        return generatedId;
    }

    @Override
    public boolean isUsernameTaken(String username) {
        Session session = sessionFactory.openSession();
        boolean isTaken = false;
        try {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Employee.class);
            criteria.add(Restrictions.eq("username", username));
            List<Employee> employees = criteria.list();
            isTaken = !employees.isEmpty();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            log.error(e.getMessage());
        } finally {
            session.close();
        }

        return isTaken;
    }

    @Override
    public boolean deleteEmployeeById(int empId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        boolean isDeleted = false;

        try{
            transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class, empId);
            if(employee != null) {
                session.delete(employee);
                isDeleted = true;
            }
            transaction.commit();
        }catch(Exception e) {
            if(transaction != null) {
                transaction.rollback(); // Rollback if any error occurs
            }
            log.error(e.getMessage());
        }finally{
            session.close();
        }
        return isDeleted;
    }

    @Override
    public void updateEmployee(Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(employee);
            tx.commit();
        }catch(Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            log.error(e.getMessage());
        }finally {
            session.close();
        }
    }

    @Override
    public Employee findEmployeeByUserName(String username) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Employee.class)
                    .add(Restrictions.eq("username", username));
            Employee employee = (Employee) criteria.uniqueResult();

            session.getTransaction().commit();

            return employee;
        }catch(Exception e){
            if(session.getTransaction()!=null) {
                session.getTransaction().rollback();
            }
            log.error(e.getMessage());
            return null;
        } finally {
            session.close();
        }
    }

}
