package casestudy.model.customer;

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
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(columnDefinition = "DATE")
    private String dateOfBirth;

    private String gender;
    private String idCard;
    private String phoneNumber;
    private String email;
    private String address;

    @ManyToOne()
    @JoinColumn(name = "customer_Type_Id", referencedColumnName = "id")
    @JsonBackReference
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.REMOVE)
    @JsonBackReference
    private Set<Contract> contracts;
}
