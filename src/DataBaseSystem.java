import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataBaseSystem {
    ArrayList<Ride> rideRequests = new ArrayList<>();
    ArrayList<Client> clients = new ArrayList<>();
    ArrayList<Driver> activeDrivers = new ArrayList<>();
    ArrayList<Driver> pendingDrivers = new ArrayList<>();
    ArrayList<Admin> currAdmins = new ArrayList<>();
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


    public void matchRidesWithDrivers() {

        for (int i = 0; i < activeDrivers.size(); i++) {
            boolean driverSource =false;
            for (int j = 0; j < rideRequests.size(); j++) {
                driverSource=activeDrivers.get(i).getFavouriteArea().contains(rideRequests.get(j).getSource());
                if (driverSource) {
                    activeDrivers.get(i).getRequestedRides().add(rideRequests.get(j));
                }
            }
        }
    }

    public void showMatchedRides(Driver driver) { // show matched rides to a specific driver
        for (int i = 0; i < driver.getRequestedRides().size(); i++) {
            System.out.println(i + 1 + "-" + driver.getRequestedRides().get(i));
        }
    }
    public void addRideRequest(Ride ride ,Client client){
        ride.setClient(client);
        rideRequests.add(ride);


    }
    public void showDriverFavouritePlaces(Driver driver){
        for(int i=0;i<driver.favouriteArea.size();i++){
            System.out.println(i+1 + "-" + driver.favouriteArea.get(i));
        }

    }


}
