import java.util.ArrayList;

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

    public void showPendingRequests() {
        for (int i = 0; i < pendingDrivers.size(); i++) {
            System.out.print(i + 1);
            System.out.print(pendingDrivers.get(i).getUserName() + " ");
            System.out.print(pendingDrivers.get(i).getPassword() + " ");
            System.out.print(pendingDrivers.get(i).getEmail() + " ");
            System.out.print(pendingDrivers.get(i).nationalId + " ");
            System.out.println(pendingDrivers.get(i).license + " ");
            System.out.println("\n");
        }
    }

    public void matchRidesWithDrivers() {
        for (int i = 0; i < activeDrivers.size(); i++) {
            for (int j = 0; j < rideRequests.size(); j++) {
                Boolean driverSource = activeDrivers.get(i).favouriteArea.contains(rideRequests.get(j).source);
                if (driverSource) {
                    activeDrivers.get(i).requestedRides.add(rideRequests.get(j));
                }
            }
        }
    }

    public void showMatchedRides(Driver driver) {
        for (int i = 0; i < driver.requestedRides.size(); i++) {
            System.out.println(i + 1 + "-" + driver.requestedRides.get(i));
        }
    }

}
