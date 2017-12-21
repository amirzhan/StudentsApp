package kz.iitu.StudentsDataApp.service;

import kz.iitu.StudentsDataApp.model.EducationHistory;
import kz.iitu.StudentsDataApp.model.Faculty;
import kz.iitu.StudentsDataApp.model.Specialty;
import kz.iitu.StudentsDataApp.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    User getUserByUsernameAndPassword(String username, String password);
    void save(User user);
    void save(EducationHistory eh);
    void update(User user);
    void delete(User user);
    void delete(EducationHistory eh);
    List<User> getStudentsList();
    List <Specialty> getSpecialties();
    List <Faculty> getFaculties();
    Specialty getSpecialtyByName(String name);
    User getUserByUsername(String username);
    List <EducationHistory> getHistories();
    List <EducationHistory> getHistoriesByStudent(User student);
    EducationHistory findEhById(Long id);
}
