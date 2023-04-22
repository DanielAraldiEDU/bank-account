import java.util.ArrayList;

public class CurrentAccount {
  private Boolean special;
  private double limit;
  private int number;
  private double balance;
  private ArrayList<Movement> movements;

  public CurrentAccount(Boolean special, double limit, int number, double balance) {
    this.special = special;
    this.limit = limit;
    this.number = number;
    this.balance = balance;
    this.movements = new ArrayList<Movement>();
  }

  private void createMovement(String description, double value) {
    Movement movement = new Movement(description, 'D', value);
    this.movements.add(movement);
  }

  public int getNumber() {
    return this.number;
  }

  public Boolean deposit(double value) {
    if (value > 0) {
      this.balance += value;
      this.createMovement("Deposit some money", value);
      return true;
    }
    System.out.println("Invalid value. Try again.");
    return false;
  }

  public Boolean drawMoney(double value) {
    double currentBalance = this.balance -= value;

    Boolean isValidValue = value > 0 && value <= this.balance && value <= this.limit && currentBalance >= 0;
    if (isValidValue) {
      this.createMovement("Draw some money", currentBalance);
      return true;
    }
    System.out.println("Invalid value. Try again.");
    return false;
  }
}
