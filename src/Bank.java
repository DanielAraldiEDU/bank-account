public class Bank {
  public CurrentAccount[] accounts;

  private String name;
  private int number;

  public Bank() {
    this.name = "Banco do Brasil";
    this.number = 001;
    this.accounts = new CurrentAccount[9999];
  }

  private CurrentAccount localizeAccount(int accountNumber) {
    for(int i = 0; i < this.accounts.length; i++) {
      if (this.accounts[i] != null && this.accounts[i].getNumber() == accountNumber) {
        return this.accounts[i];
      }
    }

    return null;
  }

  private int getNumberAccount(CurrentAccount account) {
    for (int i = 0; i < this.accounts.length; i++) {
      if (this.accounts[i] == null) {
        this.accounts[i] = account;
        return account.getNumber();
      }
    }

    return -1;
  }

  public int createAccount(double balance) {
    int accountNumber = this.accounts.length;

    CurrentAccount account = new CurrentAccount(accountNumber, balance);

    return this.getNumberAccount(account);
  }

  public int createAccount(double balance, double limit) {
    int accountNumber = this.accounts.length;

    CurrentAccount account = new CurrentAccount(accountNumber, balance, limit);

    return this.getNumberAccount(account);
  }

  public boolean deposit(int accountNumber, double value) {
    CurrentAccount account = this.localizeAccount(accountNumber);

    if (account == null) {
      System.out.println("Account not found! Try again.");
      return false;
    }

    return account.deposit(value);
  }

  public String getExtract(int accountNumber) {
    CurrentAccount account = this.localizeAccount(accountNumber);

    if (account == null) {
      System.out.println("Account not found! This account ins't exist.");
      return null;
    }

    return account.getExtract();
  }

  public boolean drawMoney(int accountNumber, double value) {
    CurrentAccount account = this.localizeAccount(accountNumber);

    if (account == null) {
      System.out.println("Account not found! Try again.");
      return false;
    }

    return account.drawMoney(value);
  }

  public void transfer(int fromAccountNumber, int toAccountNumber, double value) {
    CurrentAccount fromAccount = this.localizeAccount(fromAccountNumber);
    CurrentAccount toAccount = this.localizeAccount(toAccountNumber);

    if (fromAccount == null || toAccount == null || value <= 0) {
      System.out.println(value <= 0 ? "Invalid value! Try again." : "Account not found! Try again.");
      return;
    }

    if (fromAccount.drawMoney(value)) {
      toAccount.deposit(value);
      return;
    }

    System.out.println("Transfer failed! Try again.");
  }
}
