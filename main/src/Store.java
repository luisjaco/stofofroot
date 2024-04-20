import java.sql.SQLOutput;
import java.util.*;

/**
 *     <p>The Store class includes all information regarding a stores fruits options, shipments,
 *     purchases, and inventory.
 *     <p></p>
 *     Initialization parameters:
 *     <p>String name: name of store.</p>
 *     <p></p>
 *     <p>Variables:</p>
 *     <p>ArrayList(Fruit) fruitOptions - a list of all available fruit options offered at the store.</p>
 *     <p>FruitBT fruitTree - a list of all available fruit options offered at the store, in Binary Tree form</p>
 *     <p>LinkedList(Shipment) shipments - a list of all shipments made to date.</p>
 *     <p>Queue(Shipment) currentShipments - a queue of all shipments which are currently still in inventory.</p>
 *     <p>int shipmentID - current id which shipments will use.</p>
 *     <p>Stack(Purchase) purchaseStack - a stack of all purchases made.</p>
 *     <p>ArrayList(Purchase) purchaseHistory - a list of all purchases made to date.</p>
 *     <p>int purchaseID - current id which purchases will use.</p>
 *     <p>HashTable(Fruit,ArrayList(Fruit)) inventory - an inventory system keeping track of all current fruit, categorized by fruit type.</p>
 */
public class Store {
    private String name;
    private ArrayList<Fruit> fruitOptions;
    private FruitBT fruitTree;
    private LinkedList<Shipment> shipments;
    private Queue<Shipment> currentShipments;
    private int shipmentID;
    private Stack<Purchase> purchaseStack;
    private ArrayList<Purchase> purchaseHistory;
    private int purchaseID;
    private Hashtable<Fruit, ArrayList<Fruit>> inventory;

    /**
     * Creates a new Store with empty data structures.
     * @param name name of store.
     */
    public Store(String name){
        this.name = name;
        System.out.println("Welcome to " + name + "! :)");

        this.fruitOptions = new ArrayList<>();
        this.fruitTree = new FruitBT();
        this.shipments = new LinkedList<>();
        this.shipmentID = 0;
        this.currentShipments = new LinkedList<>();
        this.purchaseStack = new Stack<>();
        this.purchaseHistory = new ArrayList<>();
        this.purchaseID = 0;
        this.inventory = new Hashtable<>();
    }

    /**
     * Adds a Fruit to fruitOptions and fruitTree, and gives a new entry for inventory.
     * @param fruit Fruit to be added.
     */
    public void addFruitOption(Fruit fruit){
        this.fruitOptions.add(fruit);
        this.fruitTree.insert(fruit);
        this.inventory.put(fruit, new ArrayList<>());
    }

    /**
     * Adds a Shipment to shipments and currentShipments, populates inventory with the corresponding fruits, and increments shipmentID by 1.
     * @param shipment Shipment to be added.
     */
    public void addShipment(Shipment shipment){
        this.shipments.add(shipment);
        this.currentShipments.add(shipment);

        Fruit shipmentFruit = shipment.getFruit();
        ArrayList<Fruit> fruitInventory = this.inventory.get(shipmentFruit);
        ArrayList<Fruit> fruits = shipment.getShipmentInventory();
        fruitInventory.addAll(fruits);
        this.shipmentID++;
    }

    /**
     * Checks if there are enough fruit available in the inventory for a specified amount.
     * @param fruit Fruit to use for search.
     * @param quantity quantity to check.
     * @return true if there are the specified amount of fruit in inventory.
     */
    public boolean hasEnoughInventory(Fruit fruit, int quantity){
        if (this.inventory.containsKey(fruit)){
            return (this.inventory.get(fruit).size() >= quantity);
        }
        else{
            return false;
        }
    }

