package moviemanager.model;

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
@Table(name = "premiere")
public class Premiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPremiere;


    @Column(columnDefinition = "DATE")
    private String dayPremiere;

    private String numberPremiere;
    @ManyToOne()
    @JoinColumn(name = "premiere_id",referencedColumnName = "idMovie")
    private Movie movie;
}
