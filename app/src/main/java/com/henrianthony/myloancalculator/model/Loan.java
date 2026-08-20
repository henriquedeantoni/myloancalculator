package com.henrianthony.myloancalculator.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.henrianthony.myloancalculator.exceptions.NoArgsLoanCalculationException;

import java.time.LocalDate;
import java.util.List;

@Entity(tableName = "loans")
public class Loan {

    @PrimaryKey(autoGenerate = true)
    private Long id;
    private String name;

    private Double loanAmount;
    private Double taxRate;
    private Double instalments;
    private Integer months;
    private LocalDate opening;
    private List<Installment> installments;
    public Loan(){};

    public Loan(String name, Double loanAmount, Double taxRate, Double instalments, Integer months, LocalDate opening){
        this.name = name;
        this.loanAmount = loanAmount;
        this.instalments = instalments;
        this.taxRate = taxRate;
        this.months = months;
        this.opening = opening;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Double getInstalments() {return instalments;}

    public void setInstalments(Double instalments){this.instalments = instalments;}
    public Double getTaxRate() {
        return taxRate;
    }

    public void setTax(Double tax) {
        this.taxRate = taxRate;
    }

    public Integer getMonths() {
        return months;
    }

    public void setMonths(Integer months) {
        this.months = months;
    }

    public LocalDate getOpening() {
        return opening;
    }

    public void setOpening(LocalDate opening) {
        this.opening = opening;
    }

    public Double caulculateInstalments() throws NoArgsLoanCalculationException {
        var value=0.0;
        if(loanAmount>=0 && taxRate>=0 && months>=0){
            value = loanAmount*taxRate*(Math.pow((1+taxRate), months))/(Math.pow(1+taxRate, months)-1);
        } else {
            throw new NoArgsLoanCalculationException("Error to calculate the Instalments");
        }
        return 0.0;
    }
}
