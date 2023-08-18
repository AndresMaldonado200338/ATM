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
    }

}
