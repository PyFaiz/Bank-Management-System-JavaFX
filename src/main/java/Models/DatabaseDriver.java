package Models;

import java.sql.*;
import java.time.LocalDate;

public class DatabaseDriver {
    private Connection conn;

    public DatabaseDriver(){
        try{
            this.conn = DriverManager.getConnection("jdbc:sqlite:faizbank.db");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public ResultSet getClientData(String pAddress,String password){
        Statement statement;
        ResultSet resultSet =null;
        try{
            statement=this.conn.createStatement();
            resultSet=statement.executeQuery("SELECT * FROM Clients WHERE PayeeAddress='"+pAddress+"' AND Password='"+password+"';");
        } catch (SQLException e){
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getAdminData(String username,String password){
        Statement statement;
        ResultSet resultSet = null;
        try{
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Admins WHERE Username='"+username+"' AND Password='"+password+"'");
        } catch (Exception e){
            e.printStackTrace();
        }
        return resultSet;
    }

    public void createClient(String fName, String lName, String pAddress, String password, LocalDate date){
        Statement statement;
        try{
            statement = conn.createStatement();
            statement.executeQuery("INSERT INTO Clients(FirstName,LastName,PayeeAddress,Password,Date) VALUES('" +fName+"','"+lName+"','"+pAddress+"','"+password+"','"+date.toString()+"');");
        } catch (SQLException s){
            s.printStackTrace();
        }
    }

    public void  createCheckingAccount(String owner,String number, double tlimit,double balance){
        Statement statement;
        try {
            statement = conn.createStatement();
            statement.executeQuery("INSERT INTO CheckingAccounts(Owner,AccountNumber,TransactionLimit,Balance)"+
                    "VALUES('"+owner+"','"+number+"','"+tlimit+"','"+balance+"');");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void  createSavingAccount(String owner,String number, double wlimit,double balance){
        Statement statement;
        try {
            statement = conn.createStatement();
            statement.executeQuery("INSERT INTO SavingAccounts(Owner,AccountNumber,WithdrawalLimit,Balance)"+
                    "VALUES('"+owner+"','"+number+"','"+wlimit+"','"+balance+"');");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ResultSet getAllClientData(){
        Statement statement;
        ResultSet resultSet= null;
        try{
            statement =conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Clients;");
        } catch (SQLException e){
            e.printStackTrace();
        }
        return  resultSet;
    }
    public int getLastClientsId(){
        Statement statement;
        ResultSet resultSet;
        int id = 0;

        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM sqlite_sequence WHERE name='Clients';");
            id = resultSet.getInt("seq");
        } catch (SQLException e){
            e.printStackTrace();
        }
        return id;
    }

    public ResultSet getCheckingAccountData(String pAddress){
        Statement statement;
        ResultSet resultSet = null;

        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM CheckingAccounts WHERE Owner='"+pAddress+"';");
        } catch (SQLException e){
            e.printStackTrace();
        }
        return resultSet;
    }
    public ResultSet getSavingAccountData(String pAddress){
        Statement statement;
        ResultSet resultSet = null;

        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM SavingsAccounts WHERE Owner='"+pAddress+"';");
        } catch (SQLException e){
            e.printStackTrace();
        }
        return resultSet;
    }


}
