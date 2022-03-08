package uoft.csc207.thisisagame.userdata;

import android.content.Context;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AccountManager {
  private ArrayList<Account> accountList;
  private Context context;
  // a file contains "username, password" for one Account at each line
  private String filename;

  // set account manager
  public AccountManager(Context context) {
    this.context = context;
    this.filename = context.getFilesDir() + "Accounts.txt";
    accountList = new ArrayList<>();
    readFromFile();
  }

  // read from the account file and set up a list of Account objects
  private void readFromFile() {
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line = reader.readLine();
      while (line != null) {
        String[] accountInfo = line.split(", ");
        accountList.add(new Account(accountInfo[0], accountInfo[1]));
        line = reader.readLine();
      }
    } catch (IOException e) {
      // Error occurred opening raw file for reading.
      e.printStackTrace();
    }
  }

  // save player's latest information to the account file
  private void saveToAccountsFile() {
    // create a new file and add user info to it
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
      for (Account account : accountList) {
        writer.write(account.getName() + ", " + account.getPassword());
        writer.newLine();
      }
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // add a new player to the players file
  private void addNewPlayersFile(String username) {
    // create a new empty file "username.txt"
    try {
      BufferedWriter writer =
          new BufferedWriter(new FileWriter(context.getFilesDir() + username + ".txt"));
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // when add a new account then save this account's information to the files
  public void addAccount(String username, String password) {
    accountList.add(new Account(username, password));
    saveToAccountsFile();
    addNewPlayersFile(username);
  }

  // remove the account's information from the files
  public void removeAccount(String username, String password) {
    for (Account account : accountList) {
      if (account.checkCredentials(username, password)) {
        accountList.remove(account);
        accountList.add(new Account(username, password));
        saveToAccountsFile();
      }
    }
  }

  // find account by username and password
  public Account findAccount(String username, String password) {
    Account currentAccount = null;
    for (Account account : accountList) {
      if (account.checkCredentials(username, password)) {
        currentAccount = account;
      }
    }
    return currentAccount;
  }

  // find account by username, use this to check if the username is already registered
  public Account findAccount(String username) {
    Account currentAccount = null;
    for (Account account : accountList) {
      if (account.getName().equals(username)) {
        currentAccount = account;
      }
    }
    return currentAccount;
  }

  // return all the username from account list
  public ArrayList<String> getUsernameList() {
    // generates a list of username strings
    ArrayList<String> usernameList = new ArrayList<>();
    for (Account account : accountList) {
      usernameList.add(account.getName());
    }
    return usernameList;
  }
}
