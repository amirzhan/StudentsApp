package kz.iitu.StudentsDataApp.service;

import kz.iitu.StudentsDataApp.dao.*;
import kz.iitu.StudentsDataApp.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDAO;

    @Autowired
    private RoleDao roleDAO;

    @Autowired
    private FacultyDao facultyDAO;

    @Autowired
    private SpecialtyDao specialtyDAO;

    @Autowired
    private EducationHistoryDao educationHistoryDao;

    public void save(User user) {
        if (userDAO.getUserByUsername(user.getUsername()) != null) return;
        Role role = roleDAO.getRoleById(new Long(2));

        user.setRole(role);
        userDAO.save(user);
    }
    public void save(EducationHistory eh) {
        educationHistoryDao.save(eh);
    }
    public void update(User user) {
        userDAO.update(user);
    }
    public void delete(User user) {
        userDAO.delete(user);
    }
    public void delete(EducationHistory eh) {
        educationHistoryDao.delete(eh);
    }
    public EducationHistory findEhById(Long id) {
        return educationHistoryDao.findEhById(id);
    }

    public List<User> getStudentsList() {
        return userDAO.getStudentsList();
    }
    public List <Specialty> getSpecialties() { return specialtyDAO.getSpecialties();}
    public List <Faculty> getFaculties() { return facultyDAO.getFaculties();}
    public User getUserByUsernameAndPassword(String username, String password) {
        return userDAO.getUserByUsernameAndPassword(username,password);
    }
    public User getUserByUsername(String username) { return userDAO.getUserByUsername(username); }
    public Specialty getSpecialtyByName(String name) {
        return specialtyDAO.getSpecialtyByName(name);
    }
    public List <EducationHistory> getHistories() { return educationHistoryDao.getEducationHistories();}
    public List <EducationHistory> getHistoriesByStudent(User student) {return educationHistoryDao.getEducationHistoryByStudent(student);}

}
