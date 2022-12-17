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
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMember;
    private String name;
    private String idCard;
    @Column(columnDefinition = "DATE")
    private String dateOfBirth;

    @ManyToOne()
    @JoinColumn(name = "member_Type_Id", referencedColumnName = "idMemberType")
    private MemberType memberType;


    @OneToMany(mappedBy = "member",cascade = CascadeType.REMOVE)
    @JsonBackReference
    private Set<Househol> househols;
}
