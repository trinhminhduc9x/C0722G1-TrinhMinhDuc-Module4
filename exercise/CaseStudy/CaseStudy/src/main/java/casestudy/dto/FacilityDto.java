package casestudy.dto;

import casestudy.model.contract.Contract;
import casestudy.model.facility.FacilityType;
import casestudy.model.facility.RentType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacilityDto implements Validator {


    private Integer id;

    @NotBlank
    private String name;


    @NotBlank
    @Size(min = 1, max =3, message = "diện tích không được vượt quá 999 m2")
    private String area;


    @NotBlank
    private String cost;


    @NotBlank
    @Size(min = 1, max =2, message = "không được ở trên 100 người")
    private String maxPeople;


    @NotBlank
    private String standardRoom;


    @NotBlank
    private String descriptionOtherConvenience;


    @NotBlank
    @Size(min = 1, max =3, message = "diện tích không được vượt quá 999 m2")
    private String poolArea;


    @NotBlank
    @Size(min = 1, max =2, message = "diện tích không được vượt quá 10 tầng")
    private String numberOfFloors;


    @NotBlank
    private String facilityFree;


    private FacilityType facilityType;


    private RentType rentType;




    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
