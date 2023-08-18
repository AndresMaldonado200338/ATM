package presenter;

import java.util.ArrayList;
import java.util.List;

import model.*;
import view.*;

public class Presenter {

    private Functionalities functionalities;
    private AccountOperations accountOperations;
    private BDmanager bDmanager;
    private ViewManager viewManager;
    private List<Account> accounts;

    public Presenter() {
        this.functionalities = new Functionalities();
        this.viewManager = new ViewManager();
        this.bDmanager = new BDmanager();
        this.accounts = new ArrayList<>();
        this.accountOperations = new AccountOperations();
    }

    /**
     * Metodo para iniciar el programa
     * 
     * @throws NumberFormatException
     */
    public void init() throws NumberFormatException {
        int op = 0;
        do {
            try {
                op = viewManager.readGraphicShort(Constants.MENU);
                switch (op) {
                    case 1:
                        createAccount();
                        break;
                    case 2:
                        login();
                    case 3:
                        viewManager.showGraphicMessage("Finalizacion");
                        break;
                    default:
                        viewManager.showGraphicMessage("Opcion invalida");
                        break;
                }
            } catch (NumberFormatException e) {
                viewManager.showGraphicMessage("Error: " + e.getMessage());
            }
        } while (op != 3);
    }

    /**
     * Metodo para crear una cuenta
     */
    public void createAccount() {
        long numberAccount = viewManager.readGraphicLong(Constants.ACCOUNT_NUMBER);
        double balance = viewManager.readGraphicDouble(Constants.ACCOUNT_BALANCE);
        short password = viewManager.readGraphicShort(Constants.ACCOUNT_PASSWORD);
        accountOperations.createAccount(numberAccount, balance, password, this.accounts);
        for (Account account : accounts) {
            if (account.getNumberAccount() == numberAccount) {
                viewManager.showGraphicMessage("Numero de cuenta existente");
                init();
            } else {
                if (accountOperations.validateNumberAccount(numberAccount) == false) {
                    viewManager.showGraphicMessage("Numero de cuenta invalido");
                    init();
                } else if (accountOperations.validatePassword(password) == false) {
                    viewManager.showGraphicMessage("Contraseña invalida");
                    init();
                } else {
                    bDmanager.saveAccounts(accounts);
                    viewManager.showGraphicMessage("Cuenta creada con exito");
                    init();
                }
            }
        }
    }

    /**
     * Metodo para ingresdar a la cuenta
     */
    public void login() {
        long numberAccount = viewManager.readGraphicLong(Constants.ACCOUNT_NUMBER);
        short password = viewManager.readGraphicShort(Constants.ACCOUNT_PASSWORD);
        for (Account account : accounts) {
            if (account.getNumberAccount() == numberAccount && account.getPassword() == password) {
                viewManager.showGraphicMessage("Bienvenido");
                menu(numberAccount, password);
            } else {
                viewManager.showGraphicMessage("Numero de cuenta o contraseña invalida");
            }
        }
    }

    public void menu(long numberAccount, short password) {
        int op = 0;
        do {
            try {
                op = viewManager.readGraphicShort(Constants.MENU2);
                switch (op) {
                    case 1:
                        retreats(numberAccount, password);
                        break;
                    case 2:
                        consiganations(numberAccount, password);
                        break;
                    case 3:
                        viewManager.showGraphicMessage("Finalizacion");
                        break;
                    case 7:
                        viewManager.showGraphicMessage("Finalizacion");
                        break;
                    default:
                        viewManager.showGraphicMessage("Opcion invalida");
                        break;
                }
            } catch (NumberFormatException e) {
                viewManager.showGraphicMessage("Error: " + e.getMessage());
            }
        } while (op != 3);
    }

    /**
     * Metodo para retirar dinero
     * 
     * @param numberAccount
     * @param password
     */
    public void retreats(long numberAccount, short password) {
        double newBalance = viewManager.readGraphicDouble(Constants.RETREAT);
        if (functionalities.verify() == true) {
            List<Account> accounts = bDmanager.readAccounts();
            for (Account account : accounts) {
                if (account.getNumberAccount() == numberAccount && account.getPassword() == password) {
                    double finalBalance = account.getBalance() - newBalance;
                    bDmanager.editAccount(numberAccount, finalBalance);
                    viewManager.showGraphicMessage("Retiro Existoso");
                    viewManager.showGraphicMessage("Su nuevo saldo es: " + account.getBalance());
                }
            }
            System.out.println("XD");
        }
        menu(numberAccount, password);
    }

    /**
     * Metodo para consignar dinero
     * 
     * @param numberAccount
     * @param password
     */
    public void consiganations(long numberAccount, short password) {
        double newBalance = viewManager.readGraphicDouble(Constants.ACCOUNT_BALANCE);
        if (functionalities.verify() == true) {
            List<Account> accounts = bDmanager.readAccounts();
            for (Account account : accounts) {
                if (account.getNumberAccount() == numberAccount && account.getPassword() == password) {
                    double finalBalance = account.getBalance() + newBalance;
                    bDmanager.editAccount(numberAccount, finalBalance);
                    viewManager.showGraphicMessage("Su nuevo saldo es: " + account.getBalance());
                }
            }
        }
        menu(numberAccount, password);
    }

    public static void main(String[] args) {
        Presenter presenter = new Presenter();
        presenter.accounts.add(0, new Account(123456789012L, 100000, (short) 1234, 0));
        presenter.init();
    }
}
