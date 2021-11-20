public class Driver extends User{
    Boolean driverStatus=false;
    String nationalId;
    String license;
    public Driver(String userName, String email, String password,String nationalId,String license) {
        super(userName, email, password);
        this.nationalId=nationalId;
        this.license=license;

    }

    public Boolean getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(Boolean driverStatus) {
        this.driverStatus = driverStatus;
    }

}
