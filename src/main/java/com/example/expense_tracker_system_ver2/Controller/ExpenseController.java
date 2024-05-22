package com.example.expense_tracker_system_ver2.Controller;

import com.example.expense_tracker_system_ver2.DAO.ExpenseDao;
import com.example.expense_tracker_system_ver2.DAO.ExpenseDaoImpl;

public class ExpenseController {
    private ExpenseDao expenseDao;

    public ExpenseController() {
        this.expenseDao = new ExpenseDaoImpl();
    }

    public void createExpenseController() {

    }
}
