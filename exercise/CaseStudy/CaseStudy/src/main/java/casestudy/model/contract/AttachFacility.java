package casestudy.model.contract;

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
@Table(name = "attach_facility")
public class AttachFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_attach_facility;
    private String name;
    private String cost;
    private String unit;
    private String status;
    @OneToMany(mappedBy = "attachFacility")
    @JsonBackReference
    private List<ContractDetail> contractDetailList;
}
