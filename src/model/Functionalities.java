package model;

public class Functionalities {

    private Account account;
    private BDmanager bDmanager;

    public Functionalities(int numberAccount, short password) {
        this.account = new Account();
        bDmanager = new BDmanager();
    }

    public boolean verify() {
        return true;
    }

    public void Consultation() {
        if (verify() == true) {
            System.out.println("Su saldo es: " + account.getBalance());
        }
    }

}
