package kz.iitu.StudentsDataApp.dao;


import kz.iitu.StudentsDataApp.model.EducationHistory;
import kz.iitu.StudentsDataApp.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class EducationHistoryDaoImpl implements EducationHistoryDao {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public EducationHistory findEhById(Long id) {
        EducationHistory eh = null;

        try{

            Session session = sessionFactory.openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<EducationHistory> criteria = builder.createQuery(EducationHistory.class);
            Root<EducationHistory> ehsRoot = criteria.from(EducationHistory.class);
            Predicate predicate = builder.equal(ehsRoot.get("id"),id);
            criteria.select(ehsRoot);
            criteria.where(predicate);

            eh = session.createQuery(criteria).getSingleResult();

        }catch (Exception e){
            e.printStackTrace();
        }

        return eh;
    }
    public void save(EducationHistory eh) {
        try{

            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            session.save(eh);
            tr.commit();


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void update(EducationHistory eh) {
        try{

            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            session.update(eh);
            tr.commit();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void delete(EducationHistory eh) {
        try{

            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            session.delete(eh);
            tr.commit();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public List<EducationHistory> getEducationHistoryByStudent(User student) {
        List<EducationHistory> ehList = null;

        try{

            Session session = sessionFactory.openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<EducationHistory> criteria = builder.createQuery(EducationHistory.class);
            Root<EducationHistory> ehsRoot = criteria.from(EducationHistory.class);
            Predicate predicate = builder.equal(ehsRoot.get("student"),student);
            criteria.select(ehsRoot);
            criteria.where(predicate);

            ehList = session.createQuery(criteria).getResultList();

        }catch (Exception e){
            e.printStackTrace();
        }

        return ehList;
    }
    public List<EducationHistory> getEducationHistories() {
        List<EducationHistory> ehList = null;

        try{

            Session session = sessionFactory.openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<EducationHistory> criteria = builder.createQuery(EducationHistory.class);
            Root<EducationHistory> ehsRoot = criteria.from(EducationHistory.class);

            criteria.select(ehsRoot);

            ehList = session.createQuery(criteria).getResultList();

        }catch (Exception e){
            e.printStackTrace();
        }

        return ehList;
    }
}
