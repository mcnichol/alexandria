module com.alexandria.alexandria {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;
    requires com.jfoenix;


    opens com.alexandria.alexandria to javafx.fxml;
    exports com.alexandria.alexandria;
}