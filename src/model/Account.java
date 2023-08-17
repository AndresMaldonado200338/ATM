package model;

public class Account{
    private int numberAccount;
    private double balance;
    private short password;

    public Account(int numberAccount,double  balance,short password) {
        this.numberAccount = numberAccount;
        this.balance = balance;
        this.password = password;
    }

    public Account() {
    }

    public int getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(int numberAccount) {
        this.numberAccount = numberAccount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public short getPassword() {
        return password;
    }

    public void setPassword(short password) {
        this.password = password;
    }

}
