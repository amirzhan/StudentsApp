package kz.iitu.StudentsDataApp.dao;

import kz.iitu.StudentsDataApp.model.Faculty;
import kz.iitu.StudentsDataApp.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class FacultyDaoImpl implements FacultyDao {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Faculty> getFaculties() {
        List <Faculty> faculties=null;
        try {
            Session session = sessionFactory.openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<Faculty> criteria = builder.createQuery(Faculty.class);
            Root<Faculty> facultyRoot = criteria.from(Faculty.class);
            criteria.select(facultyRoot);

            faculties = session.createQuery(criteria).getResultList();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return faculties;
    }
}
