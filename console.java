import java.util.*;


public class console{
  public static void main(String[]  args){
   System.out.println("Welcome to your new Ice Cream Trunk!");
   System.out.println("How much money would you like to give your truck to start?");
   Scanner scanner = new Scanner(System.in);
   int fund = scanner.nextInt();
   while(fund<100){
     System.out.println("The fund is not enough, please enter a new number.");
     fund = scanner.nextInt();
   }
   IceCreamTrunk ice1 = new IceCreamTrunk(fund);
   for(int i = 0; i < ice1.getNumber(); i++){
     System.out.println("Flavor added: " + ice1.getFlavor()[i].getName());
   }
   int cash = ice1.getCash() - 60;
   do{
     System.out.println();
     System.out.println("What would you like to do?");
     System.out.println("1: Add flavor");
     System.out.println("2: Add a new driver");
     System.out.println("3: Start a route");
     System.out.println("4: Check Cashbox");
     System.out.println("Enter any other number to quit");
     int command = scanner.nextInt();
     if(command == 1){
       System.out.println("What flavor will you add?");
       String n = scanner.next();
       System.out.println("How many scoops are there?");
       int a = scanner.nextInt();
       System.out.println("When you sell to a customer, how much is the cost per scoop?");
       Double c = scanner.nextDouble();
       System.out.println("How much is the cost per scoop that we pay (Wholesale)");
       Double w = scanner.nextDouble();
       Double purchaseCost = a * w;
       if(purchaseCost>cash){
         System.out.println("Purchase failed, balance too low.");
       }else{
         ice1.subtractCash(purchaseCost);
         ice1.addTotalCost(purchaseCost);
         ice1.addNewFlavor(n, a, c, w);
         System.out.println("Flavor added: " + n);
       }
     }else if(command == 2){
       System.out.println("what is the name of the employee?");
       String employeeName = scanner.next();
       System.out.println("Does this driver have permission to drive the truck? [y/n]");
       String drivePermission = scanner.next();
       System.out.println("Does this driver have permission to access the register? [y/n]");
       String registerPermission = scanner.next();
       ice1.addNewDriver(employeeName, drivePermission, registerPermission);
       System.out.println("employee added.");
     }else if(command == 3){
       System.out.println("Select the employee: ");
       for(int i = 0; i < ice1.getDriverNumber(); i++){
         System.out.println(i + ": " + ice1.getDriver()[i].getName());
       }
       int targetDriver = scanner.nextInt();
       do{
         System.out.println("Is there another customer avaliable?[y/n]");
         String command2 = scanner.next();
         if(command2.equals("y")){
           System.out.println("The truck is on route...");
           System.out.println("Customer found!");
           System.out.println("What flavor does the customer want?");
           System.out.printf("%15s%15s%20s\n", "Flavor", "Scoops left", "Cost per Scroop");
           for(int i = 0; i < ice1.getNumber(); i++){
             System.out.printf("%15s%15d%20.1f%6d\n", ice1.getFlavor()[i].getName(), ice1.getFlavor()[i].getAmount(),
                              ice1.getFlavor()[i].getCost(), i
                              );
           }
           int target = scanner.nextInt();
           System.out.println("How many scoops?");
           int scoops = scanner.nextInt();
           Double owedMoney = ice1.getFlavor()[target].getCost() * scoops;
           ice1.addCash(owedMoney);
           System.out.printf("%s%.2f\n", "Customer owes $", owedMoney);
           ice1.addSoldAmount(target, scoops);
           System.out.println(ice1.getFlavor()[target].soldAmount);
           System.out.println(ice1.getFlavor()[target].getAmount());
         }else{
           break;
         }
       }while(true);
     }else if(command == 4){
       System.out.println();
       System.out.printf("%s%d\n", "Starting cash: ", ice1.getCash());
       System.out.printf("%s%.1f\n", "Ice Cream Bought: ", ice1.getTotalCost());
       Double totalSold = ice1.getCashFlow() + ice1.getTotalCost() - ice1.getCash();
       System.out.printf("%s%.1f\n", "Ice Cream sold: ", totalSold);
       Double expectedSales = 0.00;
       for(int i = 0; i < ice1.getNumber(); i++){
         expectedSales += ice1.getFlavor()[i].soldAmount * ice1.getFlavor()[i].getCost();
       }
       System.out.printf("%s%.1f\n", "Expected Sales from missing inventory: ", expectedSales);
       System.out.printf("%s%.1f\n", "Cash in truck: ", ice1.getCashFlow());
       System.out.printf("%s%.1f\n", "Ice Cream sold: ", totalSold - ice1.getTotalCost());
     }

   }while(true);
  }
}
