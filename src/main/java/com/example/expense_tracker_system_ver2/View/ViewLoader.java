package com.example.expense_tracker_system_ver2.View;

import com.example.expense_tracker_system_ver2.Main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewLoader extends Application {

    public static FXMLLoader addExpenseViewLoader;
    public static Scene addExpenseViewScene;
    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        ViewLoader.stage = primaryStage;
        // Load the MainMenuView page
        FXMLLoader mainMenuLoader = new FXMLLoader(Main.class.getResource("MainMenuView.fxml"));
        Parent mainMenuRoot = mainMenuLoader.load();
        Scene mainMenuScene = new Scene(mainMenuRoot);
        primaryStage.setTitle("Expense Tracker ver2");
        primaryStage.setScene(mainMenuScene);
        primaryStage.show();

        // Load the AddExpenseView file
        FXMLLoader addExpenseViewLoader = new FXMLLoader(Main.class.getResource("AddExpenseView.fxml"));
        Parent addExpenseViewRoot = addExpenseViewLoader.load();
        ViewLoader.addExpenseViewScene = new Scene(addExpenseViewRoot);
        ViewLoader.addExpenseViewLoader = addExpenseViewLoader;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
