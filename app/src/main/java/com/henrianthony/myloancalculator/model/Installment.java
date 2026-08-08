package com.henrianthony.myloancalculator.model;

import java.time.LocalDate;
import java.util.UUID;

public class Installment {
    private UUID id;
    private Integer month;
    private Double value;
    private LocalDate payDueDate;

    public Installment(Integer month, Double value, LocalDate payDueDate){
        this.id = UUID.randomUUID();
        this.month = month;
        this.value = value;
        this.payDueDate = payDueDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public LocalDate getPayDueDate() {
        return payDueDate;
    }

    public void setPayDueDate(LocalDate payDueDate) {
        this.payDueDate = payDueDate;
    }
}
