package com.example.expense_tracker_system_ver2.Controller;

import com.example.expense_tracker_system_ver2.DAO.ExpenseDaoImpl;
import com.example.expense_tracker_system_ver2.Model.Expense;
import com.example.expense_tracker_system_ver2.Model.ExpenseModel;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.time.LocalDate;
import java.util.List;
import static com.example.expense_tracker_system_ver2.View.ViewLoader.mainMenuViewScene;
import static com.example.expense_tracker_system_ver2.View.ViewLoader.stage;

public class AddExpenseController {

    private final ExpenseDaoImpl expenseDao = new ExpenseDaoImpl();
    private final ExpenseModel expenseModel = new ExpenseModel(expenseDao);

    @FXML
    TextField amountTextField;

    @FXML
    ChoiceBox categoryChoiceBox;

    @FXML
    TextArea descriptionTextField;

    @FXML
    public void returnMainMenuView() {
        stage.setScene(mainMenuViewScene);
    }

    @FXML
    public Expense getValues() {
        LocalDate currentDate = LocalDate.now();
        String dateString = currentDate.toString();
        float amount = Float.parseFloat(amountTextField.getText());
        String category = (String) categoryChoiceBox.getValue();
        String description = descriptionTextField.getText();
        List<Expense> expenses = expenseModel.readExpenses();
        int id = 0;
        for(Expense e : expenses) {
            id++;
        }
        return new Expense(id, dateString, amount, category, description);
    }

    @FXML
    public void confirmNewExpense() {
        expenseModel.createExpenseModel(getValues());
    }
}
