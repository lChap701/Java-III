package com.example.handlingformsubmission;

/**
 * Created 8/3/2020 by Lucas Chapman
 * This program is used to demonstrate the handling of form submissions
 * This class is used to create Greeting objects in the GreetingController class
 * For more information, visit https://spring.io/guides/gs/handling-form-submission/
 */
public class Greeting {
    private long id;
    private String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}