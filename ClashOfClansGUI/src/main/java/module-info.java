module com.example.clashofclansgui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.clashofclansgui to javafx.fxml;
    exports com.example.clashofclansgui;
}