package Exceptions;

public class AccountTypeDoestMatch extends RuntimeException{

    public AccountTypeDoestMatch(String msg){
        super(msg);
    }
}
