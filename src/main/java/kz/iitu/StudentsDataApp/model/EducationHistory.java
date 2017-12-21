package kz.iitu.StudentsDataApp.model;


import javax.persistence.*;

@Entity
@Table(name="education_history")
public class EducationHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="education_history_id")
    private Long id;

    @Column(name="educated_place_name")
    private String educationPlace;

    @Column(name="during_time")
    private String duringTime;

    @Column(name="address")
    private String address;

    @ManyToOne
    @JoinColumn(name="student_id")
    private User student;

    public EducationHistory() {
    }

    public EducationHistory(String educationPlace, String duringTime, String address, User student) {
        this.educationPlace = educationPlace;
        this.duringTime = duringTime;
        this.address = address;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEducationPlace() {
        return educationPlace;
    }

    public void setEducationPlace(String educationPlace) {
        this.educationPlace = educationPlace;
    }

    public String getDuringTime() {
        return duringTime;
    }

    public void setDuringTime(String duringTime) {
        this.duringTime = duringTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "EducationHistory{" +
                "educationPlace='" + educationPlace + '\'' +
                ", duringTime='" + duringTime + '\'' +
                ", address='" + address + '\'' +
                ", student=" + student.getUsername() +
                '}';
    }
}
