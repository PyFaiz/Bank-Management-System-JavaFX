package Controller.Admin;

import Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class CreateClientController implements Initializable {
    public TextField fName_fld;
    public TextField lName_fld;
    public TextField pwd_fld;
    public CheckBox pAddr_box;
    public Label pAddress_box;
    public CheckBox ch_acc_box;
    public TextField ch_acc_field;
    public CheckBox sav_acc_box;
    public TextField sav_acc_fld;
    public Button create_client_btn;
    public Label error_lbl;

    private String payeeAddress;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private void createCheckingAccount(){
        double balance = Double.parseDouble(ch_acc_field.getText());

        String first = "1234";
        String last = Integer.toString(new Random().nextInt(9999)+1000);
        String accountNumber = first+ " "+last;

        Model.getInstance().getDatabaseDriver().createCheckingAccount(payeeAddress,accountNumber,10,balance);
    }
}
