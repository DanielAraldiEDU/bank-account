public class Movement {
  private String description;
  private char type;
  private double value;

  public Movement(String description, char type, double value) {
    this.description = description;
    this.type = type;
    this.value = value;
  }

  public String getMovements() {
    if (type == 'C') {
      return "Movement type (C) Credit - " + description + " - Value: " + value;
    } else {
      return "Movement type (D) Debit - " + description + " - Value: " + value;
    }
  }
}
