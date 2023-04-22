import java.util.ArrayList;

public class CurrentAccount {
  private boolean special;
  private double limit;
  private int number;
  private double balance;
  private ArrayList<Movement> movements;

  public CurrentAccount(boolean special, double limit, int number, double balance) {
    this.special = special;
    this.limit = limit;
    this.number = number;
    this.balance = balance;
    this.movements = new ArrayList<Movement>();
  }

  private void createMovement(String description, char type, double value) {
    Movement movement = new Movement(description, type, value);
    this.movements.add(movement);
  }

  public int getNumber() {
    return this.number;
  }

  public boolean deposit(double value) {
    if (value > 0) {
      this.balance += value;
      this.createMovement("Deposit some money.", 'C', value);
      return true;
    }
    System.out.println("Invalid value! Try again.");
    return false;
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
