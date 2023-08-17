package model;

public class Functionalities {

    private Account account;

    public Functionalities(Account account) {
        this.account = account;
    }
    public void Consultation(){
        
        System.out.println("Your balance is: " + account.getBalance());
    }

    

    
}
