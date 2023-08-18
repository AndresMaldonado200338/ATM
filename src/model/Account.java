package model;

public class Account {
    private long numberAccount;
    private double balance;
    private short password;
    private double credit;
    private double refund;

    public Account(Long numberAccount, double balance, short password, double credit, double refund) {
        this.numberAccount = numberAccount;
        this.balance = balance;
        this.password = password;
        this.credit = credit;
        this.refund = refund;
    }

    public Account() {
    }

    public long getNumberAccount() {
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

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getCredit() {
        return credit;
    }

    public void setRefund(double refund) {
        this.refund = refund;
    }

    public double getRefund() {
        return refund;
    }
}
