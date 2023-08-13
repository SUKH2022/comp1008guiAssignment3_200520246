module com.example.comp1008summer2023thrusdays8amgui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.comp1008summer2023thrusdays8amgui to javafx.fxml;
    exports com.example.comp1008summer2023thrusdays8amgui;
}