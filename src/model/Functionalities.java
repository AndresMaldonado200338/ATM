package model;

public class Functionalities {

    private Account account;

    public Functionalities(Account account) {
        this.account = account;
    }

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
    }

}
