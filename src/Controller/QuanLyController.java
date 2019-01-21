/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.QuanLyModel;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class QuanLyController implements Initializable {

    private ObservableList<QuanLyModel> listProduct = FXCollections.observableArrayList();

    private ObservableList<String> listComboboxCategory = FXCollections.observableArrayList();

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
    @FXML
    private RadioButton rdMaleUser;
    @FXML
    private RadioButton rdFamaleUser;
    @FXML
    private RadioButton rdAdminUser;
    @FXML
    private RadioButton rdEmployeeUser;

    private ToggleGroup toggle;

    @FXML
    private ComboBox<String> cbb_Category;

    public HashMap<String, Integer> hashmapComboboxCategory;

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

    @FXML
    private void click_Logout(MouseEvent event) throws IOException {
        taskDate.cancel();
        taskTime.cancel();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXML/Login.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(getClass().getResource("/Css/Login.css").toExternalForm());
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    void click_btnStartIntime() {
        lblSalesOuttime.setText(null);
        lblSalesIntime.setText(lblDate.getText() + " " + lblTime.getText());
    }

    void click_btnFinishOuttime() {
        lblSalesOuttime.setText(lblDate.getText() + " " + lblTime.getText());
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
                SimpleDateFormat h = new SimpleDateFormat("HH:mm:ss");
                updateMessage(h.format(d));
                Thread.sleep(1000);
            }
        }

        @Override
        protected void updateMessage(String message) {
            super.updateMessage(message);
        }
    };

    public void group_RadioGenderUsers() {
        toggle = new ToggleGroup();
        rdMaleUser.setToggleGroup(toggle);
        rdFamaleUser.setToggleGroup(toggle);
        rdMaleUser.setSelected(true);
    }

    public void group_RadioRoleUsers() {
        toggle = new ToggleGroup();
        rdAdminUser.setToggleGroup(toggle);
        rdEmployeeUser.setToggleGroup(toggle);
        rdAdminUser.setSelected(true);
    }

    public void addValue_ComboboxCategory() throws ClassNotFoundException, SQLException {
        hashmapComboboxCategory = new HashMap<>();
        Connection conn = Connect.ConnectDB.connectSQLServer();
        String sql = "Select category_id, name from Category";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            hashmapComboboxCategory.put(rs.getString("name"), rs.getInt("category_id"));
        }
        for (String key : hashmapComboboxCategory.keySet()) {
            listComboboxCategory.add(key);
        }
        cbb_Category.setItems(listComboboxCategory);
    }

    @FXML
    private void click_ComboboxCategory(ActionEvent event) throws ClassNotFoundException, SQLException {
        idcol.setCellValueFactory(new PropertyValueFactory<>("id"));
        namecol.setCellValueFactory(new PropertyValueFactory<>("name"));
        pricecol.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantitycol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
//
        Connection conn = Connect.ConnectDB.connectSQLServer();
        String sql = "Select storage_item_id, name, price, quantity from Storage Where category_id = ?";
        PreparedStatement pre = conn.prepareStatement(sql);
        pre.setInt(1, hashmapComboboxCategory.get(cbb_Category.getValue()));
        ResultSet rs = pre.executeQuery();
        int i = 1;
        listProduct.removeAll(listProduct);
        while (rs.next()) {
            QuanLyModel model = new QuanLyModel(i++, rs.getString("name"), rs.getFloat("price"), rs.getInt("quantity"));
            listProduct.add(model);
        }
        tableItems.setItems(listProduct);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblDate.textProperty().bind(taskDate.messageProperty());
        lblTime.textProperty().bind(taskTime.messageProperty());
        new Thread(taskDate).start();
        new Thread(taskTime).start();

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

        group_RadioGenderUsers();
        group_RadioRoleUsers();

        try {
            addValue_ComboboxCategory();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuanLyController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
