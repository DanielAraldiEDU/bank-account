import java.util.ArrayList;

public class Bank {
  private ArrayList<CurrentAccount> accounts;

  public Bank(ArrayList<CurrentAccount> accounts) {
    this.accounts = accounts;
  }

  private CurrentAccount localizeAccount(int accountNumber) {
    for (CurrentAccount account : this.accounts) {
      if (account.getNumber() == accountNumber) {
        return account;
      }
    }
    return null;
  }

  public int createAccount(boolean special, double limit, double balance) {
    int accountNumber = this.accounts.size();

    CurrentAccount account = new CurrentAccount(special, limit, accountNumber, balance);

    this.accounts.add(account);
    return accountNumber;
  }

  public boolean deposit(int accountNumber, double value) {
    CurrentAccount account = this.localizeAccount(accountNumber);

    if (account == null) {
      System.out.println("Account not found! Try again.");
      return false;
    } else {
      return account.deposit(value);
    }
  }

  public boolean deleteAccount(int accountNumber) {
    CurrentAccount account = this.localizeAccount(accountNumber);

    if (account == null) {
      System.out.println("Account not found! This account ins't exist.");
      return false;
    } else {
      this.accounts.remove(account);
      return true;
    }
  }

  public boolean drawMoney(int accountNumber, double value) {
    CurrentAccount account = this.localizeAccount(accountNumber);

    if (account == null) {
      System.out.println("Account not found! Try again.");
      return false;
    } else {
      return account.drawMoney(value);
    }
  }

  public boolean transfer(int fromAccountNumber, int toAccountNumber, double value) {
    CurrentAccount fromAccount = this.localizeAccount(fromAccountNumber);
    CurrentAccount toAccount = this.localizeAccount(toAccountNumber);

    if (fromAccount == null || toAccount == null || value <= 0) {
      System.out.println(value <= 0 ? "Invalid value! Try again." : "Account not found! Try again.");
      return false;
    }

    if (fromAccount.drawMoney(value)) {
      toAccount.deposit(value);
      return true;
    }

    System.out.println("Transfer failed! Try again.");
    return false;
  }
}
