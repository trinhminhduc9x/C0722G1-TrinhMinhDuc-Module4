package casestudy.model.contract;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contract_detail")
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_contract_detail;
    private String quantity;
    @ManyToOne
    @JoinColumn(name = "contract_id", referencedColumnName = "id_contract")
    private Contract contract;
    @ManyToOne
    @JoinColumn(name = "attach_facility_id", referencedColumnName = "id_attach_facility")
    private AttachFacility attachFacility;
}
