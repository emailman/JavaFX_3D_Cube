module com.example.cube {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    opens com.example.cube to javafx.fxml;
    exports com.example.cube;
}