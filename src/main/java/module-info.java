module com.example.lullaby {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lullaby to javafx.fxml;
    exports com.example.lullaby;
}