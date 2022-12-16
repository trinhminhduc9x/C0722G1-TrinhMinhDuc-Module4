package householdmanagement.model;

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
@Table(name = "househol")
public class Househol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHousehol;
    private String numberMember;
    @Column(columnDefinition = "DATE")
    private String startDay;
    private String address;


    @OneToMany(mappedBy = "househol",cascade = CascadeType.REMOVE)
    @JsonBackReference
    private Set<Member> members;
}
