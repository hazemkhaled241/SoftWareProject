import java.util.ArrayList;

public class DataBaseSystem {
    ArrayList<Ride>rideRequests=new ArrayList<>();
    ArrayList<Client>clients=new ArrayList<>();
    ArrayList<Driver>activeDrivers=new ArrayList<>();
    ArrayList<Driver>pendingDrivers=new ArrayList<>();
    ArrayList<Admin>currAdmins=new ArrayList<>();
    private static DataBaseSystem dataBaseSystem=null;
    private  DataBaseSystem(){}
   public static DataBaseSystem getInstance(){
        if(dataBaseSystem==null)
            dataBaseSystem=new DataBaseSystem();


        return dataBaseSystem;
   }
    public void addClient(Client client){
        dataBaseSystem.clients.add(client);

    }
    public void addDriver(Driver driver){
        dataBaseSystem.pendingDrivers.add(driver);

    }
    public void acceptDriver(Driver driver){
        driver.setDriverStatus(true);
        dataBaseSystem.activeDrivers.add(driver);
    }
    public void addAdmin(){
        dataBaseSystem.currAdmins.add(new Admin("hazem","hazemk778@gmail.com","123456"));
        dataBaseSystem.currAdmins.add(new Admin("mohamed nasr","mohamed@gmail.com","123456"));
        dataBaseSystem.currAdmins.add(new Admin("seif mohamed","seifmohamed@gmail.com","123456"));
        dataBaseSystem.currAdmins.add(new Admin("moataz","moataz@gmail.com","123456"));

    }

}
