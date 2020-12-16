package Account.saving;

import Account.Account;
import Account.AccountTypes;

import java.io.FileNotFoundException;
import Account.Withdrawable;
import Exceptions.AccountDoesntExists;
import Handlers.AccountExistsHandler;
import Handlers.AccountTypeHandler;
import Handlers.AmountHandler;

import java.io.FileReader;

public abstract class SavingAccounts implements Account,Withdrawable {
    int accountId;
    String name;
    double amount;

    public SavingAccounts(){}
    public SavingAccounts(int accountId){
        this.accountId=accountId;
    }

    public SavingAccounts(int accountId, String name, double amount) {
        this.accountId = accountId;
        this.name = name;
        this.amount = amount;
    }

    @Override
    public void deposit(String amount) throws NumberFormatException {
        int i = Integer.parseInt(amount);
        System.out.println("depositing RS:"+i);
    }
    @Override
    public FileReader getUserActivityFile() throws FileNotFoundException {
        return new FileReader("src/UserActivityFiles/"+this.accountId);
    }

    @Override
    public int getAccountId() {
        return accountId;
    }

    @Override
    public AccountTypes getAccountType() {
        return AccountTypes.SAVINGS;
    }

    @Override
    public double getAmountInAccount() {
        return this.amount;
    }

    @Override
    public void deductAmount(double amount) {
        this.amount-=amount;
    }

    @Override
    public String getName() {
        return name;
    }

    protected boolean validateWithdraw(Account account, double amount) throws AccountDoesntExists {
        AccountExistsHandler accExH=new AccountExistsHandler();
        AccountTypeHandler accountTypeHandler=new AccountTypeHandler();
        AmountHandler amountHandler=new AmountHandler();

        accExH.setNext(accountTypeHandler);
        accountTypeHandler.setNext(amountHandler);
        accExH.handle(account,amount);

        return true;
    }
}
