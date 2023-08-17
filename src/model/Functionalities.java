package model;

import java.util.List;

public class Functionalities {

    private Account account;
    private BDmanager bDmanager;

    public Functionalities(int numberAccount, short password) {
        this.account = new Account();
        bDmanager = new BDmanager();
    }

    public boolean verify() {
        List<Account> accounts = bDmanager.readAccounts();
        for(Account account : accounts){
            if(account.getNumberAccount() == this.account.getNumberAccount() && account.getPassword() == this.account.getPassword()){
                return true;
            }
        }
        return false;
    }

    public void Consultation() {
        if (verify() == true) {
          
        }
    }

}
