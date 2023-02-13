package com.canevim.shelter.constant;

public enum AccommodationTypes {
    APARTMENT("Apartman Dairesi"),
    DETACHED_HOUSE("Müstakil Ev");

    private String label;

    AccommodationTypes(String label){
        this.label = label;
    }

    public String accommodation() {
        return this.label;
    }
}
