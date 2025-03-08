package Controller.Client;

import Models.Model;
import Views.ClientMenuOptions;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.controlsfx.control.PropertySheet;

import java.net.URL;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ClientMenuController implements Initializable {
    public Button dashboard_btn;
    public Button transaction_btn;
    public Button account_btn;
    public Button profile_btn;
    public Button logout_btn;
    public Button report_btn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        addListeners();
    }

    private void addListeners() {

        dashboard_btn.setOnAction(actionEvent -> onDashboard());
        transaction_btn.setOnAction(actionEvent -> onTransactions());
        account_btn.setOnAction(actionEvent -> onAccounts());
        logout_btn.setOnAction(actionEvent -> onLogout());
    }


    private void onDashboard()
    {
        Model.getInstance().getViewFactory().getClient_selected_menu_item().set(ClientMenuOptions.DASHBOARD);
    }
    private void onTransactions()
    {
        Model.getInstance().getViewFactory().getClient_selected_menu_item().set(ClientMenuOptions.TRANSACTIONS);
    }

    private void onAccounts()
    {
        Model.getInstance().getViewFactory().getClient_selected_menu_item().set(ClientMenuOptions.ACCOUNTS);
    }

    private void onLogout()
    {
        Stage stage = (Stage) logout_btn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindow();
        Model.getInstance().setClientLoginSuccessFlag(false);
    }



}
