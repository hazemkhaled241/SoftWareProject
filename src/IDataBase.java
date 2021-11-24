public interface IDataBase {
    void acceptDriver(Driver driver);
    Boolean searchForUser(User user);
    void addAdmin();
    boolean showPendingRequests();
    boolean showClientsList();
    boolean showActiveDrivers();
    boolean matchRidesWithDrivers();
    void showMatchedRides(Driver driver);
    void addRideRequest(Ride ride ,Client client);
    void showDriverFavouritePlaces(Driver driver);
    Client searchForClient(Client client);
    Driver searchForDriver(Driver driver);
    Ride searchForClientRide(Client client);
    void showUserRate(Driver driver);
    void addDriverRate(int rate,Driver driver);
    double avgDriverRate(Driver driver);
}
