package com.example.validatingforminput;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created 8/3/2020 by Lucas Chapman
 * This class is used to create PersonForm objects in the WebController class for input validation
 * For more information, visit https://spring.io/guides/gs/validating-form-input/
 */
public class PersonForm {
    @NotNull    // @NotNull is used to indicate that name and age should not be left null
    @Size(min=2, max=30)    // @Size is used to determine the minimum and maximum length a name can be
    private String name;

    @NotNull
    @Min(18)    // @Min is used to determine the minimum age that is considered valid
    private Integer age;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String toString() {
        return "Person(Name: " + this.name + ", Age: " + this.age + ")";
    }
}
