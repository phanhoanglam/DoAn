/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.QuanLyModel;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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

    }

}
