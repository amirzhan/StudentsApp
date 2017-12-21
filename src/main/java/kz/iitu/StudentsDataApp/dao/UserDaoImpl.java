package kz.iitu.StudentsDataApp.dao;

import kz.iitu.StudentsDataApp.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public void save(User student) {
        try{

            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            session.save(student);

            tr.commit();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void update(User student) {
        try{

            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            session.update(student);
            tr.commit();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void delete(User student) {
        try{

            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            session.delete(student);
            tr.commit();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public List<User> getStudentsList(){
        List<User> students = null;

        try{

            Session session = sessionFactory.openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<User> criteria = builder.createQuery(User.class);
            Root<User> studentsRoot = criteria.from(User.class);
            Predicate predicate = builder.notEqual(studentsRoot.get("username"),"admin");
            criteria.select(studentsRoot);
            criteria.where(predicate);

            students = session.createQuery(criteria).getResultList();

        }catch (Exception e){
            e.printStackTrace();
        }

        return students;
    }
    public User getUserByUsernameAndPassword(String username, String password) {
        User user = null;
        try {
            Session session = sessionFactory.openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<User> criteria = builder.createQuery(User.class);
            Root<User> studentsRoot = criteria.from(User.class);
            Predicate predicate = builder.and(builder.equal(studentsRoot.get("username"), username), builder.equal(studentsRoot.get("password"),password));
            criteria.select(studentsRoot);
            criteria.where(predicate);

            user = session.createQuery(criteria).getSingleResult();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    public User getUserByUsername(String username) {
        User user = null;
        try {
            Session session = sessionFactory.openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<User> criteria = builder.createQuery(User.class);
            Root<User> studentsRoot = criteria.from(User.class);
            Predicate predicate = builder.equal(studentsRoot.get("username"),username);
            criteria.select(studentsRoot);
            criteria.where(predicate);

            user = session.createQuery(criteria).getSingleResult();
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
        return user;
    }
}
