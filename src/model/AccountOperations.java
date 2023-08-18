package model;

import java.util.List;

public class AccountOperations {
    private Account account;

    /**
     * Metodo para crear una cuenta
     * @param numberAccount
     * @param balance
     * @param password
     * @param accounts
     */
    public void createAccount(int numberAccount, double balance, short password, List<Account> accounts) {
        if (validateNumberAccount(numberAccount, accounts) == true && validatePassword(password) == true) {
            account = new Account(numberAccount, balance, password);
        }
    }

    /**
     * Metodo para validar el numero de cuenta
     * @param numberAccount
     * @param accounts
     * @return ture si la cuenta es valida o false si no lo es
     */
    public boolean validateNumberAccount(int numberAccount, List<Account> accounts) {
        boolean isValid = false;
        String numberAccountString = Integer.toString(numberAccount);
        if (numberAccountString.length() == 12) {
            isValid = true;
            return isValid;
        }
        return isValid;
    }

    /**
     * Metodo para validar la contraseña
     * @param password
     * @return true si la contraseña es valida o false si no lo es
     */
    public boolean validatePassword(short password) {
        boolean isValid = false;
        String passwordString = Short.toString(password);
        if (passwordString.length() == 4) {
            isValid = true;
            return isValid;
        }
        return isValid;
    }
}
