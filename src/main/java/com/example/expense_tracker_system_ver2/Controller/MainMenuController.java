package com.example.expense_tracker_system_ver2.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import static com.example.expense_tracker_system_ver2.View.ViewLoader.*;

public class MainMenuController {

    @FXML
    Button add_expense_button;

    // This functions re-direct the User to a different Page
    // where the User adds a new amount of expense
    @FXML
    public void displayAddExpenseView() {
        stage.setScene(addExpenseViewScene);
    }

}
