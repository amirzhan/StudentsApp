package kz.iitu.StudentsDataApp.dao;

import kz.iitu.StudentsDataApp.model.User;

import java.util.List;

public interface UserDao {
    User getUserByUsername(String username);
    User getUserByUsernameAndPassword(String username, String password);
    void save(User student);
    void update(User student);
    void delete(User student);
    List<User> getStudentsList();
}
