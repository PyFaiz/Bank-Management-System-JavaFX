package Models;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Transaction {
    private final StringProperty sender;
    private final StringProperty receiver;
    private final DoubleProperty amount;
    private final ObjectProperty<LocalDate> date;
    private final StringProperty message;

    public Transaction(String sender,String reciever,double amount,LocalDate date,String message){
        this.sender = new SimpleStringProperty(this,"sender",sender);
        this.receiver = new SimpleStringProperty(this,"reciever",reciever);
        this.amount = new SimpleDoubleProperty(this,"amount",amount);
        this.date = new SimpleObjectProperty<>(this,"Date",date);
        this.message = new SimpleStringProperty(this,"Message",message);

    }

    public StringProperty senderproperty(){
        return  this.sender;
    }
    public StringProperty receiverproperty(){
        return  this.receiver;
    }
    public DoubleProperty amountproperty(){
        return  this.amount;
    }
    public ObjectProperty<LocalDate> dateproperty(){
        return  this.date;
    }
    public StringProperty messageproperty(){
        return  this.message;
    }

}
