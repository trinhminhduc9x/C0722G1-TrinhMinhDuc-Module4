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
@Table(name = "memberType")
public class MemberType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMemberType;

    private String nameType;

    @OneToMany(mappedBy = "memberType",cascade = CascadeType.REMOVE)
    @JsonBackReference
    private Set<Member> members;
}
