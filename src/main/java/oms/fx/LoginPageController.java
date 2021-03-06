package oms.fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import oms.model.Datasource;
import oms.model.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class LoginPageController implements Initializable {

    @FXML
    public Button btnLogin;
    public Label loginInfo;
    @FXML
    private TextField loginEmail;
    @FXML
    private PasswordField loginPassword;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void login(ActionEvent event) throws IOException {

        User user = Datasource.getInstance().searchUserByEmail(loginEmail.getText());

//        if (user != null && user.getPassword().equals(loginPassword.getText())) {
        if (true){ // login out of the way, for testing
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Regions.fxml"));
            Parent root = loader.load();

            RegionsController regionsController = loader.getController();
            regionsController.listRegions();

            Scene scene = new Scene(root);

            Stage loginStage = (Stage) btnLogin.getScene().getWindow();
            loginStage.setTitle("Home");
            loginStage.setScene(scene);
            loginStage.show();
        } else {
            loginInfo.setText("Incorrect Email or Password");
            loginInfo.setVisible(true);
        }


    }


}
