package com.pao.expenses.controller;

import com.pao.expenses.model.Expense;
import com.pao.expenses.service.ExpenseService;
import exceptions.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses() throws RecordNotFoundException {
        List<Expense> expenses = expenseService.getAllExpenses();
        return new ResponseEntity<>(expenses, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Expense>> getExpenseById(@PathVariable Long id) throws RecordNotFoundException {
        Optional<Expense> expense = expenseService.getExpenseById(id);
        return new ResponseEntity<>(expense, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Expense> createExpense(@RequestBody Expense requestExpense) {
        Expense expense = expenseService.createExpense(requestExpense);
        return new ResponseEntity<>(expense, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable Long id, @RequestBody Expense requestExpense) throws RecordNotFoundException {
        Expense expense = expenseService.updateExpense(id, requestExpense);
        return new ResponseEntity<>(expense, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Expense> deleteExpense(@PathVariable Long id) throws RecordNotFoundException {
        Expense expense = expenseService.deleteExpense(id);
        return new ResponseEntity<>(expense, new HttpHeaders(), HttpStatus.OK);
    }

}
