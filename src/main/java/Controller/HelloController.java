package Controller;


import Models.Model;
import Views.AccountType;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.PropertySheet;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    public ChoiceBox<AccountType> acc_selector;
    public Label account_id;
    public TextField account_id_input;
    public TextField pwd_input;
    public Button login_button;
    public Label login_error;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acc_selector.setItems(FXCollections.observableArrayList(AccountType.CLIENT,AccountType.ADMIN));
        acc_selector.setValue(Model.getInstance().getViewFactory().getLoginAccountType());
        acc_selector.valueProperty().addListener(observable -> setAcc_selector());
        login_button.setOnAction(actionEvent-> login());

        //login_button.setOnAction(actionEvent -> System.out.println("Damn"));
    }

    private void login()
    {
        Stage stage = (Stage) login_error.getScene().getWindow();

        if(Model.getInstance().getViewFactory().getLoginAccountType() == AccountType.CLIENT){
            Model.getInstance().evaluateClientCred(account_id_input.getText(),pwd_input.getText());
            if(Model.getInstance().getClientLoginSuccessFlag()){
                Model.getInstance().getViewFactory().showClientWindow();
                Model.getInstance().getViewFactory().closeStage(stage);
            }else {
                account_id_input.setText("");
                pwd_input.setText("");
                login_error.setText("No Such Login Credentials");
            }
        }
        else{
            Model.getInstance().evaluateAdminCred(account_id_input.getText(),pwd_input.getText());
            if(Model.getInstance().isAdminLoginSuccessFlag()){
                Model.getInstance().getViewFactory().showAdminWindow();
                Model.getInstance().getViewFactory().closeStage(stage);
            }
            else{
                account_id_input.setText("");
                pwd_input.setText("");
                login_error.setText("No Such Login Credentials");
            }

        }
    }

    private void setAcc_selector(){
        Model.getInstance().getViewFactory().setLoginAccountType(acc_selector.getValue());
        if(acc_selector.getValue()==AccountType.ADMIN){
            account_id.setText("Admin ID: ");
        }
        else{
            account_id.setText("Payee Address: ");
        }
    }
}