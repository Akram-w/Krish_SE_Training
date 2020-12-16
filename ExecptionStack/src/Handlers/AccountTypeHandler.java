package Handlers;

import Account.Account;
import Exceptions.AccountDoesntExists;
import Account.AccountTypes;
import Exceptions.AccountTypeDoestMatch;

public class AccountTypeHandler implements Handler{
    Handler handler;
    @Override
    public void setNext(Handler handler) {
        this.handler=handler;
    }

    @Override
    public void handle(Account account, double amount) throws AccountDoesntExists {
        System.out.println("checking account type");
        if(account.getAccountType().equals(AccountTypes.FIXED)){
            throw new AccountTypeDoestMatch("Given Account Details belong to Fixed deposit Account Therefore no withdrawals");
        }else {
            handler.handle(account,amount);
        }
    }
}
