package com.example.expense_tracker_system_ver2.Model;

import com.example.expense_tracker_system_ver2.DAO.ExpenseDaoImpl;

import java.util.List;

public class ExpenseModel {
    private final ExpenseDaoImpl expenseDAO;

    // Constructor
    public ExpenseModel(ExpenseDaoImpl expenseDAO) {
        this.expenseDAO = expenseDAO;
    }

    // Create
    public void createExpenseModel(Expense expense) {
        expenseDAO.createExpense(expense);
    }

    // Read
    public List<Expense> readExpenses() {
        return expenseDAO.readExpenses();
    }

    // Update
    public void updateExpenseModel(Expense expense) {
        expenseDAO.updateExpense(expense);
    }

    // Delete
    public void deleteExpenseModel(int expenseId) {
        expenseDAO.deleteExpense(expenseId);
    }

    // Utility
    public float sumOfExpensesModel() {
        return expenseDAO.sumOfExpenses();
    }
}
