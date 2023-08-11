module com.example.osapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires jbcrypt;


    opens com.example.osapp to javafx.fxml, com.fasterxml.jackson.databind;
    exports com.example.osapp;

}