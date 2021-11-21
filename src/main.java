import java.util.Scanner;

public class main {


        public static void main( String[] args ) {
            // write your code here
            //Client client=new Client("hazem","123456");
            //Driver driver=new Driver ("mohamed","mohmedk112@gmail.com","258963","123456789","123456");
            //driver.addDriver();
            DataBaseSystem dataBaseSystem = DataBaseSystem.getInstance();
            dataBaseSystem.addAdmin();

            Scanner scan = new Scanner(System.in);
            while (true) {

                System.out.println("Choose 1-SingUp \n 2-SingIn");
                String userChoice = scan.nextLine();
                if (userChoice.equals("1")) { // SignUp
                    System.out.println("Enter as 1-Client \n 2-Driver ");
                    String userChoice2 = scan.nextLine();
                    if (userChoice2.equals("1")) {//client
                        System.out.println("Enter userName, email(optional), password respectively");
                        String userName = scan.nextLine();
                        String email = scan.nextLine();
                        String password = scan.nextLine();
                        Client client = new Client(userName, password);
                        client.setEmail(email);
                        dataBaseSystem.addClient(client);
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
                        Driver driver = new Driver(userName, password, nationalId, driverLicense);
                        driver.setEmail(email);
                        dataBaseSystem.addDriver(driver); // add to pending list

                        System.out.println("Registration request send successfully, please wait until reviewing your request");
                        continue;
                    } else { // enter valid number
                        System.out.println("inValid Number");
                    }
                }

                //                         ----SignIn----                          //

                else {
                    System.out.println("Enter as 1-Client \n 2-Driver \n 3-Admin");
                    String userChoice2 = scan.nextLine();

                    //                         AS client

                    if (userChoice2.equals("1")) {
                        System.out.println("Enter userName, password respectively");
                        String userName = scan.nextLine();
                        String password = scan.nextLine();
                        User client = new Client(userName, password);

                        // enter to system as client   (client list)

                        if (dataBaseSystem.searchForUser(client)) {
                            System.out.println(" Welcome " + client.getUserName());
                            System.out.println(" 1- Pick a ride ");
                            Integer clientChoice1 = scan.nextInt();
                            if (clientChoice1 == 1){
                                System.out.println("Enter source and destination of the ride respectively");
                                String sourceRide = scan.nextLine();
                                String destination = scan.nextLine();
                                Ride clientRide = new Ride(sourceRide,destination);
                                dataBaseSystem.addRideRequest(clientRide);
                                dataBaseSystem.matchRidesWithDrivers();
                                // client is waiting for the requested ride being accepted
                                // by a driver that will set offer for this ride
                            }
                        } else
                            System.out.println("not found");
                        continue;

                    }
                    else if (userChoice2.equals("2")) {//Driver
                        System.out.println("Enter userName, password respectively");
                        String userName = scan.nextLine();
                        String password = scan.nextLine();
                        Driver driver = new Driver(userName, password);
                        if (dataBaseSystem.searchForUser(driver))
                            while (true){
                                System.out.println("Welcome driver "+userName); // enter to system as driver
                                System.out.println("1-show favourite places");
                                System.out.println("2-add favourite place");
                                System.out.println("3-show requested rides that matches your favourite place");
                                System.out.println("4-show clients rate");
                                Integer driverChoice1 = scan.nextInt();

                                if(driverChoice1 == 1){ // show favourite places
                                    dataBaseSystem.showDriverFavouritePlaces(driver);
                                    System.out.println("1- back to main menu");
                                    Integer driverChoice2 = scan.nextInt();
                                    if (driverChoice2 == 1){
                                        continue;
                                    }
                                }
                                else if (driverChoice1 == 2){
                                    System.out.println("enter your favourite place");
                                    String driverFavouritePlace = scan.nextLine();
                                    driver.addFavouriteArea(driverFavouritePlace);
                                    System.out.println("Added successfully");

                                    System.out.println("1- back to main menu");
                                    Integer driverChoice2 = scan.nextInt();
                                    if (driverChoice2 == 1){
                                        continue;
                                    }
                                }
                                else if (driverChoice1 ==3){
                                    dataBaseSystem.showMatchedRides(driver);
                                    System.out.println("1-accept and set offer to ride");
                                    System.out.println("2-reject ride");
                                    System.out.println("3- back to main menu");
                                    Integer driverChoice2 = scan.nextInt();
                                    if (driverChoice2 == 1){

                                    }
                                    else if (driverChoice2 == 2){

                                    }
                                   else if (driverChoice2 == 3){
                                        continue;
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

