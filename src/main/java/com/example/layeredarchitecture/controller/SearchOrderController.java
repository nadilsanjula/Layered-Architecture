package com.example.layeredarchitecture.controller;

import com.example.layeredarchitecture.dao.custom.QueryDAO;
import com.example.layeredarchitecture.dao.custom.impl.QueryDAOImpl;
import com.example.layeredarchitecture.dto.Summary;
import com.example.layeredarchitecture.view.tdm.SummaryTM;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;

public class SearchOrderController {
    @FXML
    private TableView<SummaryTM> tblSummary;

    @FXML
    private AnchorPane root;

    @FXML
    private TableColumn<?, ?> ColCode;

    @FXML
    private TableColumn<?, ?> colCId;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colDesc;

    @FXML
    private TableColumn<?, ?> colOID;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colprice;

    @FXML
    private Label lblId;
    QueryDAO queryDAO = new QueryDAOImpl();

    public void initialize(){
        colOID.setCellValueFactory(new PropertyValueFactory<>("oid"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colCId.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        ColCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colDesc.setCellValueFactory(new PropertyValueFactory<>("desc"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colprice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
    }

    public void btnPrintOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Summary summary = queryDAO.customerItemDetails();
        tblSummary.getItems().add(new SummaryTM(
                summary.getOid(),
                summary.getDate(),
                summary.getCustomerID(),
                summary.getItemCode(),
                summary.getDesc(),
                summary.getQty(),
                summary.getUnitPrice()));
        tblSummary.refresh();
        tblSummary.getSelectionModel().getSelectedItem();
    }
    @FXML
    void backOnAction(ActionEvent event) throws IOException {
        root.getChildren().clear();
        root.getChildren().add(FXMLLoader.load(getClass().getResource("/com/example/layeredarchitecture/main-form.fxml")));
    }
}