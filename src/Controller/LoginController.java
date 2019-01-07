/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class LoginController implements Initializable {

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    private Label lblUsername;

    @FXML
    private Label lblPassword;

//    @FXML
//    void submitLogin(ActionEvent event) throws IOException {
////        Stage primaryStage = new Stage();
////        Parent root = FXMLLoader.load(getClass().getResource("/FXML/QuanLy.fxml"));
////        Scene scene = new Scene(root);
////        scene.getStylesheets().add(getClass().getResource("/Css/QuanLy.css").toExternalForm());
////        primaryStage.setScene(scene);
////        primaryStage.show();
//    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
