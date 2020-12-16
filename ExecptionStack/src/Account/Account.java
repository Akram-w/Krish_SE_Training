package Account;

import java.io.FileNotFoundException;
import java.io.FileReader;

public interface Account {

    void deposit(String amount);
    FileReader getUserActivityFile() throws FileNotFoundException;
    int getAccountId();
    AccountTypes getAccountType();
    double getAmountInAccount();
    void deductAmount(double amount);
    String getName();
}
