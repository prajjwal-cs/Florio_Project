module io.github.prajjwal.florio_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.slf4j;


    opens io.github.prajjwal.florio_project to javafx.fxml;
    exports io.github.prajjwal.florio_project;
    exports io.github.prajjwal.florio_project.controller;
    opens io.github.prajjwal.florio_project.controller to javafx.fxml;
}