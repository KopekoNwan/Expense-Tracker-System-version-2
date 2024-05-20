package com.example.expense_tracker_system_ver2.DAO;

import com.example.expense_tracker_system_ver2.Model.Expense;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDAO implements ExpenseDaoInterface{
    private Connection connection() {
        String url = "jdbc:sqlite:expenses.db";
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public void createExpense(Expense expense) {
        String sql = "INSERT INTO expenses(date, amount, category, description) VALUES(?, ?)";
        try(Connection connection = this.connection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, expense.getDate());
            preparedStatement.setFloat(2, expense.getAmount());
            preparedStatement.setString(3, expense.getCategory());
            preparedStatement.setString(4, expense.getDescription());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Expense> readExpenses() {
        String sql = "SELECT id, date, amount, category, description FROM expenses";
        List<Expense> expenses = new ArrayList<>();
        try(Connection connection = this.connection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Expense expense = new Expense(resultSet.getInt("id"), resultSet.getString("date"),
                        resultSet.getFloat("amount"), resultSet.getString("category"), resultSet.getString("description"));
                expense.setId(resultSet.getInt("id"));
                expenses.add(expense);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return expenses;
    }

    @Override
    public void updateExpense(Expense expense) {

    }

    @Override
    public void deleteExpense(Expense expense) {

    }

    @Override
    public int sumOfExpenses() {
        return 0;
    }


}
