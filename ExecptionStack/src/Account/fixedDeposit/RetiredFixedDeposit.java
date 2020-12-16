package Account.fixedDeposit;

import java.time.LocalDate;

public class RetiredFixedDeposit extends FixedAccount{
    int accountId;
    String name;
    double amount;
    LocalDate withdrawableDate;

    public RetiredFixedDeposit(){}
    public RetiredFixedDeposit(int accountId){
        super(accountId);
    }

    public RetiredFixedDeposit(int accountId, String name, double amount) {
        super(accountId,name,amount,LocalDate.now().plusYears(1));
    }
    public boolean isWithdrawable(){
        return LocalDate.now().isAfter(withdrawableDate);
    }

}
