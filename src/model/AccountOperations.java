package model;

import java.util.List;

public class AccountOperations {
    private Account account;
    private BDmanager bDmanager;

    /**
     * Metodo para crear una cuenta
     * 
     * @param numberAccount
     * @param balance
     * @param password
     * @param accounts
     */
    public void createAccount(long numberAccount, double balance, short password) {
        if (validateNumberAccount(numberAccount) == true && validatePassword(password) == true) {
            account = new Account(numberAccount, balance, password);
            bDmanager = new BDmanager();
            List<Account> accounts = bDmanager.readAccounts();
            accounts.add(account);
            bDmanager.saveAccounts(accounts);
        }
    }

    /**
     * Metodo para validar el numero de cuenta
     * 
     * @param numberAccount
     * @param accounts
     * @return ture si la cuenta es valida o false si no lo es
     */
    public boolean validateNumberAccount(long numberAccount) {
        boolean isValid = false;
        String numberAccountString = Long.toString(numberAccount);
        if (numberAccountString.length() == 12) {
            isValid = true;
            return isValid;
        }
        return isValid;
    }

    /**
     * Metodo para validar la contraseña
     * 
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

    /**
     * Metodo para cambiar la contraseña
     * @param numberAccount
     * @param newPassword
     */
    public void changePassword(long numberAccount, short newPassword) {
        if (validateNumberAccount(numberAccount) == true && validatePassword(newPassword) == true) {
            bDmanager = new BDmanager();
            List<Account> accounts = bDmanager.readAccounts();
            for (Account account : accounts) {
                if (account.getNumberAccount() == numberAccount) {
                    account.setPassword(newPassword);
                    break;
                }
            }
            bDmanager.saveAccounts(accounts);
        }
    }
}
