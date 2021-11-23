public class Client extends User {
    Boolean clientStatus=true;
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
