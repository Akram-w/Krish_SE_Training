package Handlers;
import Account.Account;
import Exceptions.AccountDoesntExists;
import Exceptions.AmountExceeded;

public interface Handler {
    void setNext(Handler handler);
    void handle(Account account,double amount) throws AccountDoesntExists, AmountExceeded;
}
