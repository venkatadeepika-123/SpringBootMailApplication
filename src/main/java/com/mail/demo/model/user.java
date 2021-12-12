package com.mail.demo.model;

import org.springframework.stereotype.Component;

@Component
public class user {
    private String emailId;

    public String getEmailId(){
        return emailId;
    }

    public void setEmailId(String emailId){
        this.emailId = emailId;
    }
}
