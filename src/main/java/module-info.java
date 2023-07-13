module com.example.commandgenerator {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.commandgenerator to javafx.fxml;
    exports com.example.commandgenerator;
}