import java.util.ArrayList;

public class Driver extends User {
    Boolean driverStatus = false;
    String nationalId;
    String license;
    Boolean available = true;
    ArrayList<String> favouriteArea=new ArrayList<>() ;
    ArrayList<Ride> requestedRides=new ArrayList<>() ;
    ArrayList<Integer> userRate=new ArrayList<>();
    public Driver(String userName, String password, String nationalId, String license) {
        super(userName, password);
        this.nationalId = nationalId;
        this.license = license;
    }
    public Driver(String userName, String password){
        super(userName,password);
    }
    public Boolean getIsAvailable() {
        return available;
    }
    public void setIsAvailable(Boolean available) {
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

    public ArrayList<String> getFavouriteArea() {
        return favouriteArea;
    }

    public ArrayList<Ride> getRequestedRides() {
        return requestedRides;
    }


}
