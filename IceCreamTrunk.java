public class IceCreamTrunk{
  private int cash;
  private int number;
  private int driverNumber;
  private Double cashFlow;
  private Double totalCost;
  public Double rawIncome;
  private Flavor[] flavor = new Flavor[100];
  private Driver[] employee = new Driver[100];
  private int[] soldAmount = new int[100];
  public IceCreamTrunk(int cash){
    this.cash = cash;
    this.number = 3;
    this.driverNumber = 0;
    this.rawIncome = 0.00;
    this.totalCost = 60.00;
    this.cashFlow = cash - 60.00;
    flavor[0] = new Flavor("Vanilla", 24, 1.00, 0.50);
    flavor[1] = new Flavor("Chocolate", 32, 1.50, 1.00);
    flavor[2] = new Flavor("Strawberry", 16, 1.50, 1.00);
  }

  public void addNewFlavor(String f, int a, double c, double w){
    this.number ++;
    flavor[this.number-1] = new Flavor(f, a, c, w);
  }

  public void addNewDriver(String n, String d, String r){
    this.driverNumber ++;
    employee[this.driverNumber-1]=new Driver(n, d, r);
  }
  // t is target flavor, s is the amount
  public void addSoldAmount(int t, int s){
    this.flavor[t].soldAmount += s;
  }

  public void addTotalCost(double c){
    this.totalCost += c;
  }
  public void addCash(double c){
    cashFlow += c;
  }

  public void subtractCash(double c){
    cashFlow -= c;
  }

  public String toString(){
    return ("Your IceCreamTrunk is started with fund " + this.cash + " dollars");
  }

  public int getNumber(){
    return this.number;
  }

  public int getDriverNumber(){
    return this.driverNumber;
  }

  public Flavor[] getFlavor(){
    return this.flavor;
  }

  public Driver[] getDriver(){
    return this.employee;
  }

  public int getCash(){
    return this.cash;
  }

  public Double getCashFlow(){
    return this.cashFlow;
  }

  public Double getTotalCost(){
    return this.totalCost;
  }
}
