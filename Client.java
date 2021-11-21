package com.company;

public class Client extends User{
    Boolean clientStatus=true;
    int id ;
    DataBaseSystem dataBaseSystem=DataBaseSystem.getInstance();
    public Client(String userName, String password) {
        super(userName, password);
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

    @Override
    public String toString () {
        return "Client{" +
                "clientStatus=" + clientStatus +
                ", id=" + id +
                ", dataBaseSystem=" + dataBaseSystem +
                '}';
    }
}
