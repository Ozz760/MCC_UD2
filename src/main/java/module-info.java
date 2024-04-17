module com.mcc.ud2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.mcc.ud2 to javafx.fxml;
    exports com.mcc.ud2;
}