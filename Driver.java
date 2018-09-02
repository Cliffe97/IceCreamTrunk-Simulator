public class Driver{
  private String name;
  private String drivePermission;
  private String registerPermission;

  public Driver(String name, String d, String r){
    this.name = name;
    this.drivePermission = d;
    this.registerPermission = r;
  }

  public String getName(){
    return this.name;
  }

  public String getDriverPermission(){
    return this.drivePermission;
  }

  public String getRegisterPermission(){
    return this.registerPermission;
  }

}
