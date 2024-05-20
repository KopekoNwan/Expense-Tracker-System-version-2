package com.example.expense_tracker_system_ver2.Model;

import com.example.expense_tracker_system_ver2.DAO.ExpenseDAO;

import java.util.List;

public class ExpenseModel {
    private final ExpenseDAO expenseDAO;

    // Constructor
    public ExpenseModel(ExpenseDAO expenseDAO) {
        this.expenseDAO = expenseDAO;
    }

    // Create
    public void createExpense(Expense expense) {
        expenseDAO.createExpense(expense);
    }

    // Read
    public List<Expense> readExpenses() {
        return expenseDAO.readExpenses();
    }

    // Update
    public void updateExpense(Expense expense) {
        expenseDAO.updateExpense(expense);
    }

    // Delete
    public void deleteExpense(int expenseId) {
        expenseDAO.deleteExpense(expenseId);
    }

    // Utility
    public float sumOfExpenses() {
        return expenseDAO.sumOfExpenses();
    }
}
