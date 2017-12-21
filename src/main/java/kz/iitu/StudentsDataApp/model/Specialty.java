package kz.iitu.StudentsDataApp.model;


import javax.persistence.*;

@Entity
@Table(name="specialty")
public class Specialty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="specialty_id")
    private Long id;

    @Column(name="specialty_name", unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name="faculty_id")
    private Faculty faculty;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Specialty() {

    }

    public Specialty(String name, Faculty faculty) {

        this.name = name;
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Specialty{" +
                "name='" + name + '\'' +
                '}';
    }
}
