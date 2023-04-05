package com.pao.expenses.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "expense")
public class Expense {

    @Id
    @Column(name="expense_id")
    @GeneratedValue
    private int expenseId;
    @Column(name="expense_name")
    private String expenseName;
    @Column(name="expense_description")
    private String expenseDescription;
    @Column(name="expense_date")
    private Date expenseDate;
    @Column(name="expense_amount")
    private double expenseAmount;
}
