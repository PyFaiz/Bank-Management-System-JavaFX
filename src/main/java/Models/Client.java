package Models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class Client {
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty payeeAddress;
    private final ObjectProperty<Account> checkingAccount;
    private final ObjectProperty<Account> savingAccount;
    private final ObjectProperty<LocalDate> dateCreated;

    public Client(String fName,String lName,String pAddress,Account cAccount,Account sAccount,LocalDate date){
        this.firstName = new SimpleStringProperty(this,"FirstName",fName);
        this.lastName = new SimpleStringProperty(this,"lastName",lName);
        this.payeeAddress = new SimpleStringProperty(this,"PayeeAddress",pAddress);
        this.checkingAccount = new SimpleObjectProperty<>(this,"CheckingAccount",cAccount);
        this.savingAccount = new SimpleObjectProperty<>(this,"SavingAccount",sAccount);
        this.dateCreated = new SimpleObjectProperty<>(this,"Date",date);
    }

    public  StringProperty firstNameProperty(){
        return firstName;
    }
    public  StringProperty lastNameProperty(){
        return lastName;
    }
    public  StringProperty PayeeAddressProperty(){
        return payeeAddress;
    }
    public  ObjectProperty<Account> checkingAccountProperty(){
        return checkingAccount;
    }
    public  ObjectProperty<Account> savingAccountProperty(){
        return savingAccount;
    }
    public  ObjectProperty<LocalDate> DateProperty(){
        return dateCreated;
    }








}
