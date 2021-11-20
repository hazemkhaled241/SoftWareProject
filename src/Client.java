public class Client extends User {
   Boolean clientStatus=true;
    DataBaseSystem dataBaseSystem=DataBaseSystem.getInstance();
    public Client(String userName, String email, String password) {
        super(userName, email, password);
    }

    public Boolean getStatus() {
        return clientStatus;
    }

    public void setStatus(Boolean status) {
        this.clientStatus = status;

    }
    public void requestRide(Ride ride){

    dataBaseSystem.rideRequests.add(ride);

    }

}
