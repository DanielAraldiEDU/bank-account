public class CurrentAccount {
  private boolean special;
  private double limit;
  private int number;
  private double balance;
  private Movement[] movements;

  public CurrentAccount(int number, double balance) {
    this.special = false;
    this.limit = 1000;
    this.number = number;
    this.balance = balance;
    this.movements = new Movement[9999];
  }

  public CurrentAccount(double limit, int number, double balance) {
    this.special = true;
    this.limit = limit;
    this.number = number;
    this.balance = balance;
    this.movements = new Movement[9999];
  }

  private void createMovement(String description, char type, double value) {
    Movement movement = new Movement(description, type, value);

    for (int i = 0; i < this.movements.length; i++) {
      if (this.movements[i] == null) {
        this.movements[i] = movement;
        return;
      }
    }
  }

  public int getNumber() {
    return this.number;
  }

  public double getMoney() {
    return this.balance;
  }

  protected boolean deposit(double value) {
    if (value > 0) {
      this.balance += value;
      this.createMovement("Deposit some money.", 'C', value);
      return true;
    }

    System.out.println("Invalid value! Try again.");
    return false;
  }

  protected String getExtract() {
    for (int i = 0; i < this.movements.length; i++) {
      if (this.movements[i] != null) {
        this.movements[i].getMovements();
      }
    }

    return null;
  }

  public boolean drawMoney(double value) {
    boolean isValidValue = value > 0 && value <= this.balance && value <= this.limit;

    if (isValidValue) {
      double currentBalance = this.balance -= value;
      this.createMovement("Draw some money.", 'D', currentBalance);
      return true;
    }

    System.out.println("Invalid value! Try again.");
    return false;
  }
}
