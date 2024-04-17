import java.sql.SQLOutput;
import java.util.*;
public class Store {
    /*
    The Store class includes all information regarding a stores fruits options, shipments,
    purchases, and inventory. The Store class includes the following data:
    Initialization parameters:
    name->String: name of store.

    Variables:
    fruitOptions->ArrayList(<Fruit>): a list of all available fruit options offered at the store.
    shipments->LinkedList(<Shipment>): a list of all shipments made to date.
    currentShipments->Queue(<Shipment>): a queue of all shipments which are currently still in inventory.
    purchases->Stack(<Purchase>): a stack of all purchases made.
    inventory->HashTable(<Fruit>,<ArrayList(<Fruit>)): an inventory system keeping track of all current fruit, categorized by fruit type.
     */
    private String name;
    private ArrayList<Fruit> fruitOptions;
    private LinkedList<Shipment> shipments;
    private Queue<Shipment> currentShipments;
    private Stack<Purchase> purchases;
    private Hashtable<Fruit, ArrayList<Fruit>> inventory;
    public Store(String name){
        this.name = name;
        System.out.println("Welcome to " + name + "! :)");

        this.fruitOptions = new ArrayList<>();
        this.shipments = new LinkedList<>();
        this.currentShipments = new LinkedList<>();
        this.purchases = new Stack<>();
        this.inventory = new Hashtable<>();
    }

    public void addFruitOption(Fruit fruit){
        //Adds a Fruit to fruitOptions, and gives a new entry for inventory.
        this.fruitOptions.add(fruit);
        this.inventory.put(fruit, new ArrayList<>());
    }

    public void addShipment(Shipment shipment){
        //Adds a Shipment to shipments and currentShipments, and populates the inventory with the corresponding fruits.
        this.shipments.add(shipment);
        this.currentShipments.add(shipment);

        Fruit shipmentFruit = shipment.getFruit();
        ArrayList<Fruit> fruitInventory = this.inventory.get(shipmentFruit);
        ArrayList<Fruit> fruits = shipment.getShipmentInventory();
        fruitInventory.addAll(fruits);
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
}

