package Account.fixedDeposit;

import Account.Account;
import Account.AccountTypes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;

public abstract class FixedAccount  implements Account {
    int accountId;
    String name;
    double amount;
    LocalDate withdrawableDate;

    public FixedAccount(){}
    public FixedAccount(int accountId){
        this.accountId=accountId;
    }

    public FixedAccount(int accountId, String name, double amount,LocalDate withdrawableDate) {
        this.accountId = accountId;
        this.name = name;
        this.amount = amount;
        this.withdrawableDate=withdrawableDate;
    }

    @Override
    public void deposit(String amount) throws NumberFormatException {
        int i = Integer.parseInt(amount);
        System.out.println("depositing RS:"+i);
    }

    @Override
    public FileReader getUserActivityFile() throws FileNotFoundException {
        return new FileReader(this.accountId+".txt");
    }

    @Override
    public AccountTypes getAccountType() {
        return AccountTypes.FIXED;
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

    @Override
    public int getAccountId() {
        return accountId;
    }
}
