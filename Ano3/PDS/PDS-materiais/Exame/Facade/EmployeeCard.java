public class EmployeeCard {
  private static int nextCardNum = 1;

  private int cardNum;
  private Employee e;

  public EmployeeCard(Employee e) {
    cardNum = nextCardNum;
    nextCardNum++;

    this.e = e;
  }

}
