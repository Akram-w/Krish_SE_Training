package Exceptions;

import java.sql.SQLException;

public class AccountDoesntExists extends SQLException {

    public AccountDoesntExists(String msg){
        super(msg);
    }
}
