package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class BDmanager {
    //nombre del archivo Txt
    private static final String FILENAME = "src\\resources\\Account.txt";

//metodo para guardar cuentas
    public static void saveAccounts(List<Account> accounts) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
            for (Account account : accounts) {
                writer.println(account.getNumberAccount() + "," + account.getBalance() + "," + account.getPassword());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//metodo para leer cuentas
    public static List<Account> readAccounts() {
        List<Account> accounts = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int numberAccount = Integer.parseInt(parts[0]);
                double balance = Double.parseDouble(parts[1]);
                short password = Short.parseShort(parts[2]);
                Account account = new Account(numberAccount, balance, password);
                accounts.add(account);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accounts;
    }
//metodo para editar cuenta
    public static void editAccount(int accountNumber, double newBalance) {
        List<Account> accounts = readAccounts();
        for (Account account : accounts) {
            if (account.getNumberAccount() == accountNumber) {
                account.setBalance(newBalance);
                break;
            }
        }
        saveAccounts(accounts);
    }
//metodo para eliminar cuenta
    public static void deleteAccount(int accountNumber) {
        List<Account> accounts = readAccounts();
        accounts.removeIf(account -> account.getNumberAccount() == accountNumber);
        saveAccounts(accounts);
    }
    /* 
 public static void main(String[] args) {
        Account account1 = new Account(1, 1000.0, (short) 1234);
        Account account2 = new Account(2, 2000.0, (short) 5678);
        // Save accounts
        List<Account> accounts = new ArrayList<>();
        accounts.add(account1);
        accounts.add(account2);
        saveAccounts(accounts);
        // Edit and delete accounts
        editAccount(1, 1500.0);
        deleteAccount(2);
    }
*/
    
}
