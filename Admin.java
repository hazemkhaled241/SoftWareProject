package com.company;

public class Admin extends User{
    DataBaseSystem dataBaseSystem=DataBaseSystem.getInstance();
    public Admin(String userName, String password) {
        super(userName, password);
    }

    public void suspendClient(Integer index){
        dataBaseSystem.clients.get(index-1).setStatus(false);
        dataBaseSystem.suspendedClients.add(dataBaseSystem.clients.get(index-1));
    }
    public void unSuspendClient(Integer index){
        dataBaseSystem.clients.get(index-1).setStatus(true);
       // dataBaseSystem.suspendedClients.remove(dataBaseSystem.clients.get(index-1));
    }
    public void suspendDriver(Integer index){
        dataBaseSystem.activeDrivers.get(index-1).setDriverStatus(false);
        dataBaseSystem.suspendedDrivers.add(dataBaseSystem.activeDrivers.get(index-1));
    }
    public void activateDriver(Integer index){
        dataBaseSystem.activeDrivers.get(index-1).setDriverStatus(true);
        //dataBaseSystem.suspendedDrivers.remove(dataBaseSystem.activeDrivers.get(index-1));
    }
    public void acceptDriverRequest(Integer index){
        dataBaseSystem.pendingDrivers.get(index-1).setDriverStatus(true);
        dataBaseSystem.activeDrivers.add( dataBaseSystem.pendingDrivers.get(index-1));
        dataBaseSystem.pendingDrivers.remove(index-1);
    }

}
