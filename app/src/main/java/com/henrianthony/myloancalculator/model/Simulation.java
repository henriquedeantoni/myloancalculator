package com.henrianthony.myloancalculator.model;

import java.time.LocalDate;
import java.util.UUID;

public class Simulation {
    private UUID id;

    private String title;
    private Loan loan;
    private LocalDate dataCreated;

    public Simulation(String title, Loan loan, LocalDate dataCreated) {
        this.title = title;
        this.loan = loan;
        this.dataCreated = dataCreated;
        this.id = UUID.randomUUID();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public LocalDate getDataCreated() {
        return dataCreated;
    }

    public void setDataCreated(LocalDate dataCreated) {
        this.dataCreated = dataCreated;
    }
}
