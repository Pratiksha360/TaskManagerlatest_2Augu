package com.franchiseworld.taskmanager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
public class Qualifications {


      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int qualificationID;


       @NotBlank(message = "Qualification Field  Blank")
        private String qualificationType;

       @NotBlank(message = "institution Field  Blank")
        private String institution;



       @Min(value = 2000,message = "Year > 2000")
       @Max(value=2999,message="Year < 2100")
       @NotNull(message = "YearOfCompletion Field Value Blank")
        private Integer yearOfCompletion;

         @Min(value = 10,message = "Min Value Not Smaller Than 10")
         @Max(value = 100,message = "Value Not Greater Than 100")
         @NotNull(message = "Percentage Field Value Blank")
        private Double percentage;


        @ManyToOne
        @JsonBackReference(value = "emp-qualifications")
        private Employees employees;

    public Qualifications() {
    }

    public Qualifications(int qualificationID, String qualificationType, String institution, Integer yearOfCompletion, Double percentage, Employees employees) {
        this.qualificationID = qualificationID;
        this.qualificationType = qualificationType;
        this.institution = institution;
        this.yearOfCompletion = yearOfCompletion;
        this.percentage = percentage;
        this.employees = employees;
    }

    public int getQualificationID() {
        return qualificationID;
    }

    public void setQualificationID(int qualificationID) {
        this.qualificationID = qualificationID;
    }

    public String getQualificationType() {
        return qualificationType;
    }

    public void setQualificationType(String qualificationType) {
        this.qualificationType = qualificationType;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public Integer getYearOfCompletion() {
        return yearOfCompletion;
    }

    public void setYearOfCompletion(Integer yearOfCompletion) {
        this.yearOfCompletion = yearOfCompletion;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }
}
