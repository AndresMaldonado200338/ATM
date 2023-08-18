package model;

import java.util.ArrayList;

public class Account {
    private long numberAccount;
    private double balance;
    private short password;
    private double credit;
    private double refund;
    private ArrayList<String> movements ;
    public Account(Long numberAccount, double balance, short password, double refund) {
        this.numberAccount = numberAccount;
        this.balance = balance;
        this.password = password;
        this.refund = refund;
        this.movements = new ArrayList<String>();
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

    public void setNumberAccount(long numberAccount) {
        this.numberAccount = numberAccount;
    }

    public ArrayList<String> getMovements() {
        return movements;
    }

    public void setMovements(ArrayList<String> movements) {
        this.movements = movements;
    }
    
}
