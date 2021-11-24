import java.util.ArrayList;

public class DataBaseSystem {
    ArrayList<Ride> rideRequests = new ArrayList<>();
    ArrayList<Client> clients = new ArrayList<>();
    ArrayList<Driver> activeDrivers = new ArrayList<>();
    ArrayList<Driver> pendingDrivers = new ArrayList<>();
    ArrayList<Admin> currAdmins = new ArrayList<>();
    public static int counter =0;
    private static DataBaseSystem dataBaseSystem = null;

    private DataBaseSystem() {
    }

    public static DataBaseSystem getInstance() {
        if (dataBaseSystem == null)
            dataBaseSystem = new DataBaseSystem();


        return dataBaseSystem;
    }

    public void addClient(Client client) {
        dataBaseSystem.clients.add(client);

    }

    public void addDriver(Driver driver) {
        dataBaseSystem.pendingDrivers.add(driver);

    }

    public void acceptDriver(Driver driver) {
        driver.setDriverStatus(true);
        dataBaseSystem.activeDrivers.add(driver);
    }

    public Boolean searchForUser(User user) {
        if (user.getClass().equals(Client.class)) {
            for (int i = 0; i < clients.size(); i++) {
                if (clients.get(i).getUserName().equals(user.getUserName())
                        && clients.get(i).getPassword().equals(user.getPassword())
                ) {
                    return true;
                }
            }
        } else if (user.getClass().equals(Driver.class)) {
            for (int i = 0; i < activeDrivers.size(); i++) {
                if (activeDrivers.get(i).getUserName().equals(user.getUserName())
                        && activeDrivers.get(i).getPassword().equals(user.getPassword())
                ) {
                    return true;
                }
            }
        } else if (user.getClass().equals(Admin.class)) { //admin
            for (int i = 0; i < currAdmins.size(); i++) {
                if (currAdmins.get(i).getUserName().equals(user.getUserName())
                        && currAdmins.get(i).getPassword().equals(user.getPassword())
                ) {
                    return true;
                }
            }
        }
        return false;
    }

    public void addAdmin() {
        dataBaseSystem.currAdmins.add(new Admin("hazem", "123456"));
        dataBaseSystem.currAdmins.add(new Admin("mohamed nasr", "123456"));
        dataBaseSystem.currAdmins.add(new Admin("seif mohamed", "123456"));
        dataBaseSystem.currAdmins.add(new Admin("moataz", "123456"));

    }


    public boolean showPendingRequests(){
        if (pendingDrivers.isEmpty())
        {
            System.out.println(" There are no pending requests ");
            return false;
        }
        else {
            for (int i = 0; i < pendingDrivers.size(); i++) {
                System.out.print(i+1+ "-" +pendingDrivers.get(i).getUserName() + " ");
                System.out.print(pendingDrivers.get(i).getPassword() + " ");
                System.out.print(pendingDrivers.get(i).getEmail() + " ");
                System.out.print(pendingDrivers.get(i).nationalId + " ");
                System.out.println(pendingDrivers.get(i).license + " ");
                System.out.println("\n");
            }
            return true ;
        }
    }

    public boolean showClientsList()
    {
        if (clients.isEmpty())
        {
            System.out.println(" There are no clients yet ");
            return false;
        }
        else {
            for (int i = 0; i < clients.size(); i++) {
                System.out.print(i+1 + "-" +clients.get(i).getUserName() + " ");
                System.out.print(clients.get(i).getEmail() + " ");
                System.out.println(clients.get(i).getStatus() + "\n");
            }
            return true;
        }
    }

    public boolean showActiveDrivers(){
        if (activeDrivers.isEmpty())
        {
            System.out.println(" There are no drivers yet ");
            return false;
        }
        else {
            for (int i = 0; i < activeDrivers.size(); i++) {
                if (activeDrivers.get(i).getDriverStatus().equals(true)) {
                    System.out.print(i+1 + "-" +activeDrivers.get(i).getUserName() + " ");
                    System.out.print(activeDrivers.get(i).getPassword() + " ");
                    System.out.print(activeDrivers.get(i).getEmail() + " ");
                    System.out.print(activeDrivers.get(i).nationalId + " ");
                    System.out.println(activeDrivers.get(i).license + " ");
                    System.out.println("\n");
                }
            }
            return true;
        }
    }


    public boolean matchRidesWithDrivers() {
        if ( activeDrivers.isEmpty () ){
            return false;
        }
        else {
            for (int i = 0; i < activeDrivers.size ( ); i++) {
                boolean driverSource = false;
                for (int j = counter; j < rideRequests.size ( ); j++) {
                    driverSource = activeDrivers.get ( i ).getFavouriteArea ( ).contains ( rideRequests.get ( j ).getSource ( ) );
                    if ( driverSource ) {
                        activeDrivers.get ( i ).getRequestedRides ( ).add ( rideRequests.get ( j ) );
                    }
                }
            }
            counter ++;
            return true;
        }
    }

    public void showMatchedRides(Driver driver) { // show matched rides to a specific driver
        for (int i = 0; i < driver.getRequestedRides().size(); i++) {
            System.out.println(i + 1 + "-" + driver.getRequestedRides().get(i).toString());
        }
    }
    public void addRideRequest(Ride ride ,Client client){
        ride.setClient(client);
        rideRequests.add(ride);


    }
    public void showDriverFavouritePlaces(Driver driver){
        if(driver.favouriteArea.isEmpty()){
            System.out.println("There are no favourite areas yet");
        }
        else {
            for(int i=0;i<driver.favouriteArea.size();i++){
                System.out.println(i+1 + "-" + driver.favouriteArea.get(i));
            }
        }
    }
    public Client searchForClient(Client client){
        for(int i =0;i<clients.size();i++){
           if (clients.get(i).getUserName().equals(client.getUserName())
           && clients.get(i).getPassword().equals(client.getPassword())){
                return clients.get(i);
            }
        }
        return new Client("-1","-1");
    }
    public Driver searchForDriver(Driver driver){
        for(int i =0;i<activeDrivers.size();i++){
            if (activeDrivers.get(i).getUserName().equals(driver.getUserName())
                    && activeDrivers.get(i).getPassword().equals(driver.getPassword())){
                return activeDrivers.get(i);
            }
        }
        return new Driver("-1","-1");
    }

    public Ride searchForClientRide(Client client){

        for(int i =0;i<rideRequests.size();i++){
            if (rideRequests.get(i).client.getUserName().equals(client.getUserName())
            && rideRequests.get(i).client.getPassword().equals(client.getPassword())){
                return rideRequests.get(i);
            }
        }
        return new Ride("-1","-1");
    }

    public boolean showFinishedRides(Client client)
    {
        if ( client.finishedRides.isEmpty ())
        {
            System.out.println ( " You have no finished rides right now " );
            return false;
        }
        else
        {
            for (int i = 0 ; i < client.finishedRides.size () ; i++)
            {
                System.out.println ( client.finishedRides.get ( i ) );
            }
            return true;
        }
    }

    public void addFinishedRide(Ride ride)
    {
        ride.getClient ().finishedRides.add ( ride );
    }

}
