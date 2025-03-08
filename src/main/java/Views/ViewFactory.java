package Views;

import Controller.Admin.AdminController;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import Controller.Client.ClientController;

public class ViewFactory {
    private AccountType loginAccountType;
    private final ObjectProperty<ClientMenuOptions> client_selected_menu_item;
    private AnchorPane dashboardView;
    private AnchorPane transactionsView;
    private AnchorPane accountsView;

    private AnchorPane createClientView;
    private AnchorPane ClientView;
    private AnchorPane depositView;

    private final  ObjectProperty<AdminMenuOptions> admin_selected_menu_item;
    public ViewFactory(){
        this.loginAccountType = AccountType.CLIENT;
        this.client_selected_menu_item = new SimpleObjectProperty<>();
        this.admin_selected_menu_item =  new SimpleObjectProperty<>();
    };

    public AccountType getLoginAccountType() {
        return loginAccountType;
    }

    public void setLoginAccountType(AccountType loginAccountType) {
        this.loginAccountType = loginAccountType;
    }

    public ObjectProperty<ClientMenuOptions> getClient_selected_menu_item() {
        return client_selected_menu_item;
    }

    public AnchorPane getAccountsView() {
        if(accountsView==null){
            try{
                accountsView = new FXMLLoader(getClass().getResource("/Client/Accounts.fxml")).load();
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        return accountsView;
    }

    public AnchorPane getDashboardView() {

        if(dashboardView== null){
            try{
                dashboardView = new FXMLLoader(getClass().getResource("/Client/Dashboard.fxml")).load();
            } catch (Exception e){
                //noinspection CallToPrintStackTrace
                e.printStackTrace();
            }
        }
        return dashboardView;
    }

    public AnchorPane getTransactionsView() {
        if(transactionsView == null){
            try{
                transactionsView = new FXMLLoader(getClass().getResource("/Client/Transactions.fxml")).load();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return transactionsView;
    }

    public void showLoginWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/App/Login.fxml"));
        createStage(loader);
    }


    public void showClientWindow()
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Client/Client.fxml"));
        ClientController clientController = new ClientController();
        loader.setController(clientController);
        createStage(loader);
    }

    public void showAdminWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Admin/Admin.fxml"));
        AdminController  controller = new AdminController();
        loader.setController(controller);
        createStage(loader);
    }
    public  ObjectProperty<AdminMenuOptions> getAdmin_selected_menu_item(){
        return admin_selected_menu_item;
    }
    public AnchorPane getCreateClientView() {
        if(createClientView==null){
            try{
                createClientView = new FXMLLoader(getClass().getResource("/Admin/CreateClient.fxml")).load();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return createClientView;
    }

    public AnchorPane getClientView()
    {
        if(ClientView == null){
            try{
                ClientView = new FXMLLoader(getClass().getResource("/Admin/Clients.fxml")).load();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        return ClientView;
    }

    public AnchorPane getDepositView(){
        if(depositView==null) {
            try {
                depositView = new FXMLLoader(getClass().getResource("/Admin/Deposit.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
            return depositView;
    }

    public void closeStage(Stage stage)
    {
        stage.close();
    }

    private void createStage(FXMLLoader loader){
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception e){
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/Images/logo.png"))));
        stage.setResizable(false);
        stage.setTitle("Faiz Bank");
        stage.show();
    }
}
