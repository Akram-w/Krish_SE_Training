package main;

import Account.fixedDeposit.RetiredFixedDeposit;
import Account.saving.SavingAccounts;
import Account.saving.TeenSavingAccount;
import Exceptions.AccountDoesntExists;

import java.io.FileNotFoundException;

public class Application {

    public static void main(String[] args) {
        //if id is not 1 then throws exception
        SavingAccounts savingAccounts=new TeenSavingAccount(1,"Waseem",25000);
        System.out.println("Amount before withdraw of "+savingAccounts.getAmountInAccount());
        try {
//            savingAccounts.withdraw(savingAccounts,4000);//execute normal
            savingAccounts.withdraw(savingAccounts,45000);//throws amount exceed error

            //if id is not 1 throws file not found error
            savingAccounts.getUserActivityFile();
            System.out.println("Amount after withdraw of "+savingAccounts.getAmountInAccount());

            //below code will throws exception Account type doesn't match
            RetiredFixedDeposit rfd=new RetiredFixedDeposit(1,"Akram",75000);
            savingAccounts.withdraw(rfd,4000);
        } catch (AccountDoesntExists  accoutDoesntExists) {
            System.out.println(accoutDoesntExists.getMessage());
        } catch (FileNotFoundException fileNotFoundException){
            System.out.println(fileNotFoundException.getMessage());
        }
    }
}
