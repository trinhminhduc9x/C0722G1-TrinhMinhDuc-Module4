package casestudy.model.employee;

import casestudy.model.contract.Contract;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    @Column(columnDefinition = "DATE")
    private String dateOfBirth;
    private String idCard;
    private String salary;
    private String phoneNumber;
    private String email;
    private String address;

    @ManyToOne
    @JoinColumn(name = "position_id",referencedColumnName = "id")
    private Position position;
    @ManyToOne
    @JoinColumn(name = "division_id",referencedColumnName = "id")
    private Division division;
    @ManyToOne
    @JoinColumn(name = "education_degree_id",referencedColumnName = "id")
    private EducationDegree educationDegree;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.REMOVE)
    @JsonBackReference
    private Set<Contract> contracts;
}
