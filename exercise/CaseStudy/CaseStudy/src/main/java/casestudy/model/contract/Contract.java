package casestudy.model.contract;

import casestudy.model.customer.Customer;
import casestudy.model.employee.Employee;
import casestudy.model.facility.Facility;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_contract;
    @Column(columnDefinition = "DATE")
    private String startDate;
    @Column(columnDefinition = "DATE")
    private String endDate;
    private String deposit;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id_customer")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id_employee")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "facility_id", referencedColumnName = "id_facility")
    private Facility facility;

    @OneToMany(mappedBy = "contract",cascade = CascadeType.REMOVE)
    @JsonBackReference
    private List<ContractDetail> contractDetailList;
}
