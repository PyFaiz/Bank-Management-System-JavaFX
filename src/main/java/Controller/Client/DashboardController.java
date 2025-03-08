package Controller.Client;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    public Text username;
    public Label login_date;
    public Label checking_bal;
    public Label checking_number;
    public Label saving_bal;
    public Label saving_num;
    public Label income_amt;
    public Label expenses;
    public ListView transaction_list;
    public TextField payee_field;
    public TextField amount_field;
    public TextArea message_field;
    public Button send_money_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
