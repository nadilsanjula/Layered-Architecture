module com.example.layeredarchitecture {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires java.sql;
    requires javafx.graphics;

    opens com.example.layeredarchitecture to javafx.fxml;
    opens com.example.layeredarchitecture.controller to javafx.fxml;
    opens com.example.layeredarchitecture.view.tdm to javafx.base;

    exports com.example.layeredarchitecture;
    exports com.example.layeredarchitecture.controller;
    exports com.example.layeredarchitecture.dao;
    opens com.example.layeredarchitecture.dao to javafx.fxml;
    exports com.example.layeredarchitecture.dao.custom;
    opens com.example.layeredarchitecture.dao.custom to javafx.fxml;
    exports com.example.layeredarchitecture.dao.custom.impl;
    opens com.example.layeredarchitecture.dao.custom.impl to javafx.fxml;
}
