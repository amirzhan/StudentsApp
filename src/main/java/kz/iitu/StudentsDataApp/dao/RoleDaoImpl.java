package kz.iitu.StudentsDataApp.dao;

import kz.iitu.StudentsDataApp.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class RoleDaoImpl implements RoleDao {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Role getRoleById(Long id) {
        Role role = null;
        try {
            Session session = sessionFactory.openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<Role> criteria = builder.createQuery(Role.class);
            Root<Role> roleRoot = criteria.from(Role.class);
            Predicate predicate = builder.equal(roleRoot.get("id"),id);
            criteria.select(roleRoot);
            criteria.where(predicate);
            role = session.createQuery(criteria).getSingleResult();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return role;
    }
}
