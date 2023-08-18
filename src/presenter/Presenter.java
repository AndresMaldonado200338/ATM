package presenter;

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
        this.viewManager = new ViewManager();
        this.bDmanager = new BDmanager();
        this.accounts = bDmanager.readAccounts();
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
        accountOperations.createAccount(numberAccount, balance, password, accounts);
        bDmanager.saveAccounts(accounts);
        viewManager.showGraphicMessage("Cuenta creada con exito");
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

    }

    public static void main(String[] args) {
        Presenter presenter = new Presenter();
        presenter.init();
    }
}
