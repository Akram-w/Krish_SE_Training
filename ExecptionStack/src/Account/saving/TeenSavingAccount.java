package Account.saving;
import  Account.Account;
import Exceptions.AccountDoesntExists;

public class TeenSavingAccount extends SavingAccounts{

    public TeenSavingAccount(){}
    public TeenSavingAccount(int accountId){
        super(accountId);
    }

    public TeenSavingAccount(int accountId, String name, double amount) {
        super(accountId,name,amount);
    }
    @Override
    public void withdraw(Account account, int amount) throws AccountDoesntExists {
        //withdraw code
        super.validateWithdraw(account,amount);
    }
}
