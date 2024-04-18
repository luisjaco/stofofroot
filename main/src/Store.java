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
 *     <p>Stack(Purchase) purchase - a stack of all purchases made.</p>
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
    private Stack<Purchase> purchases;
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
        this.purchases = new Stack<>();
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
            this.purchases.add(purchase);
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
     * Discards (removes) fruit based on shipment, will remove all fruits with a corresponding shipmentID.
     * @param shipment shipment of fruit to discard.
     */
    public void discardFruit(Shipment shipment){
        Fruit fruit = shipment.getFruit();
        int shipmentID = shipment.getId();
        ArrayList<Fruit> fruits = this.inventory.get(fruit);
        for (Fruit f: fruits){
            if (f.getShipmentID() == shipmentID){
                fruits.remove(f);
            }
        }
    }

    /**
     * Sorts a list by price (increasing) using a MergeSort.
     * @param fruits A list of fruits to be sorted.
     * @return A sorted list of fruitOptions, in increasing order.
     */
    static public Fruit[] sortedByPrice(Fruit[] fruits){
        if (fruits.length <= 1){
            return fruits;
        }

        Fruit[] sorted = new Fruit[fruits.length];

        int middle = (int) (fruits.length / 2);
        Fruit[] left = Arrays.copyOfRange(fruits, 0, middle);
        Fruit[] right = Arrays.copyOfRange(fruits, middle, fruits.length);

        left = sortedByPrice(left);
        right = sortedByPrice(right);

        int i = 0;
        int j = 0;
        int index = 0;

        //Initial merge
        while ( (i < left.length) && (j < right.length)){
            Fruit leftFruit = left[i];
            Fruit rightFruit = right[j];
            if (leftFruit.hasGreaterPrice(rightFruit)) {
                sorted[index] = rightFruit;
                index++;
                j++;
            }
            else{
                sorted[index] = leftFruit;
                index++;
                i++;
            }
        }

        //Cleanup merges
        while (i < left.length){
            sorted[index] = left[i];
            index++;
            i++;
        }
        while (j < right.length){
            sorted[index] = right[i];
            index++;
            j++;
        }

        return sorted;
    }

    /**
     * Sorts a list by shelf life (decreasing) using a MergeSort.
     * @param fruits A list of fruits to be sorted.
     * @return A sorted list of fruitOptions, in decreasing order.
     */
    static public Fruit[] sortedByShelfLife(Fruit[] fruits) {
        if (fruits.length <= 1) {
            return fruits;
        }

        Fruit[] sorted = new Fruit[fruits.length];

        int middle = (int) (fruits.length / 2);
        Fruit[] left = Arrays.copyOfRange(fruits, 0, middle);
        Fruit[] right = Arrays.copyOfRange(fruits, middle, fruits.length);

        left = sortedByShelfLife(left);
        right = sortedByShelfLife(right);

        int i = 0;
        int j = 0;
        int index = 0;

        //Initial merge
        while ((i < left.length) && (j < right.length)) {
            Fruit leftFruit = left[i];
            Fruit rightFruit = right[j];
            if (leftFruit.hasGreaterShelfLife(rightFruit)) {
                sorted[index] = leftFruit;
                index++;
                i++;
            } else {
                sorted[index] = rightFruit;
                index++;
                j++;
            }
        }

        //Cleanup merges
        while (i < left.length){
            sorted[index] = left[i];
            index++;
            i++;
        }
        while (j < right.length){
            sorted[index] = right[i];
            index++;
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
    public Shipment pollOldestShipment(){
        return this.currentShipments.poll();
    }
    public Purchase peekMostRecentPurchase(){
        return this.purchases.peek();
    }

    /**
     * Displays the current fruit options.
     */
    public void displayFruitOptions(){
        System.out.println("~~~~" + name + "'s current fruit options~~~~");
        for (Fruit fruit : this.fruitOptions){
            System.out.print(fruit + "\n~");
        }
    }

    /**
     * Displays the current fruit options based on a specific species.
     */
    public void displayFruitOptions(String species){
        System.out.println("~~~~" + name + "'s current " + species + " options~~~~");
        for (Fruit fruit : this.fruitOptions){
            if (fruit.getSpecies().equals(species)){
                System.out.print(fruit + "\n~");
            }
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

    public Stack<Purchase> getPurchases() {
        return purchases;
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

    public void setPurchases(Stack<Purchase> purchases) {
        this.purchases = purchases;
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

