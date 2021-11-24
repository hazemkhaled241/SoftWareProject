import java.util.Scanner;

public class main {


    public static void main(String[] args) {
        // write your code here
        //Client client=new Client("hazem","123456");
        //Driver driver=new Driver ("mohamed","mohmedk112@gmail.com","258963","123456789","123456");
        //driver.addDriver();
        DataBaseSystem dataBaseSystem = DataBaseSystem.getInstance();
        dataBaseSystem.addAdmin();


        Scanner scan = new Scanner(System.in);
        while (true) {

            System.out.println("Choose 1-SingUp \n 2-SingIn");
            scan = new Scanner(System.in);
            String userChoice = scan.nextLine();
            if (userChoice.equals("1")) { // SignUp
                System.out.println("Enter as 1-Client \n 2-Driver ");
                String userChoice2 = scan.nextLine();
                if (userChoice2.equals("1")) {//client
                    System.out.println("Enter userName, email(optional), password respectively");
                    String userName = scan.nextLine();
                    String email = scan.nextLine();
                    String password = scan.nextLine();
                    Client client1 = new Client(userName, password);
                    client1.setEmail(email);
                    dataBaseSystem.addClient(client1);
                    System.out.println("");

                    continue;
                    // enter the system
                } else if (userChoice2.equals("2")) {//Driver
                    System.out.println("Enter userName, email(optional), password, nationalId, driverLicense respectively");
                    String userName = scan.nextLine();
                    String email = scan.nextLine();
                    String password = scan.nextLine();
                    String nationalId = scan.nextLine();
                    String driverLicense = scan.nextLine();
                    Driver driver1 = new Driver(userName, password, nationalId, driverLicense);
                    driver1.setEmail(email);
                    dataBaseSystem.addDriver(driver1); // add to pending list

                    System.out.println("Registration request send successfully, please wait until reviewing your request");
                    continue;
                } else { // enter valid number
                    System.out.println("inValid Number");
                }
            }

            //                         ----SignIn----                          //

            else if (userChoice.equals("2")) {
                System.out.println("Enter as 1-Client \n 2-Driver \n 3-Admin");
                String userChoice2 = scan.nextLine();

                //                         AS client

                if (userChoice2.equals("1")) {
                    System.out.println("Enter userName, password respectively");
                    String userName = scan.nextLine();
                    String password = scan.nextLine();
                    Client client = dataBaseSystem.searchForClient(new Client(userName, password));
                    if (client.getUserName().equals("-1")) {
                        System.out.println("user not found");
                        continue;
                    }
                    // enter to system as client   (client list)

                    if (dataBaseSystem.searchForUser(client)) {
                        System.out.println(" Welcome " + client.getUserName());
                        while (true) {
                            System.out.println(" 1- Pick a ride ");
                            System.out.println(" 2-Notification");
                            System.out.println(" 3-Logout");
                            int clientChoice1 = scan.nextInt();
                            if (clientChoice1 == 1) {
                                System.out.println("Enter source and destination of the ride respectively");
                                scan = new Scanner(System.in);
                                String sourceRide = scan.nextLine();
                                String destination = scan.nextLine();
                                Ride clientRide = new Ride(sourceRide, destination);
                                dataBaseSystem.addRideRequest(clientRide, client);
                                dataBaseSystem.matchRidesWithDrivers();

                            } else if (clientChoice1 == 2) {
                                Ride clientRide = dataBaseSystem.searchForClientRide(client);
                                if (clientRide.getSource().equals("-1")) {
                                    System.out.println("No Notifications");
                                    continue;
                                }
                                System.out.println("The driver offer you " + clientRide.getPrice() + " LE for yor ride");
                                System.out.println("press 1 to accept, press any else key to reject");

                                String choose = scan.nextLine();
                                if (choose.equals("1")) {
                                    clientRide.getDriver().setIsAvailable(false);
                                    clientRide.driver.getRequestedRides().remove(clientRide); // to delete the accepted ride from the driver list
                                    System.out.println("driver is coming to you");
                                    if(clientRide.driver.getIsAvailable()){
                                        System.out.println("You have been arrived successfully");
                                        System.out.println("1-Rate Driver");
                                        System.out.println("2-back to main menu");
//                                        scan = new Scanner(System.in);
//                                        String rateChoice = scan.nextLine();
                                        //////////////////////////////////////////
                                        // we will add another option to client to be able to list all teh finished rides so he can rate them or delete them
                                        // average rate for driver
                                        // create arraylist in driver to be able to show all users rates
                                        // handle menu
                                        // in admin menu add reject driver request feature
                                        // sequence diagram
                                        // trello pic
                                        // github link
                                        // sprint 1 doc
                                    }
                                }
                                else {
                                    dataBaseSystem.rideRequests.remove(clientRide);
                                    continue;
                                }

                            } else if (clientChoice1 == 3) {
                                break;

                                // client is waiting for the requested ride being accepted
                                // by a driver that will set offer for this ride

                            } else
                                System.out.println("not found");
                            break;
                        }
                    }
                } else if (userChoice2.equals("2")) {//Driver
                    System.out.println("Enter userName, password respectively");
                    String userName = scan.nextLine();
                    String password = scan.nextLine();
                    Driver driver = dataBaseSystem.searchForDriver(new Driver(userName, password));
                    if (driver.getUserName().equals("-1")) {
                        System.out.println("Driver not found");
                        continue;
                    }
                    if (dataBaseSystem.searchForUser(driver)){
                        System.out.println("Welcome driver " + userName); // enter to system as driver

                        while (true) {
                            System.out.println("1-show favourite places");
                            System.out.println("2-add favourite place");
                            System.out.println("3-show requested rides that matches your favourite place");
                            System.out.println("4-show clients rate");
                            System.out.println("5-logout");
                            int driverChoice1 = scan.nextInt();


                            if (driverChoice1 == 1) { // show favourite places
                                dataBaseSystem.showDriverFavouritePlaces(driver);
                                System.out.println("1- back to main menu");
                                int driverChoice2 = scan.nextInt();
                                if (driverChoice2 == 1) {
                                    continue;
                                }
                            } else if (driverChoice1 == 2) {

                                scan = new Scanner(System.in);
                                System.out.println("enter your favourite place");
                                String driverFavouritePlace = scan.nextLine();

                                driver.addFavouriteArea(driverFavouritePlace);
                                System.out.println("Added successfully");

                                System.out.println("1- back to main menu");
                                int driverChoice2 = scan.nextInt();
                                if (driverChoice2 == 1) {
                                    continue;
                                }
                            }
                            else if (driverChoice1 == 3) {
                                dataBaseSystem.showMatchedRides(driver);
                                System.out.println("choose ride");
                                int rideNumber = scan.nextInt();
                                Ride ride = driver.getRequestedRides().get(rideNumber - 1);
                                System.out.println("1-Set offer to ride");
                                System.out.println("2-Reject Ride");
                                System.out.println("3-Back to main menu");
                                int driverChoice2 = scan.nextInt();
                                if (driverChoice2 == 1) {
                                    System.out.println("Enter ride offer:");
                                    double driverOffer = scan.nextDouble();
                                    ride.setPrice(driverOffer);
                                    ride.setDriver(driver);
                                    System.out.println("offer set and send to user successfully");
                                    if(!driver.getIsAvailable()){
                                        scan = new Scanner(System.in);
                                        System.out.println("offer Accepted ");
                                        System.out.println("Ride begin...");
                                        System.out.println("To end Ride Enter 1");
                                        String rideStatus = scan.nextLine();
                                        if(rideStatus.equals("1")){
                                            driver.setDriverStatus(true);
                                            System.out.println("ride ended successfully");
                                        }
                                    }


                                }
                                else if (driverChoice2 == 2) {
                                    driver.getRequestedRides().remove(ride);
                                    System.out.println("Ride Rejected");
                                }
                                else if (driverChoice2 == 3) {

                                }
                            }
                            else if (driverChoice1 == 4) {

                            }
                            else if (driverChoice1 == 5) {

                                break;
                            }
                        }
                    }

                    else
                        System.out.println("not found");

                } else if (userChoice2.equals("3")) { //admin
                    System.out.println("Enter userName, password respectively");
                    String userName = scan.nextLine();
                    String password = scan.nextLine();
                    Admin admin = new Admin(userName, password);
                    if (dataBaseSystem.searchForUser(admin)) {
                        System.out.println("welcome"); // enter to system as driver
                        System.out.println("1-show list of driver pending requests");
                        System.out.println("2-Suspend / unSuspend client");
                        System.out.println("3-Suspend / unSuspend driver");

                        String userChoice3 = scan.nextLine();
                        if (userChoice3.equals("1")) {
                            if (dataBaseSystem.showPendingRequests()) {
                                System.out.println("choose driver number to accept request");
                                Integer userChoice4 = scan.nextInt();
                                admin.acceptDriverRequest(userChoice4);
                            } else {
                                continue;
                            }
                        } else if (userChoice3.equals("2")) {
                            if (dataBaseSystem.showClientsList()) {
                                System.out.println(" Choose a client to be 1-Suspended / 2-unSuspended");
                                int adminChoice = scan.nextInt();

                                if (adminChoice == 1) {
                                    System.out.println(" Enter client number ");
                                    int clientID = scan.nextInt();
                                    admin.suspendClient(clientID);
                                } else if (adminChoice == 2) {
                                    System.out.println(" Enter client number ");
                                    int clientID = scan.nextInt();
                                    admin.unSuspendClient(clientID);
                                }
                            } else {
                                continue;
                            }
                        } else if (userChoice3.equals("3")) {
                            if (dataBaseSystem.showActiveDrivers()) {
                                System.out.println(" Choose a client to be 1-Suspended / 2-unSuspended");
                                int adminChoice = scan.nextInt();

                                if (adminChoice == 1) {
                                    System.out.println(" Enter Driver number ");
                                    int driverID = scan.nextInt();
                                    admin.suspendDriver(driverID);
                                } else if (adminChoice == 2) {
                                    System.out.println(" Enter client number ");
                                    int driverID = scan.nextInt();
                                    admin.unSuspendDriver(driverID);
                                }
                            }
                        } else { // enter valid number

                        }
                    } else {
                        System.out.println("not found");
                    }
                }

            }
        }
    }

}

