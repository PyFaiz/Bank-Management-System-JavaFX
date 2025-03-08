package Models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class SavingAccount extends Account{
    private final DoubleProperty withdrawllimit;

    public SavingAccount(String owner,String accountNumber,double balance,double withdrawlLimit){
        super(owner,accountNumber,balance);
        this.withdrawllimit = new SimpleDoubleProperty(this,"Withdrawl Limit",withdrawlLimit);

    }
    public DoubleProperty withdrawlLimirProperty(){
        return  withdrawllimit;
    }
}
