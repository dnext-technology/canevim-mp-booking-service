package com.zorgundostu.shelter.constant;

public enum StatusTypes {
    ACTIVE("active"),
    IN_PROGRESS("inProgress"),
    PASSIVE("passive"),
    COMPLETED("completed");

    private String status;

    StatusTypes(String status){
        this.status = status;
    }

    public String status() {
        return this.status;
    }
}
