package kz.iitu.StudentsDataApp.dao;

import kz.iitu.StudentsDataApp.model.Specialty;

import java.util.List;

public interface SpecialtyDao {
    List<Specialty> getSpecialties();
    Specialty getSpecialtyByName(String name);
}
