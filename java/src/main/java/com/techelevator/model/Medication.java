package com.techelevator.model;

public class Medication {

    private int medicationId;
    private String medicationName;
    private String description;
    private String dosage;

    public Medication(int medicationId, String medicationName, String description, String dosage) {
        this.medicationId = medicationId;
        this.medicationName = medicationName;
        this.description = description;
        this.dosage = dosage;
    }

    public int getMedicationId() {
        return medicationId;
    }

    public void setMedicationId(int medicationId) {
        this.medicationId = medicationId;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }
}
