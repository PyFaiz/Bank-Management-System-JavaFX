package Views;

import Controller.Admin.ClientCellController;
import Controller.Client.ClientController;
import Models.Client;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

public class ClientCellFactory extends ListCell<Client> {
    @Override
    protected void updateItem(Client client,boolean empty){
        super.updateItem(client,empty);
        if(empty){
            setText(null);
            setGraphic(null);
        }
        else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Admin/ClientCell.fxml"));
            ClientCellController controller = new ClientCellController(client);
            loader.setController(controller);
            setText(null);
            try{
                setGraphic(loader.load());
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }

}
