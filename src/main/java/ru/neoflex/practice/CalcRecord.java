package ru.neoflex.practice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "records")
public class CalcRecord {
    private long id;
    private String operation;
    private String firstNumber;
    private String secondNumber;
    private String result;

    public CalcRecord() {
    }

    public CalcRecord(String operation, String firstNumber, String secondNumber, String result) {
        this.operation = operation;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.result = result;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "operation", nullable = false)
    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Column(name = "first_number", nullable = false)
    public String getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(String firstNumber) {
        this.firstNumber = firstNumber;
    }

    @Column(name = "second_number", nullable = false)
    public String getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(String secondNumber) {
        this.secondNumber = secondNumber;
    }

    @Column(name = "result", nullable = false)
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
