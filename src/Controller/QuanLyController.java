/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.QuanLyModel;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.WeakChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class QuanLyController implements Initializable {

    private ObservableList<QuanLyModel> listProduct = FXCollections.observableArrayList();

    @FXML
    private TableView<QuanLyModel> tableItems;

    @FXML
    private TableColumn<QuanLyModel, Integer> idcol;

    @FXML
    private TableColumn<QuanLyModel, String> namecol;

    @FXML
    private TableColumn<QuanLyModel, Integer> quantitycol;

    @FXML
    private TableColumn<QuanLyModel, Float> pricecol;

    @FXML
    private Label labelItems;

    @FXML
    private Label labelSales;

    @FXML
    private Label labelUsers;

    @FXML
    private Label labelLogout;

    @FXML
    private StackPane SalesStack;

    @FXML
    private StackPane ItemsStack;

    @FXML
    private StackPane UsersStack;
    @FXML
    private Label lblTime;
    @FXML
    private Label lblDate;
    @FXML
    private Button btnSalesStart;
    @FXML
    private Label lblSalesIntime;
    @FXML
    private Label lblSalesOuttime;
    @FXML
    private Button btnSalesFinish;

    void click_Sales() {
        labelSales.setDisable(true);
        labelItems.setDisable(false);
        labelUsers.setDisable(false);
        SalesStack.setVisible(true);
        ItemsStack.setVisible(false);
        UsersStack.setVisible(false);
    }

    void click_Items() {
        labelSales.setDisable(false);
        labelItems.setDisable(true);
        labelUsers.setDisable(false);
        SalesStack.setVisible(false);
        ItemsStack.setVisible(true);
        UsersStack.setVisible(false);
    }

    void click_Users() {
        labelSales.setDisable(false);
        labelItems.setDisable(false);
        labelUsers.setDisable(true);
        SalesStack.setVisible(false);
        ItemsStack.setVisible(false);
        UsersStack.setVisible(true);
    }
    
    void click_btnStartIntime() {
        lblSalesOuttime.setText(null);
        lblSalesIntime.setText(lblTime.getText());
    }
    
    void click_btnFinishOuttime() {
        lblSalesOuttime.setText(lblTime.getText());
    }

    Task<Time> taskDate = new Task<Time>() {
        @Override
        protected Time call() throws Exception {
            while (true) {
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
                updateMessage(s.format(d));
                Thread.sleep(1000);
            }
        }

        @Override
        protected void updateMessage(String message) {
            super.updateMessage(message);
        }

    };

    Task<Time> taskTime = new Task<Time>() {
        @Override
        protected Time call() throws Exception {
            while (true) {
                Date d = new Date();
                SimpleDateFormat h = new SimpleDateFormat("HH-mm-ss");
                updateMessage(h.format(d));
                Thread.sleep(1000);
            }
        }

        @Override
        protected void updateMessage(String message) {
            super.updateMessage(message);
        }
    };

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblDate.textProperty().bind(taskDate.messageProperty());
        lblTime.textProperty().bind(taskTime.messageProperty());
        new Thread(taskDate).start();
        new Thread(taskTime).start();

        idcol.setCellValueFactory(new PropertyValueFactory<>("id"));
        namecol.setCellValueFactory(new PropertyValueFactory<>("name"));
        pricecol.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantitycol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
//
        QuanLyModel model = new QuanLyModel();
        model.setId(1);
        model.setName("Pepsi");
        model.setPrice(12000);
        model.setQuantity(1);
//
        listProduct.add(model);
        tableItems.setItems(listProduct);

        labelSales.setOnMouseClicked((event) -> {
            click_Sales();
        });
        labelItems.setOnMouseClicked((event) -> {
            click_Items();
        });
        labelUsers.setOnMouseClicked((event) -> {
            click_Users();
        });
        
        btnSalesStart.setOnMouseClicked((event) -> {
            click_btnStartIntime();
        });
        btnSalesFinish.setOnMouseClicked((event) -> {
            click_btnFinishOuttime();
        });
    }

}
