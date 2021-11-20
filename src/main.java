import java.util.Scanner;

public class main {

    public static void main(String[] args) {
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
            } else { // SignIn
                System.out.println("Enter as 1-Client \n 2-Driver \n 3-Admin");
                String userChoice2 = scan.nextLine();

                if (userChoice2.equals("1")) {//client
                    System.out.println("Enter userName, password respectively");
                    String userName = scan.nextLine();
                    String password = scan.nextLine();
                    User client = new Client(userName, password);

                    if (dataBaseSystem.searchForUser(client))
                        System.out.println("client found"); // enter to system as client

                    else
                        System.out.println("not found");
                    break;

                } else if (userChoice2.equals("2")) {//Driver
                    System.out.println("Enter userName, password respectively");
                    String userName = scan.nextLine();
                    String password = scan.nextLine();
                    User driver = new Driver(userName, password);
                    if (dataBaseSystem.searchForUser(driver))
                        System.out.println("Driver found"); // enter to system as driver

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
                        System.out.println("2-suspend client");
                        System.out.println("3-suspend driver");
                        String userChoice3 = scan.nextLine();
                        if (userChoice3.equals("1")) {
                            dataBaseSystem.showPendingRequests();
                            System.out.println("choose driver number to accept request");
                            Integer userChoice4 = scan.nextInt();
                            admin.acceptDriverRequest(userChoice4);
                        }
                    } else
                        System.out.println("not found");
                } else { // enter valid number

                }
            }
        }

    }
}