    /**
     * Adds a Purchase to purchases, and removes the specified amount of fruit from inventory.
     * Does nothing if there is not enough inventory.
     */
    public void addPurchase(Purchase purchase){
        Fruit fruit = purchase.getFruit();
        int quantity = purchase.getQuantity();
        if (hasEnoughInventory(fruit, quantity)){
            this.purchaseStack.add(purchase);
            this.purchaseHistory.add(purchase);
            discardFruit(fruit, quantity);
            this.purchaseID++;
        }
    }

    /**
     * Discards (removes) fruit based on quantity, will randomly remove fruit from specified inventory. Does nothing if quantity is not in inventory.
     * @param fruit Fruit to be discarded.
     * @param quantity quantity of fruit to be discarded.
     */
    public void discardFruit(Fruit fruit, int quantity){
        if (hasEnoughInventory(fruit, quantity)){
            ArrayList<Fruit> fruits = this.inventory.get(fruit);
            for (int i=0; i<quantity; i++){
                int index = (int) (Math.random() * fruits.size());
                fruits.remove(index);
            }
        }
    }

    /**
     * Creates a sorted ArrayList of Fruit's based on fruitOptions, sorted by price increasingly.
     * @return sorted ArrayList of Fruit's, in increasing order.
     */
    public ArrayList<Fruit> fruitOptionsSortedByPrice(){
        return sortByPrice(this.fruitOptions);
    }

    private ArrayList<Fruit> sortByPrice(ArrayList<Fruit> fruits){
        //Edge case.
        if (fruits.size() <= 1){
            return fruits;
        }
        ArrayList<Fruit> sorted = new ArrayList<>();

        //Array splicing.
        int middle = (int) (fruits.size() / 2);
        ArrayList<Fruit> left = new ArrayList<>(fruits.subList(0, middle));
        ArrayList<Fruit> right = new ArrayList<>(fruits.subList(middle, fruits.size()));

        // Recursive call.
        left = sortByPrice(left);
        right = sortByPrice(right);

        //Initial merge
        int i = 0;
        int j = 0;
        while ( (i < left.size()) && (j < right.size())){
            Fruit leftFruit = left.get(i);
            Fruit rightFruit = right.get(j);
            if (leftFruit.hasGreaterPrice(rightFruit)) {
                sorted.add(rightFruit);
                j++;
            }
            else{
                sorted.add(leftFruit);
                i++;
            }
        }

        //Cleanup merges
        while (i < left.size()) {
            sorted.add(left.get(i));
            i++;
        }
        while (j < right.size()){
            sorted.add(right.get(j));
            j++;
        }

        return sorted;
    }

    /**
     * Creates a sorted ArrayList of Fruit's based on fruitOptions, sorted by shelfLife increasingly.
     * @return sorted ArrayList of Fruit's, in increasing order.
     */
    public ArrayList<Fruit> fruitOptionsSortedByShelfLife(){
        return sortByShelfLife(this.fruitOptions);
    }

    private ArrayList<Fruit> sortByShelfLife(ArrayList<Fruit> fruits){
        //Edge case.
        if (fruits.size() <= 1){
            return fruits;
        }
        ArrayList<Fruit> sorted = new ArrayList<>();

        //Array splicing.
        int middle = (int) (fruits.size() / 2);
        ArrayList<Fruit> left = new ArrayList<>(fruits.subList(0, middle));
        ArrayList<Fruit> right = new ArrayList<>(fruits.subList(middle, fruits.size()));

        // Recursive call.
        left = sortByShelfLife(left);
        right = sortByShelfLife(right);

        //Initial merge
        int i = 0;
        int j = 0;
        while ( (i < left.size()) && (j < right.size())){
            Fruit leftFruit = left.get(i);
            Fruit rightFruit = right.get(j);
            if (leftFruit.hasGreaterShelfLife(rightFruit)) {
                sorted.add(rightFruit);
                j++;
            }
            else{
                sorted.add(leftFruit);
                i++;
            }
        }

        //Cleanup merges
        while (i < left.size()) {
            sorted.add(left.get(i));
            i++;
        }
        while (j < right.size()){
            sorted.add(right.get(j));
            j++;
        }

        return sorted;
    }

