module com.example.expense_tracker_system_ver2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;

    opens com.example.expense_tracker_system_ver2 to javafx.fxml;
    exports com.example.expense_tracker_system_ver2;
}