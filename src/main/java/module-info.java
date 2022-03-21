module com.example.tallerpersistencia {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tallerpersistencia to javafx.fxml;
    exports com.example.tallerpersistencia;
}