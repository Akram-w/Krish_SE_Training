package Services;

import Account.Account;
import Account.saving.SavingAccounts;
import Exceptions.AccountDoesntExists;

public class AccountService {

    public boolean isAccountAvailable(int id) throws AccountDoesntExists {
        //checking in db
        System.out.println("checking account in db");
        boolean flag;
        if(id==1){
            flag=true;
        }else {
            throw new AccountDoesntExists("Account doesn't exists under Account id : " + id);
        }
        return flag;
    }
    public boolean addSavingAccount(Account account){
        boolean flag;
            if(account.getName()==null || account.getName().trim()==""){
                throw  new NullPointerException("Account Name should have value");
            }else {
                System.out.println("Saving Account");
                flag=true;
            }
        return flag;
    }
}
