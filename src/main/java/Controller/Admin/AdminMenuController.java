package Controller.Admin;

import Models.Model;
import Views.AdminMenuOptions;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.controlsfx.control.PropertySheet;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminMenuController implements Initializable {
    public Button create_client_btn;
    public Button clients_btn;
    public Button deposit_btn;
    public Button logout_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }

    private void addListeners(){
        create_client_btn.setOnAction(actionEvent -> onCreateClient());
        clients_btn.setOnAction(actionEvent -> onClient());
        deposit_btn.setOnAction(actionEvent -> onDeposit());
        logout_btn.setOnAction(actionEvent -> onLogout());
    }

    private void onCreateClient(){
        Model.getInstance().getViewFactory().getAdmin_selected_menu_item().set(AdminMenuOptions.CREATE_CLIENT);
    }

    private void onClient(){
        Model.getInstance().getViewFactory().getAdmin_selected_menu_item().set(AdminMenuOptions.CLIENTS);
    }

    private void onDeposit(){
        Model.getInstance().getViewFactory().getAdmin_selected_menu_item().set(AdminMenuOptions.DEPOSIT);
    }

    private void onLogout()
    {
        Stage stage = (Stage) logout_btn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindow();
        Model.getInstance().setAdminLoginSuccessFlag(false);
    }
}