    /**
     * Searches if a given fruit is available within the store.
     * @param fruit fruit to be searched.
     * @return true if fruit is in fruitTree.
     */
    public boolean containsFruitOption(Fruit fruit){
        return this.fruitTree.search(fruit);
    }
    public Shipment peekOldestShipment(){
        return this.currentShipments.peek();
    }

    /**
     * Handles discarding the oldest shipment, and removes corresponding fruit from the inventory.
     * @return number of fruit from corresponding shipment that were removed from the inventory.
     */
    public int discardOldestShipment(){
        Shipment shipment = this.currentShipments.poll();
        int removed = 0;
        if (shipment != null) {
            Fruit fruit = shipment.getFruit();
            int shipmentID = shipment.getId();
            ArrayList<Fruit> fruits = this.inventory.get(fruit);
            int index = 0;
            while (index < fruits.size()){
                Fruit f = fruits.get(index);
                if (f.getShipmentID() == shipmentID){
                    fruits.remove(f);
                    removed++;
                }
                else {
                    index++;
                }
            }
        }
        return removed;
    }

    public Purchase peekMostRecentPurchase(){
        return this.purchaseStack.peek();
    }

    /**
     * Displays the current fruit options.
     */
    public void displayFruitOptions(){
        System.out.println("~~~~" + name + "'s current fruit options~~~~");
        for (Fruit fruit : this.fruitOptions){
            System.out.println(fruit + "\n~");
        }
    }

    /**
     * Displays all current fruit with their available quantities.
     */
    public void displayInventory(){
        System.out.println("~~~~ Current inventory of " + name +"~~~~");
        for( Fruit key: this.inventory.keySet()){
            String fruitTitle = key.getFruitTitle();
            int size = this.inventory.get(key).size();
            System.out.println("%s: [%d]".formatted(fruitTitle, size));
        }
    }
    /**
     * Displays all previous shipments.
     */
    public void displayShipmentHistory(){
        System.out.println("~~~~ Shipment history for " + name +"~~~~");
        for (Shipment shipment : this.shipments){
            System.out.println(shipment.shortString() + "\n~");
        }
    }

    /**
     * Displays all purchases.
     */
    public void displayPurchases(){
        System.out.println("~~~~" + name + "'s purchase history~~~~");
        for (Purchase purchase: this.purchaseHistory){
            System.out.println(purchase + "\n~");
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Fruit> getFruitOptions() {
        return fruitOptions;
    }

    public LinkedList<Shipment> getShipments() {
        return shipments;
    }

    public Queue<Shipment> getCurrentShipments() {
        return currentShipments;
    }

    public Hashtable<Fruit, ArrayList<Fruit>> getInventory() {
        return inventory;
    }

    public void setFruitOptions(ArrayList<Fruit> fruitOptions) {
        this.fruitOptions = fruitOptions;
    }

    public void setShipments(LinkedList<Shipment> shipments) {
        this.shipments = shipments;
    }

    public void setCurrentShipments(Queue<Shipment> currentShipments) {
        this.currentShipments = currentShipments;
    }

    public void setInventory(Hashtable<Fruit, ArrayList<Fruit>> inventory) {
        this.inventory = inventory;
    }

    public int getShipmentID() {
        return shipmentID;
    }

    public void setShipmentID(int shipmentID) {
        this.shipmentID = shipmentID;
    }

    public FruitBT getFruitTree() {
        return fruitTree;
    }

    public void setFruitTree(FruitBT fruitTree) {
        this.fruitTree = fruitTree;
    }

    public int getPurchaseID() {
        return purchaseID;
    }

    public void setPurchaseID(int purchaseID) {
        this.purchaseID = purchaseID;
    }
}

