package vn.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ClassRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_classRoom;

    private String name;

    @OneToMany(mappedBy = "classRoom")
    private Set<Student> students;

    public ClassRoom() {
    }

    public int getId_classRoom() {
        return id_classRoom;
    }

    public void setId_classRoom(int id_classRoom) {
        this.id_classRoom = id_classRoom;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
