package kz.iitu.StudentsDataApp.model;


import javax.persistence.*;

@Entity
@Table(name="faculty")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="faculty_id")
    private Long id;


    @Column(name="faculty_name", unique = true)
    private String name;

    public Faculty() {
    }

    public Faculty(String name) {

        this.name = name;
    }
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

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                '}';
    }
}
