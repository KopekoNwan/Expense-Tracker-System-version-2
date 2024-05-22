package com.example.expense_tracker_system_ver2.DAO;

import com.example.expense_tracker_system_ver2.Model.Expense;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDaoImpl implements ExpenseDao {
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

    @Override
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

    @Override
    public List<Expense> readExpenses() {
        String sql = "SELECT expenses.name AS expense_name, expenses.date, expenses.amount, categories.name AS category_name " +
                "FROM expenses " +
                "JOIN categories ON expenses.category = categories.name";
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
        String sql = "UPDATE expenses SET date = ?, amount = ?, category = ?, description = ? WHERE id = ?";
        try(PreparedStatement preparedStatement = this.connection().prepareStatement(sql)) {
            preparedStatement.setString(1, expense.getDate());
            preparedStatement.setFloat(2, expense.getAmount());
            preparedStatement.setString(3, expense.getCategory());
            preparedStatement.setString(4, expense.getDescription());
            preparedStatement.setInt(5, expense.getId());
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteExpense(int expenseId) {
        String sql = "DELETE FROM expenses WHERE id = ?";
        try(PreparedStatement preparedStatement = this.connection().prepareStatement(sql)) {
            preparedStatement.setInt(1, expenseId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public float sumOfExpenses() {
        String sql = "SELECT amount FROM expenses";
        float totalExpense = 0f;
        try(Connection connection = this.connection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
               float expenseAmount = resultSet.getFloat("amount");
               totalExpense += expenseAmount;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return totalExpense;
    }

}