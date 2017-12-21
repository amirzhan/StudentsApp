package kz.iitu.StudentsDataApp.dao;

import kz.iitu.StudentsDataApp.model.Faculty;
import kz.iitu.StudentsDataApp.model.Specialty;
import kz.iitu.StudentsDataApp.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class SpecialtyDaoImpl implements SpecialtyDao{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public List<Specialty> getSpecialties() {
        List <Specialty> specialties=null;
        try {
            Session session = sessionFactory.openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<Specialty> criteria = builder.createQuery(Specialty.class);
            Root<Specialty> specialtyRoot = criteria.from(Specialty.class);
            criteria.select(specialtyRoot);

            specialties = session.createQuery(criteria).getResultList();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return specialties;
    }
    public Specialty getSpecialtyByName(String name) {
        Specialty specialty = null;
        try {
            Session session = sessionFactory.openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<Specialty> criteria = builder.createQuery(Specialty.class);
            Root<Specialty> specialtyRoot = criteria.from(Specialty.class);
            Predicate predicate = builder.equal(specialtyRoot.get("name"),name);
            criteria.select(specialtyRoot);
            criteria.where(predicate);

            specialty = session.createQuery(criteria).getSingleResult();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return specialty;
    }
}
