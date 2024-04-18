import java.util.Scanner;
import java.util.Date;
public class Main {
    protected static Scanner input = new Scanner(System.in);
    protected final static String stofofroot = """
                 ░▒▓███████▓▒░▒▓████████▓▒░▒▓██████▓▒░░▒▓████████▓▒░▒▓██████▓▒░░▒▓████████▓▒░▒▓███████▓▒░ ░▒▓██████▓▒░ ░▒▓██████▓▒░▒▓████████▓▒░\s
                ░▒▓█▓▒░         ░▒▓█▓▒░  ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░     ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░ ░▒▓█▓▒░    \s
                ░▒▓█▓▒░         ░▒▓█▓▒░  ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░     ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░ ░▒▓█▓▒░    \s
                 ░▒▓██████▓▒░   ░▒▓█▓▒░  ░▒▓█▓▒░░▒▓█▓▒░▒▓██████▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓██████▓▒░ ░▒▓███████▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░ ░▒▓█▓▒░    \s
                       ░▒▓█▓▒░  ░▒▓█▓▒░  ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░     ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░ ░▒▓█▓▒░    \s
                       ░▒▓█▓▒░  ░▒▓█▓▒░  ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░     ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░ ░▒▓█▓▒░    \s
                ░▒▓███████▓▒░   ░▒▓█▓▒░   ░▒▓██████▓▒░░▒▓█▓▒░      ░▒▓██████▓▒░░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░░▒▓██████▓▒░ ░▒▓██████▓▒░  ░▒▓█▓▒░""";
    public static void main(String[] args) {
        System.out.println(stofofroot);

        Store store = start();

        while (true){
            mainMenu();
        }
    }

    /**
     * Initial store setup.
     * @return New instance of store.
     */
    public static Store start(){
        System.out.print("""
                Welcome to stofofroot [storage for fruits]! Please select an option below:
                [1] Create new store.
                [0] Load demo.
                
                input:""");
        int choice = collectInt(0, 1);

        switch (choice){
            case 1:
                System.out.print("""
                Please enter the name for the store...
                
                input:""");
                String storeName = collectString();
                return new Store(storeName);
            case 0:
                System.out.println("Loading demo store...");
                return initializeDemo();
            default:
                return null;
        }
    }

