import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * The Menu class is used to handle the user experience. Contains methods for each menu.
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
        //Does nothing.
    }
    /**
     * Initial store setup.
     */
    public void start(){
        this.input = new Scanner(System.in);
        System.out.println(stofofroot);
        System.out.print("""
                Welcome to stofofroot [storage for fruits]! Please select an option below:
                [2] Create new store
                [1] Load demo
                [0] Exit
                
                input:""");
        int choice = collectInt(0, 2);

        switch (choice) {
            case 2 -> {
                System.out.print("""
                        Please enter the name for the store...
                                        
                        input:""");
                String storeName = collectString();
                this.store = new Store(storeName);
            }
            case 1 -> {
                System.out.println("Loading demo store...");
                initializeDemo();
                System.out.println("Loaded demo! Includes: [21] fruit options, [5] shipments, and [4] purchases.");
            }
            case 0 -> {
                exit();
                return;
            }
            default -> {
            }
        }
        // In every case but 0, we will perform run()
        run();
    }

    /**
     * Program loop.
     */
    private void run(){
        while (mainMenu()){
            //Runs as long as mainMenu is returning true. (until user exits.)
            System.out.println();
        }
        exit();
    }

    /**
     * Exit sequence.
     */
    private void exit(){
        System.out.println(stofofroot);
        System.out.println("Thank you for using stofofroot! Have a great day :)");
        this.input.close();
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
                this.input.nextLine();
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
     * Collects a valid input double from the user. Verifies the double is within a specified range.
     * @param minNum Minimum double a user can use.
     * @param maxNum Maximum double a use can use.
     * @return Valid double input.
     */
    private double collectDouble(double minNum, double maxNum){
        double result;
        while (true){

            try{
                result = this.input.nextDouble();
                this.input.nextLine();
            }
            catch (Exception e){
                System.out.print("ERROR! Please input a double:\n\nNew attempt:");
                this.input.nextLine();
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
                System.out.println("ERROR! Please input a valid word.\n\nNew attempt:");
            }
        }
    }

    /**
     * Main menu screen.
     */
    private boolean mainMenu(){
        System.out.print("""
                ~Main~
                Please select one of the following actions:
                [2] View
                [1] Add
                [0] Exit
                
                input:""");
        int choice = collectInt(0, 2);
        switch (choice) {
            case 2 -> viewMenu();
            case 1 -> addMenu();
            case 0 -> {
                // Returns false to end the run() loop.
                return false;
            }
            default -> {
            }
        }
        return true;
    }

    /**
     * Menu screen for viewing store components.
     */
    private void viewMenu(){
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
        switch (choice) {
            case 3 -> sortedFruit = this.store.fruitOptionsSortedByPrice();
            case 2 -> sortedFruit = this.store.fruitOptionsSortedByShelfLife();
            default -> {
            }
        }
        System.out.println("Printing sorted fruit options...");
        for (Fruit fruit : sortedFruit){
            System.out.println(fruit + "\n~");
        }
    }
    private void searchForFruit(){
        System.out.print("~Search for fruit~\nFruit species: (Ex: Apple)\n\ninput:");
        String species = collectString();
        System.out.print("Fruit cultivar: (Ex: Granny Smith)\n\ninput:");
        String cultivar = collectString();
        Fruit testFruit = new Fruit(species, cultivar, 0, 0.0);
        System.out.printf("Searching for %s %s...\n", cultivar, species);
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
        System.out.printf("""
                ~Oldest shipment~
                
                %s
                
                Discard shipment and it's contents?:
                [1] Yes
                [0] No
                
                input:""", shipment);
        int choice = collectInt(0,1);
        switch (choice){
            case 1:
                int removed = this.store.discardOldestShipment();
                System.out.printf("Discarded oldest shipment! Removed [%d] %s's.\n", removed, shipment.getFruit().getFruitTitle());
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
    private void addMenu(){
        System.out.print("""
                ~Add~
                Please select one of the following actions:
                [3] Add fruit option
                [2] Add shipment
                [1] Add purchase
                [0] Exit
                
                input:""");
        int choice = collectInt(0, 3);
        switch (choice){
            case 3:
                addFruitOption();
                break;
            case 2:
                addShipment();
                break;
            case 1:
                addPurchase();
                break;
            case 0:
                break;
            default:
                break;
        }
    }
    private Fruit findFruit() {
        while (true) {
            System.out.print("Fruit species (Ex: Apple):\n\ninput:");
            String species = collectString();
            System.out.print("Fruit cultivar (Ex: Granny Smith):\n\ninput:");
            String cultivar = collectString();
            System.out.printf("Searching for %s %s...\n", cultivar, species);
            Fruit fruit = this.store.findFruitOption(species, cultivar);

            if (fruit != null) {
                System.out.printf("""
                        Fruit found.
                        ~
                        %s
                        ~
                        Use fruit?
                        Please select one of the following actions:
                        [1] Yes
                        [0] No
                                        
                        input:""", fruit);
                int choice = collectInt(0, 1);
                switch (choice) {
                    case 1:
                        return fruit;
                    case 0:
                        break;
                    default:
                        break;
                }
            } else {
                System.out.print("""
                        ERROR: Fruit not found.
                        Try again?
                        Please select one of the following actions:
                        [1] Yes
                        [0] No
                                        
                        input:""");
                int choice = collectInt(0, 1);
                switch (choice) {
                    case 1:
                        break;
                    case 0:
                        return null;
                    default:
                        break;
                }
            }
        }
    }
    private void addFruitOption(){
        System.out.println("~Add fruit option~");
        System.out.print("Fruit species (Ex: Apple):\n\ninput:");
        String species = collectString();
        System.out.print("Fruit cultivar (Ex: Granny Smith):\n\ninput:");
        String cultivar = collectString();
        System.out.print("Fruit shelf life (in # days):\n\ninput:");
        int shelfLife = collectInt(1, Integer.MAX_VALUE);
        System.out.print("Fruit price per unit:\n\ninput:");
        double pricePerUnit = collectDouble(0, Double.MAX_VALUE);

        Fruit fruit = new Fruit(species, cultivar, shelfLife, pricePerUnit);
        System.out.printf("""
                New fruit created:
                ~
                %s
                ~
                Add to fruit options?
                Please select one of the following actions:
                [1] yes
                [0] no
                
                input:""", fruit);
        int choice = collectInt(0, 1);
        switch (choice){
            case 1:
                this.store.addFruitOption(fruit);
                System.out.println("Fruit added to fruit options!");
                break;
            case 0:
                break;
            default:
                break;
        }
    }

    private void addShipment(){
        Fruit fruit;
        int quantity;
        Date deliveryDate;
        System.out.println("~Add shipment~\nFirst, search for the fruit to be shipped.");
        fruit = findFruit();
        if (fruit != null){
            System.out.printf("Quantity of %s:\n\ninput:", fruit.getFruitTitle());
            quantity = collectInt(1, Integer.MAX_VALUE);
            System.out.print("Year of shipment:\n\ninput:");
            int year = collectInt(0, Integer.MAX_VALUE);
            System.out.print("Month of shipment (Ex: 1-January, 12-December):\n\ninput:");
            int month = collectInt(1, 12) - 1; //The Date object uses a 0-indexed month parameter.
            System.out.print("Day of shipment:\n\ninput:");
            int day = collectInt(1, 31);
            deliveryDate = new Date(year, month, day);

            Shipment shipment = new Shipment(this.store.getShipmentID(), fruit, quantity, deliveryDate);

            System.out.printf("""
                New shipment created:
                ~
                %s
                ~
                Add to shipments?
                Please select one of the following actions:
                [1] yes
                [0] no
                
                input:""", shipment);
            int choice = collectInt(0, 1);
            switch (choice){
                case 1:
                    this.store.addShipment(shipment);
                    System.out.println("Successfully added shipment!");
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        }
        //Else, does nothing. fruit == null means user did not want to keep searching for fruit.
    }

    private void addPurchase(){
        System.out.println("~Add purchase~\nFirst, search for the fruit to be purchased.");
        Fruit fruit = findFruit();

        if (fruit != null){
            System.out.printf("Quantity of %s:\n\ninput:", fruit.getFruitTitle());
            int quantity = collectInt(1, Integer.MAX_VALUE);
            System.out.print("Price of purchase:\n\ninput:");
            double price = collectDouble(0, Double.MAX_VALUE);

            Purchase purchase = new Purchase(this.store.getPurchaseID(), fruit, quantity, price);

            System.out.printf("""
                New purchase created:
                ~
                %s
                ~
                Add to purchases?
                Please select one of the following actions:
                [1] yes
                [0] no
                
                input:""",purchase);
            int choice = collectInt(0, 1);
            switch (choice){
                case 1:
                    if (this.store.addPurchase(purchase)){
                        System.out.println("Successfully added purchase!");
                    }
                    else{
                        System.out.println("ERROR: Insufficient number of fruits in inventory for this purchase, purchase not made.");
                    }
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        }
        // Else, does nothing. User did not find fruit.
    }
}
