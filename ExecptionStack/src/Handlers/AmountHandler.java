package Handlers;

import Account.Account;
import Exceptions.AccountDoesntExists;
import Exceptions.AmountExceeded;

public class AmountHandler implements Handler{
    Handler handler;
    @Override
    public void setNext(Handler handler) {
        this.handler=handler;
    }

    @Override
    public void handle(Account account, double amount) throws AccountDoesntExists, AmountExceeded {
        System.out.println("checking withdrawal is more than account balance");
        if(amount<account.getAmountInAccount()){
            account.deductAmount(amount);
            System.out.println("Done Withdrawal");
        }else {
            throw new AmountExceeded("Requested amount more than account balance");
        }
    }
}
