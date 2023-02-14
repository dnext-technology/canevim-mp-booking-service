package com.canevim.shelter.constant;

public enum ShelterTypes {
    REQUESTERS("requesters"),
    OFFERERS("offerers");

    private String label;

    ShelterTypes(String label){
        this.label = label;
    }

    public String label() {
        return this.label;
    }
}
