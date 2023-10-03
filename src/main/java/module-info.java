module com.example.philosophermultithred {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.philosophermultithred to javafx.fxml;
    exports com.example.philosophermultithred;
}