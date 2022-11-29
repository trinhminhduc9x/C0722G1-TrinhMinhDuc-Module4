package sing.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class SingDto implements Validator {

    private int id;

    @NotBlank
    @Pattern(regexp = "^(\\w)+(\\s\\w*)*$", message = "Please enter name")
    @Size(min = 1, max = 800)
    @Column(name = "name")
    private  String name ;
    @NotBlank
    @Pattern(regexp = "^(\\w)+(\\s\\w*)*$", message = "Please enter artist")
    @Size(min = 1, max = 300)
    @Column(name = "artist")
    private  String artist  ;
    @NotBlank
    @Size(min = 1, max = 1000)
    @Pattern(regexp = "^[(\\w)* ,]+$", message = "Please enter kind of music")
    @Column(name = "category")
    private  String category ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }

}
