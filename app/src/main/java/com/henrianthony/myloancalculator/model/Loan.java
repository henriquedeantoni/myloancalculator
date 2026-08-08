package com.henrianthony.myloancalculator.model;

import java.util.UUID;

public class Loan {
    private UUID id;
    private String name;

    private Double loanAmount;
    private Double tax;
    private Integer months;

    public Loan(){};

    public Loan(String name, Double loanAmount, Double tax, Integer months){
        this.id = UUID.randomUUID();
        this.name = name;
        this.loanAmount = loanAmount;
        this.tax = tax;
        this.months = months;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Integer getMonths() {
        return months;
    }

    public void setMonths(Integer months) {
        this.months = months;
    }
}
