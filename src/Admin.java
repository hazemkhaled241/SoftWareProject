public class Admin extends User implements IAdmin {
    DataBaseSystem dataBaseSystem=DataBaseSystem.getInstance();
    public Admin(String userName, String password) {
        super(userName, password);
    }
    @Override
    public void suspendClient(Integer index){
        dataBaseSystem.clients.get(index-1).setStatus(false);

    }
    @Override
    public void unSuspendClient(Integer index){
        dataBaseSystem.clients.get(index-1).setStatus(true);

    }
    @Override
    public void suspendDriver(Integer index){
        dataBaseSystem.activeDrivers.get(index-1).setDriverStatus(false);

    }
    @Override
    public void unSuspendDriver(Integer index){
        dataBaseSystem.activeDrivers.get(index-1).setDriverStatus(true);

    }
    @Override
    public void acceptDriverRequest(Integer index){
        dataBaseSystem.pendingDrivers.get(index-1).setDriverStatus(true);
        dataBaseSystem.activeDrivers.add( dataBaseSystem.pendingDrivers.get(index-1));
        dataBaseSystem.pendingDrivers.remove(index-1);

    }
    @Override
    public void rejectDriverRequest(Integer index){
        dataBaseSystem.pendingDrivers.remove(index-1);
    }


}
