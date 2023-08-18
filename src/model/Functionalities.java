package model;

import java.util.List;

public class Functionalities {
    private Account account;
    private BDmanager bDmanager;
    private long numberAccount;
    private short password;

    public Functionalities(long numberAccount, short password) {
        this.account = new Account();
        this.bDmanager = new BDmanager();
        this.numberAccount = numberAccount;
        this.password = password;
        verify();
    }

    /**
     * Metodo para retirar dinero
     * 
     * @param newBalance
     */
    public void retreats(double newBalance) {
        if (verify() == true) {
            List<Account> accounts = bDmanager.readAccounts();
            for (Account account : accounts) {
                if (account.getNumberAccount() == this.numberAccount && account.getPassword() == this.password) {
                    double finalBalance = account.getBalance() - newBalance;
                    bDmanager.editAccount(numberAccount, finalBalance);
                    System.out.println("Su nuevo saldo es: " + account.getBalance());
                }
            }
        }
    }

    /**
     * Metodo para consignar dinero
     * 
     * @param newBalance
     */
    public void consiganations(double newBalance) {
        if (verify() == true) {
            List<Account> accounts = bDmanager.readAccounts();
            for (Account account : accounts) {
                if (account.getNumberAccount() == this.numberAccount && account.getPassword() == this.password) {
                    double finalBalance = account.getBalance() + newBalance;
                    bDmanager.editAccount(numberAccount, finalBalance);
                    System.out.println("Su nuevo saldo es: " + account.getBalance());
                }
            }
        }
    }

    /**
     * Metodo para verificar la cuenta
     * 
     * @return true si la cuenta es valida o false si no lo es
     */
    public boolean verify() {
        List<Account> accounts = bDmanager.readAccounts();
        for (Account account : accounts) {
            if (account.getNumberAccount() == this.account.getNumberAccount()
                    && account.getPassword() == this.account.getPassword()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para calcular el avance
     * 
     * @param balance
     * @return
     */
    private double calculateAdvance(double balance) {
        double auxAdvance = 0;
        if (balance != 0) {
            auxAdvance = balance * 0.5;
        }
        return auxAdvance;
    }

    /**
     * Metodo para calcular el reembolso
     * 
     * @param advance
     * @return
     */
    public double calculateRefund(double advance) {
        double auxRefund;
        return auxRefund = advance * 0.08 * 1.5;
    }

    /**
     * Metodo para calcular el avance
     * 
     * @param balance
     */
    public void advance(double balance) {
        double maxAdvance = balance * 1.5;
        double auxAdvance = calculateAdvance(balance);
        if (verify() == true) {
            List<Account> accounts = bDmanager.readAccounts();
            for (Account account : accounts) {
                if (account.getNumberAccount() == this.numberAccount && account.getPassword() == this.password) {
                    if (balance > 0 && auxAdvance < balance && auxAdvance <= maxAdvance) {
                        double finalBalance = account.getBalance() + auxAdvance;
                        bDmanager.editAccount(numberAccount, finalBalance);
                        System.out.println("Su nuevo saldo es: " + account.getBalance());
                    }
                }
            }
        }
    }

    /**
     * Metodo para consultar el saldo
     */
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
