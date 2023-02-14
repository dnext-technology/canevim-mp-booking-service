package com.canevim.shelter.model.notification;

import java.util.List;

import lombok.Data;

@Data
public class Sms {
    private String username;
    private String password;
    private String vendor;
    private String header;
    private String message;
    private List<String> gsmList;
    private String charset;
    private String startdate;
    private String exdate;
}
