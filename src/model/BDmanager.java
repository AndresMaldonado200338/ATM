package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class BDmanager {
    // nombre del archivo Txt
    private static final String FILENAME = "ATM_Project\\src\\resources\\Account.txt";

    // metodo para guardar cuentas
public void saveAccounts(List<Account> accounts) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
            for (Account account : accounts) {
                writer.println(account.getNumberAccount() + "," + account.getBalance() + "," + account.getPassword());
                for (String movement : account.getMovements()) {
                    writer.println("M," + account.getNumberAccount() + "," + movement);
                }
            }
            JOptionPane.showMessageDialog(null, "Cuentas guardadas exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // metodo para leer cuentas

    public  List<Account> readAccounts() {
        List<Account> accounts = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            Account currentAccount = null;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals("M")) {
                    currentAccount.getMovements().add(parts[2]);
                } else {
                    if (currentAccount != null) {
                        accounts.add(currentAccount);
                    }
                    currentAccount = new Account();
                    currentAccount.setNumberAccount(Integer.parseInt(parts[0]));
                    currentAccount.setBalance(Double.parseDouble(parts[1]));
                    currentAccount.setPassword(Short.parseShort(parts[2]));
                    currentAccount.setMovements(new ArrayList<>());
                }
            }
            if (currentAccount != null) {
                accounts.add(currentAccount);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accounts;
    }
    // metodo para editar cuenta
    public void editAccount(int accountNumber, double newBalance) {
        List<Account> accounts = readAccounts();
        for (Account account : accounts) {
            if (account.getNumberAccount() == accountNumber) {
                account.setBalance(newBalance);
                break;
            }
        }
        saveAccounts(accounts);
    }

    // metodo para eliminar cuenta
    public void deleteAccount(int accountNumber) {
        List<Account> accounts = readAccounts();
        accounts.removeIf(account -> account.getNumberAccount() == accountNumber);
        saveAccounts(accounts);
    }
  
      public static void main(String[] args) {
      BDmanager bDmanager = new BDmanager();
        // Create accounts
        Account account1 = new Account((long)1, 1000.0, (short) 1234, 0.0);
        Account account2 = new Account((long)2, 2000.0, (short) 5678, 0.0);

      // Save accounts
      List<Account> accounts = new ArrayList<>();
      accounts.add(account1);
      accounts.add(account2);
      bDmanager.saveAccounts(accounts);
      // Edit and delete accounts
      bDmanager.editAccount(1, 1500.0);
      bDmanager.deleteAccount(2);
      }
     

}
