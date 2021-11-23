public class Admin extends User {
    DataBaseSystem dataBaseSystem=DataBaseSystem.getInstance();
    public Admin(String userName, String password) {
        super(userName, password);
    }

    public void suspendClient(Integer index){
        dataBaseSystem.clients.get(index-1).setStatus(false);

    }
    public void unSuspendClient(Integer index){
        dataBaseSystem.clients.get(index-1).setStatus(true);

    }
    public void suspendDriver(Integer index){
        dataBaseSystem.activeDrivers.get(index-1).setDriverStatus(false);

    }
    public void unSuspendDriver(Integer index){
        dataBaseSystem.activeDrivers.get(index-1).setDriverStatus(true);

    }
    public void acceptDriverRequest(Integer index){
        dataBaseSystem.pendingDrivers.get(index-1).setDriverStatus(true);
        dataBaseSystem.activeDrivers.add( dataBaseSystem.pendingDrivers.get(index-1));
        dataBaseSystem.pendingDrivers.remove(index-1);

    }


}
