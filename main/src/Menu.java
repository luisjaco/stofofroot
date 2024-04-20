import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * The Menu class is user to handle all the user experience. Contains methods for each menu.
 */
public class Menu {
    private Scanner input;
    private Store store;
    protected final static String stofofroot = """
                 ░▒▓███████▓▒░▒▓████████▓▒░▒▓██████▓▒░░▒▓████████▓▒░▒▓██████▓▒░░▒▓████████▓▒░▒▓███████▓▒░ ░▒▓██████▓▒░ ░▒▓██████▓▒░▒▓████████▓▒░\s
                ░▒▓█▓▒░         ░▒▓█▓▒░  ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░     ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░ ░▒▓█▓▒░    \s
                ░▒▓█▓▒░         ░▒▓█▓▒░  ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░     ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░ ░▒▓█▓▒░    \s
                 ░▒▓██████▓▒░   ░▒▓█▓▒░  ░▒▓█▓▒░░▒▓█▓▒░▒▓██████▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓██████▓▒░ ░▒▓███████▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░ ░▒▓█▓▒░    \s
                       ░▒▓█▓▒░  ░▒▓█▓▒░  ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░     ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░ ░▒▓█▓▒░    \s
                       ░▒▓█▓▒░  ░▒▓█▓▒░  ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░     ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░ ░▒▓█▓▒░    \s
                ░▒▓███████▓▒░   ░▒▓█▓▒░   ░▒▓██████▓▒░░▒▓█▓▒░      ░▒▓██████▓▒░░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░░▒▓██████▓▒░ ░▒▓██████▓▒░  ░▒▓█▓▒░""";

    /**
     * Initializes a new Menu class.
     */
    public Menu(){
        this.input = new Scanner(System.in);
    }
    /**
     * Initial store setup.
     */
    public void start(){
        System.out.println(stofofroot);
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
                this.store = new Store(storeName);
                break;
            case 0:
                System.out.println("Loading demo store...");
                initializeDemo();
                System.out.println("Loaded demo! Includes: [21] fruit options, [5] shipments, and [4] purchases.");
                break;
            default:
                break;
        }
    }

    /**
     * Program loop.
     */
    public void run(){
        while (mainMenu()){
            //Runs as long as mainMenu is returning true. (until user exits.)
            System.out.println();
        }

        System.out.println(stofofroot);
        System.out.println("Thank you for using stofofroot! Have a great day :)");
    }

    /**
     * Initializes a new Store and fills its variables with pre-made values.
     */
    private void initializeDemo(){
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

        this.store = store;
    }

    /**
     * Collects a valid input integer from the user. Verifies the integer is within a specified range.
     * @param minNum Minimum integer a user can use.
     * @param maxNum Maximum integer a use can use.
     * @return Valid integer input.
     */
    private int collectInt(int minNum, int maxNum){
        int result;
        while (true){
            try{
                result = this.input.nextInt();
                this.input.nextLine();
            }
            catch (Exception e){
                System.out.print("ERROR! Please input an integer:\n\nNew attempt:");
                continue;
            }

            if ((result > maxNum) || (result < minNum)){
                System.out.print("ERROR! Please input a valid number.\n\nNew attempt:");
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
    private String collectString(){
        String result;
        while (true){
            try{
                result = this.input.nextLine();
                System.out.println();
                return result;
            }
            catch (Exception e){
                System.out.print("ERROR! Please input a valid word.\n\nNew attempt:");
            }
        }
    }

    /**
     * Main menu screen.
     */
    private boolean mainMenu(){
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
                //TODO addMenu();
                break;
            case 0:
                // Returns false to end the run() loop.
                return false;
            default:
                break;
        }
        return true;
    }

    /**
     * Menu screen for viewing store components.
     */
    public void viewMenu(){
        System.out.print("""
                ~View~
                Please select from the following options:
                [4] View inventory
                [3] View fruit options
                [2] View shipments
                [1] View purchases
                [0] Back
                
                input:""");
        int choice = collectInt(0,4);
        switch (choice){
            case 4:
                this.store.displayInventory();
                break;
            case 3:
                viewFruitOptionsMenu();
                break;
            case 2:
                viewShipmentMenu();
                break;
            case 1:
                viewPurchaseMenu();
                break;
            case 0:
                break;
            default:
                break;
        }
    }
    private void viewFruitOptionsMenu(){
        System.out.print("""
                ~View fruit options~
                Please select from the following options:
                [4] View all fruit options
                [3] View fruit options sorted by price
                [2] View fruit options sorted by shelf life
                [1] Search for fruit
                [0] Back
                
                input:""");
        int choice = collectInt(0, 4);
        switch (choice) {
            case 4:
                this.store.displayFruitOptions();
                break;
            case 3:
                sortFruitOptions(3);
                break;
            case 2:
                sortFruitOptions(2);
                break;
            case 1:
                searchForFruit();
                break;
            case 0:
                break;
            default:
                break;
        }
    }
    private void sortFruitOptions(int choice){
        ArrayList<Fruit> sortedFruit = new ArrayList<>();
        switch (choice){
            case 3:
                sortedFruit = this.store.fruitOptionsSortedByPrice();
                break;
            case 2:
                sortedFruit = this.store.fruitOptionsSortedByShelfLife();
                break;
            default:
                break;
        }
        System.out.println("Printing sorted fruit options...");
        for (Fruit fruit : sortedFruit){
            System.out.println(fruit + "\n~");
        }
    }
    private void searchForFruit(){
        System.out.print("Fruit species: (Ex: Apple)\n\ninput:");
        String species = collectString();
        System.out.print("\nFruit cultivar: (Ex: Granny Smith)\n\ninput:");
        String cultivar = collectString();
        Fruit testFruit = new Fruit(species, cultivar, 0, 0.0);
        System.out.println("Searching for %s %s...".formatted(cultivar, species));
        if (this.store.containsFruitOption(testFruit)){
            System.out.println("Fruit is available at this store!");
        }
        else {
            System.out.println("Fruit is not available at this store.");
        }
    }
    private void viewShipmentMenu(){
        System.out.print("""
                ~View shipments~
                Please select from the following options:
                [2] Shipment history
                [1] Oldest shipment
                [0] Back
                
                input:""");
        int choice = collectInt(0,2);
        switch (choice){
            case 2:
                this.store.displayShipmentHistory();
                break;
            case 1:
                oldestShipmentMenu();
                break;
            case 0:
                break;
            default:
                break;
        }
    }
    private void oldestShipmentMenu(){
        Shipment shipment = this.store.peekOldestShipment();
        System.out.print("""
                ~Oldest shipment~
                
                %s
                
                Discard shipment and it's contents?:
                [1] Yes
                [0] No
                
                input:""".formatted(shipment));
        int choice = collectInt(0,1);
        switch (choice){
            case 1:
                int removed = this.store.discardOldestShipment();
                System.out.println("Discarded oldest shipment! Removed [%d] %s's.".formatted(removed, shipment.getFruit().getFruitTitle()));
                break;
            case 0:
                break;
            default:
                break;
        }
    }
    private void viewPurchaseMenu(){
        System.out.print("""
                ~View purchase~
                Please select from the following options:
                [2] Purchase history
                [1] Most recent purchase
                [0] Back
                
                input:""");
        int choice = collectInt(0, 2);

        switch (choice) {
            case 2:
                this.store.displayPurchases();
                break;
            case 1:
                System.out.println(this.store.peekMostRecentPurchase());
                break;
            case 0:
                break;
            default:
                break;
        }
    }
}
