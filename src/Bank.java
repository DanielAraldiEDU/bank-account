public class Bank {
  private CurrentAccount[] accounts;

  public Bank(CurrentAccount[] accounts) {
    this.accounts = accounts;
  }

  private CurrentAccount localizeAccount(int accountNumber) {
    for(int i = 0; i < this.accounts.length; i++) {
      if (this.accounts[i] != null && this.accounts[i].getNumber() == accountNumber) {
        return this.accounts[i];
      }
    }
    return null;
  }

  public int createAccount(boolean special, double limit, double balance) {
    int accountNumber = this.accounts.length;

    CurrentAccount account = new CurrentAccount(limit, accountNumber, balance);

    for (int i = 0; i < this.accounts.length; i++) {
      if (this.accounts[i] == null) {
        this.accounts[i] = account;
        return accountNumber;
      }
    }
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
      for (int i = 0; i < this.accounts.length; i++) {
        if (this.accounts[i] != null && this.accounts[i].getNumber() == account.getNumber()) {
          this.accounts[i] = null;
          return true;
        }
      }
      System.out.println("Account not found! This account ins't exist.");
      return false;
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
