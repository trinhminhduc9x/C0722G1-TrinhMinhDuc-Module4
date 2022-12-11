package casestudy.model.facility;

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
@Table(name = "facility")
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String name;
    private String area;
    private String cost;
    private String maxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private String poolArea;
    private String numberOfFloors;
    private String facilityFree;

    @ManyToOne
    @JoinColumn(name = "facility_type", referencedColumnName = "id")
    private FacilityType facilityType;

    @ManyToOne
    @JoinColumn(name = "rent_type", referencedColumnName = "id")
    private RentType rentType;

    @OneToMany(mappedBy = "facility",cascade = CascadeType.REMOVE)
    @JsonBackReference
    private Set<Contract> contracts;
}