    /**
     * Initializes a new Store and fills its variables with pre-made values.
     * @return New Store.
     */
    public static Store initializeDemo(){
        //Creating store:
        Store store = new Store("Shafil's Frooty Tooty");
        // Apples:
        Fruit redDeliciousApple = new Fruit("Apple","Red Delicious", 15, .5);
        store.addFruitOption(redDeliciousApple);
        store.addFruitOption(new Fruit("Apple", "Granny Smith", 18, .45));
        store.addFruitOption(new Fruit("Apple", "Honey Crisp", 16, .33));
        //Bananas:
        Fruit ladyFingerBanana = new Fruit("Banana", "Lady Finger", 10, .25);
        store.addFruitOption(ladyFingerBanana);
        store.addFruitOption(new Fruit("Banana", "Senorita", 9, .2));
        store.addFruitOption(new Fruit("Banana", "Plu", 14, .23));
        //Oranges:
        Fruit bloodOrange = new Fruit("Orange", "Blood", 18, .65);
        store.addFruitOption(bloodOrange);
        store.addFruitOption(new Fruit("Orange", "Navel", 20, .5));
        store.addFruitOption(new Fruit("Orange", "Common", 13, .65));
        //Mangoes:
        Fruit aliceMango = new Fruit("Mango", "Alice", 16, .4);
        store.addFruitOption(aliceMango);
        store.addFruitOption(new Fruit("Mango", "Angie", 18, .65));
        store.addFruitOption(new Fruit("Mango", "Amrapali", 13, .57));
        //Strawberries:
        Fruit alintaStrawberry = new Fruit("Strawberry", "Alinta", 17, .55);
        store.addFruitOption(alintaStrawberry);
        store.addFruitOption(new Fruit("Strawberry", "Allstar", 19, .6));
        store.addFruitOption(new Fruit("Strawberry", "Amelia", 10, .55));
        //Blueberries:
        store.addFruitOption(new Fruit("Blueberry", "Northern Highbush", 11, .7));
        store.addFruitOption(new Fruit("Blueberry", "Rabbiteye", 9, .42));
        store.addFruitOption(new Fruit("Blueberry", "Lowbush", 14, .51));
        //Raspberries:
        store.addFruitOption(new Fruit("Raspberry", "Red", 15, .4));
        store.addFruitOption(new Fruit("Raspberry", "Jewel", 17, .41));
        store.addFruitOption(new Fruit("Raspberry", "Golden", 19, .7));

        //Creating sample shipments:
        Date shipmentDate1 = new Date(2024, 0, 1);
        Date shipmentDate2 = new Date(2024, 1, 5);
        Date shipmentDate3 = new Date(2024, 2, 24);
        Date shipmentDate4 = new Date(2024, 3, 1);
        Date shipmentDate5 = new Date(2024, 3, 5);

        store.addShipment(new Shipment(store.getShipmentID(), redDeliciousApple, 50, shipmentDate1));
        store.addShipment(new Shipment(store.getShipmentID(), ladyFingerBanana, 30, shipmentDate2));
        store.addShipment(new Shipment(store.getShipmentID(), bloodOrange, 15, shipmentDate3));
        store.addShipment(new Shipment(store.getShipmentID(), aliceMango, 25, shipmentDate4));
        store.addShipment(new Shipment(store.getShipmentID(), alintaStrawberry, 28, shipmentDate5));

        //Creating sample purchases:
        store.addPurchase(new Purchase(store.getPurchaseID(), redDeliciousApple, 5, 10.00));
        store.addPurchase(new Purchase(store.getPurchaseID(), aliceMango, 10, 40.00));
        store.addPurchase(new Purchase(store.getPurchaseID(), alintaStrawberry, 12, 6.00));
        store.addPurchase(new Purchase(store.getPurchaseID(), redDeliciousApple, 10, 18.00));

        System.out.println("Loaded demo! Includes: [21] fruit options, [5] shipments, and [4] purchases.");
        return store;
    }

    /**
     * Collects a valid input integer from the user. Verifies the integer is within a specified range.
     * @param minNum Minimum integer a user can use.
     * @param maxNum Maximum integer a use can use.
     * @return Valid integer input.
     */
    public static int collectInt(int minNum, int maxNum){
        int result;
        while (true){
            try{
                result = input.nextInt();
                input.nextLine();
            }
            catch (Exception e){
                System.out.print("ERROR! Please input an integer:\n\nNew attempt:");
                continue;
            }

            if ((result > maxNum) || (result < minNum)){
                System.out.print("ERROR! Please input a valid number:\n\nNew attempt:");
            }
            else {
                System.out.println();
                return result;
            }
        }
    }

    /**
     * Collects a valid String from the user.
     * @return Valid String input.
     */
    public static String collectString(){
        String result;
        while (true){
            try{
                result = input.nextLine();
                System.out.println();
                return result;
            }
            catch (Exception e){
                System.out.print("ERROR! Please input a valid word:\n\nNew attempt:");
            }
        }
    }

    /**
     * Main menu screen.
     */
    public static void mainMenu(){
        System.out.print("""
                Please select one of the following actions:
                [2] View
                [1] Add
                [0] Exit
                
                input:""");
        int choice = collectInt(0, 2);
        switch (choice){
            case 2:
                viewMenu();
                break;
            case 1:
                addMenu();
                break;
            case 0:
                System.out.println(stofofroot);
                System.out.println("Thank you for using stofofroot! Have a great day :)");
                System.exit(0);
        }
    }

    public static void viewMenu(){

    }

    public static void addMenu(){

    }
}