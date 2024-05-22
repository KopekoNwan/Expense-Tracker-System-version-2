package com.example.expense_tracker_system_ver2.DAO;

import com.example.expense_tracker_system_ver2.Model.Expense;

import java.util.List;

public interface ExpenseDao {

    // create
    void createExpense(Expense expense);

    // read
    List<Expense> readExpenses();

    // update
    void updateExpense(Expense expense);

    // delete
    void deleteExpense(int expenseId);

    // utility
    float sumOfExpenses();
}
