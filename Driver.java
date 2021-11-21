package com.company;

import java.util.ArrayList;

public class Driver extends User{
    Boolean driverStatus = false;
    int id;
    String nationalId;
    String license;
    Boolean available = true;
    ArrayList<String> favouriteArea ;

    public Driver(String userName, String password, String nationalId, String license) {
        super(userName, password);
        this.nationalId = nationalId;
        this.license = license;
    }
    public Driver(String userName, String password){
        super(userName,password);

    }
    public Boolean getAvailable() {
        return available;
    }
    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Boolean getDriverStatus() {
        return driverStatus;
    }
    public void setDriverStatus(Boolean driverStatus) {
        this.driverStatus = driverStatus;
    }
    public void addFavouriteArea(String place){
        favouriteArea.add(place);
    }

    @Override
    public String toString () {
        return "Driver{" +
                "driverStatus=" + driverStatus +
                ", id=" + id +
                ", nationalId='" + nationalId + '\'' +
                ", license='" + license + '\'' +
                ", available=" + available +
                ", favouriteArea=" + favouriteArea +
                '}';
    }
}
