package com.pao.expenses.service;

import com.pao.expenses.model.Expense;
import com.pao.expenses.repository.ExpenseRepository;
import exceptions.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;

    public List<Expense> getAllExpenses() throws RecordNotFoundException {
        return expenseRepository.findAll();
    }

    public Optional<Expense> getExpenseById(Long id) throws RecordNotFoundException {
        return expenseRepository.findById(Math.toIntExact(id)).map(expense -> {
            return expenseRepository.findById(Math.toIntExact(id));
        }).orElseThrow(() -> new RecordNotFoundException("Expense not found!"));
    }

    public Expense createExpense(Expense expense) { return expenseRepository.save(expense); }

    public Expense updateExpense(Long id, Expense requestExpense) throws RecordNotFoundException {
        return expenseRepository.findById(Math.toIntExact(id)).map(expense -> {
            expense.setExpenseName(requestExpense.getExpenseName());
            expense.setExpenseDescription(requestExpense.getExpenseDescription());
            expense.setExpenseAmount(requestExpense.getExpenseAmount());
            return expenseRepository.save(expense);
        }).orElseThrow(() -> new RecordNotFoundException("Expense not found!"));
    }

    public Expense deleteExpense(Long id) throws RecordNotFoundException {
            return expenseRepository.findById(Math.toIntExact(id)).map(expense -> {
                expenseRepository.delete(expense);
                return expense;
            }).orElseThrow(() -> new RecordNotFoundException("Expense not found!"));
    }
}
