package Controller.Client;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AccountController implements Initializable {
    public Label checking_account_number;
    public Label trans_limit;
    public Label checking_date_created;
    public Label checking_acc_balance;
    public Label saving_account_number;
    public Label withdraw_limit;
    public Label saving_amount_date;
    public Label saving_bal;
    public TextField mv_funds_to_sv_acc;
    public Button btn_to_svn;
    public TextField mv_funds_to_chck_acc;
    public Button btn_to_chck;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
