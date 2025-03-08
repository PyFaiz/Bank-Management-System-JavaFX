package Controller.Admin;

import Models.Client;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientCellController implements Initializable {
    public Label fName_lbl;
    public Label lName_lbl;
    public Label payee_address_lbl;
    public Label ch_acc_lbl;
    public Label sav_acc_lbl;
    public Label date_lbl;
    public Button delete_btn;

    private final Client client;

    public ClientCellController(Client client){
        this.client = client;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fName_lbl.textProperty().bind(client.firstNameProperty());
        lName_lbl.textProperty().bind(client.lastNameProperty());
        payee_address_lbl.textProperty().bind(client.PayeeAddressProperty());
        ch_acc_lbl.textProperty().bind(client.checkingAccountProperty().asString());
        sav_acc_lbl.textProperty().bind(client.savingAccountProperty().asString());
        date_lbl.textProperty().bind(client.DateProperty().asString());
    }
}
