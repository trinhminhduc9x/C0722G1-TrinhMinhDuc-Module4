package com.spring_boot.dto;

import com.spring_boot.model.Category;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.lang.annotation.Annotation;
import java.util.Date;

//@Component
public class BlogDto implements Validator {


    private int id;

    @NotBlank
    @Size(min = 5, max = 45, message = "{number.length}")
    private String name;
    @NotBlank
    @Size(min = 5, max = 45, message = "{number.length}")
    private String content;

    @Size(min = 5, max = 45, message = "{number.length}")
    private String note;
    @NotBlank
    private Date dateCreated;
    @NotBlank
    private Category category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public BlogDto() {
    }

    public BlogDto(int id, String name, String content, String note, Date dateCreated, Category category) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.note = note;
        this.dateCreated = dateCreated;
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        BlogDto blogDto = (BlogDto) target;
    }
}
