package Handlers;

import Account.Account;
import Exceptions.AccountDoesntExists;
import Services.AccountService;

public class AccountExistsHandler implements Handler{
    AccountService service;
    Handler handler;
    @Override
    public void setNext(Handler handler) {
        this.handler=handler;
    }

    @Override
    public void handle(Account account, double amount) throws AccountDoesntExists {
        service=new AccountService();
        service.isAccountAvailable(account.getAccountId());
        handler.handle(account,amount);
    }
}
