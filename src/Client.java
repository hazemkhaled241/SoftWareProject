import java.util.ArrayList;

public class Client extends User {

    ArrayList<Ride> finishedRides = new ArrayList<> ();
    Boolean clientStatus=true;
    int count = 0 ;

    public void setCount(int count) {
        this.count = count;
    }

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


}
