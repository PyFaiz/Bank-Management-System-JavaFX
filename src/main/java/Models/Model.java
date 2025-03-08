package Models;

import Views.AccountType;
import Views.ViewFactory;
import javafx.beans.value.ObservableListValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;
    private final DatabaseDriver databaseDriver;
    private AccountType loginAccountType = AccountType.CLIENT;

    private final Client client;
    private boolean clientLoginSuccessFlag;
    private final ObservableList<Client> clients;

    private boolean adminLoginSuccessFlag;

    private Model() {
        this.viewFactory = new ViewFactory();
        this.databaseDriver = new DatabaseDriver();
        this.clientLoginSuccessFlag = false;
        this.client = new Client("","","",null,null,null);
        this.adminLoginSuccessFlag = false;
        this.clients = FXCollections.observableArrayList();
    }

    public static synchronized Model getInstance() {
        if(model == null){
            model = new Model();
        }
        return model;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }

    public  DatabaseDriver getDatabaseDriver(){
        return databaseDriver;
    }
    public AccountType getLoginAccountType(){
        return loginAccountType;
    }
    public void setLoginAccountType(AccountType loginAccountType){
        this.loginAccountType = loginAccountType;
    }

    public boolean getClientLoginSuccessFlag()
    {
        return this.clientLoginSuccessFlag;
    }

    public void setClientLoginSuccessFlag(boolean flag){
        this.clientLoginSuccessFlag = flag;
    }

    public Client getClient(){
        return client;
    }

    public void evaluateClientCred(String pAddress,String password){
        CheckingAccount checkingAccount;
        SavingAccount savingAccount;
        ResultSet resultSet = databaseDriver.getClientData(pAddress,password);
        try{
            if(resultSet.isBeforeFirst()){
                this.client.firstNameProperty().set(resultSet.getString("FirstName"));
                this.client.lastNameProperty().set(resultSet.getString("LastName"));
                this.client.PayeeAddressProperty().set(resultSet.getString("PayeeAddress"));
                String[] dateParts = resultSet.getString("Date").split("-");
                LocalDate date = LocalDate.of(Integer.parseInt(dateParts[0]),Integer.parseInt(dateParts[1]),Integer.parseInt(dateParts[2]));
                this.client.DateProperty().set(date);
                checkingAccount = getCheckingAccount(pAddress);
                savingAccount = getSavingAccount(pAddress);
                client.checkingAccountProperty().set(checkingAccount);
                client.savingAccountProperty().set(savingAccount);
                this.clientLoginSuccessFlag = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean isAdminLoginSuccessFlag() {
        return adminLoginSuccessFlag;
    }

    public void setAdminLoginSuccessFlag(boolean adminLoginSuccessFlag) {
        this.adminLoginSuccessFlag = adminLoginSuccessFlag;
    }

    public void evaluateAdminCred(String username,String password){
        ResultSet resultSet = databaseDriver.getAdminData(username,password);
        try{
            if(resultSet.isBeforeFirst()){
                this.adminLoginSuccessFlag = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ObservableList<Client> getClients(){
        return clients;
    }
    public void setClients(){
        CheckingAccount checkingAccount;
        SavingAccount savingAccount;
        ResultSet resultSet =databaseDriver.getAllClientData();
        try {
            while (resultSet.next()){
                String fname = resultSet.getString("FirstName");
                String lname = resultSet.getString("LastName");
                String pAddress =  resultSet.getString("PayeeAddress");
                String[] dateParts = resultSet.getString("Date").split("-");
                LocalDate date = LocalDate.of(Integer.parseInt(dateParts[0]),Integer.parseInt(dateParts[1]),Integer.parseInt(dateParts[2]));
                checkingAccount = getCheckingAccount(pAddress);
                savingAccount = getSavingAccount(pAddress);
                clients.add(new Client(fname,lname,pAddress,checkingAccount,savingAccount,date));
            }
        }catch (SQLException s){
            s.printStackTrace();
        }
    }
    public  CheckingAccount getCheckingAccount(String pAddress){
        CheckingAccount account = null;
        ResultSet resultSet = databaseDriver.getCheckingAccountData(pAddress);
        try {
            String num = resultSet.getString("AccountNumber");
            int tLimit = (int) resultSet.getDouble("TransactionLimit");
            double balance = resultSet.getDouble("Balance");
            account = new CheckingAccount(pAddress,num,balance,tLimit);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return  account;
    }
    public  SavingAccount getSavingAccount(String pAddress){
        SavingAccount account = null;
        ResultSet resultSet = databaseDriver.getSavingAccountData(pAddress);
        try {
            String num = resultSet.getString("AccountNumber");
            int wLimit = (int) resultSet.getDouble("WithdrawalLimit");
            double balance = resultSet.getDouble("Balance");
            account = new SavingAccount(pAddress,num,balance,wLimit);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return  account;
    }

}
