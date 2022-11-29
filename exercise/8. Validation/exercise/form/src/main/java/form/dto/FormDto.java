package form.dto;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import javax.validation.constraints.*;

@Component
public class FormDto implements Validator {
    private int id;

    @Size(min = 5, max = 45, message = "{number.length}")
    private  String firstName ;

    @Size(min = 5, max = 45, message = "{number.length}")
    private  String lastName  ;

    @NotBlank
    @Pattern(regexp = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$",
            message = "điền số điện thoại bắt đầu bằng 0 hoặc 84 ")
    @Size(min = 1, max = 800)
    private  String phoneNumber ;

    @Pattern(regexp = "^(\\d{2})$",
            message = "điền số tuoi la hai chu so ")
    @Size(min = 1, max = 2)
    private String Age  ;

    @NotBlank
    @Pattern(regexp = "^(\\w+)@(\\w+)$",
            message = "điền email theo dang abc@abc ")
    @Size(min = 1, max = 800)
    private  String Email  ;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FormDto formDto = (FormDto) target;
        String age = formDto.getAge();
        if (Integer.parseInt(age) <= 0) {
            errors.rejectValue("age","age.old","ban dien dung so tuoi");
        }

    }
}
