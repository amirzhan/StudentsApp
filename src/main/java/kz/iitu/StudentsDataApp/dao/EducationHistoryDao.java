package kz.iitu.StudentsDataApp.dao;

import kz.iitu.StudentsDataApp.model.EducationHistory;
import kz.iitu.StudentsDataApp.model.Specialty;
import kz.iitu.StudentsDataApp.model.User;

import java.util.List;

public interface EducationHistoryDao {
    void save(EducationHistory eh);
    void update(EducationHistory eh);
    void delete(EducationHistory eh);
    EducationHistory findEhById(Long id);
    List<EducationHistory> getEducationHistoryByStudent(User student);
    List <EducationHistory> getEducationHistories();
}
