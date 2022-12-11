package casestudy.dto;

import casestudy.model.customer.CustomerType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto implements Validator {

    private Integer id;

    @Size(min = 5, max = 45)
    private String name;
    private String dateOfBirth;
    private String gender;
    @NotBlank
    @Pattern(regexp = "[0-9]{9}",
            message = "chứng minh nhân dân có 9 chữ số")
    @Size(min = 1, max = 800)
    private String idCard;
    @NotBlank
    @Pattern(regexp = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$",
            message = "điền số điện thoại bắt đầu bằng 0 hoặc 84 ")
    @Size(min = 1, max = 800)
    private String phoneNumber;
    @NotBlank
    @Pattern(regexp = "^(\\w+)@(\\w+)$",
            message = "điền email theo dang abc@abc ")
    @Size(min = 1, max = 800)
    private String email;
    private String address;

    private String id_delete;

    private CustomerType customerType;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
