package Account;

import Exceptions.AccountDoesntExists;

public interface Withdrawable {

    void withdraw(Account account,int amount) throws AccountDoesntExists;
}
