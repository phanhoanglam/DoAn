/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.QuanLyModel;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    
    public void getTime() {
        Thread timeThread = new Thread() {
            public void run() {
                try {
                    while (true) {
                        Date d = new Date();
                        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
                        SimpleDateFormat h = new SimpleDateFormat("HH-mm-ss");

                        lblTime.setText(s.format(d)    +       h.format(d));
//                        lblTime.textProperty().addListener(new ChangeListener<String>() {
//                            @Override
//                            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
////                                System.out.println("Date : " + s.format(d) + " Time : " + h.format(d));
//                                System.out.println("a"+newValue);
//                                System.out.println("b"+oldValue);
////                                lblTime.setText("Date : " + s.format(d) + " Time : " + h.format(d));
//                            }
//                        });
//                        System.out.println("Date : " + s.format(d) + " Time : " + h.format(d));
                        sleep(1000);
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(QuanLyController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        
        timeThread.start();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
        getTime();
    }
}
