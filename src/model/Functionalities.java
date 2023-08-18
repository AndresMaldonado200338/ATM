package model;

import java.util.List;

public class Functionalities {
    private BDmanager bDmanager;
    private int numberAccount;
    private short password;
    public Functionalities(int numberAccount, short password) {
        bDmanager = new BDmanager();
        this.numberAccount = numberAccount;
        this.password = password;
        verify();
    }

<<<<<<< HEAD
    private double calculateAdvance(double balance) {
        double auxAdvance = 0;
        if (balance != 0) {
            auxAdvance = balance * 0.5;
        }
        return auxAdvance;
    }

    public double calculateRefund(double advance) {
        double auxRefund;
        return auxRefund = advance * 0.08 * 1.5;
    }

    public void advance(double balance, double advance) {
        double maxAdvance = balance * 1.5;
        double auxAdvance = calculateAdvance(balance);
        if (balance > 0 && auxAdvance < balance && auxAdvance <= maxAdvance) {
            double aux = account.getBalance() + auxAdvance;
        } 
=======
    public boolean verify() {
        List<Account> accounts = bDmanager.readAccounts();
        for(Account account : accounts){
            if(account.getNumberAccount() == this.numberAccount && account.getPassword() == this.password){
                return true;
            }
        }
        return false;
    }
    public void Consultation() {
        if (verify() == true) {
            List<Account> accounts = bDmanager.readAccounts();
            for (Account account : accounts) {
                if (account.getNumberAccount() == this.numberAccount && account.getPassword() == this.password) {
                    System.out.println("Su saldo es: " + account.getBalance());
                }
            }

        }
>>>>>>> 72180db56c8d8b4b01970b5c73735a5ea233ad87
    }

}
