package householdmanagement.dto;


import com.fasterxml.jackson.annotation.JsonBackReference;
import householdmanagement.model.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HouseholDto implements Validator {


    private Integer idHousehol;

    @NotBlank
    @Column(columnDefinition = "DATE")
    private String startDay;

    @NotBlank
    private String address;

    private Set<Member> members;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
