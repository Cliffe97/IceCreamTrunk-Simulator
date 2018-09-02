public class Flavor{
  private String name;
  private int amount;
  public int soldAmount;
  //private int leftAmount;
  private Double cost;
  private Double wholeSaleCost;

  public Flavor(String name, int a, Double cost, Double wholeSaleCost){
    this.name = name;
    this.amount = a;
    this.soldAmount = 0;
    this.cost = cost;
    this.wholeSaleCost = wholeSaleCost;
  }

  public String getName(){
    return this.name;
  }

  public int getAmount(){
    return this.amount - this.soldAmount;
  }

  public Double getCost(){
    return this.cost;
  }
  public Double getWholeSaleCost(){
    return this.wholeSaleCost;
  }

}
