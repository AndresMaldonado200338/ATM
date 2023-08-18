package model;

public class Account {
    private int numberAccount;
    private double balance;
    private short password;
    private double credit;
    private double refund;

    public Account(int numberAccount, short password) {
        this.numberAccount = numberAccount;
        this.balance = 0.0;
        this.password = password;
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

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getRefund() {
        return refund;
    }

    public void setRefund(double refund) {
        refund = refund;
    }

    

}
