import java.util.Date;
import java.util.ArrayList;

/**
 * <p>The Shipment class contains information for each shipment a store may make.</p>
 * <p></p>
 * Initialization parameters:
 * <p>int id - the id of the shipment.</p>
 * <p>Date deliveryDate - the date the shipment was delivered.</p>
 * <p>Fruit fruit - the Fruit class of the fruit involved in the shipment.</p>
 * <p>int quantity - the quantity of fruit in the shipment.</p>
 * <p></p>
 * Variables:
 * <p>ArrayList(Fruit) shipmentInventory - an ArrayList of Fruit with the corresponding shipment id.</p>
 * <p>double totalPrice - total price of shipment; fruit.pricePerUnit * quantity.</p>
 */
public class Shipment {
    private int id;
    private Fruit fruit;
    private int quantity;
    private Date deliveryDate;
    private double totalPrice;
    private ArrayList<Fruit> shipmentInventory;
    public Shipment(int id, Fruit fruit, int quantity, Date deliveryDate){
        this.id = id;
        this.fruit = fruit;
        this.quantity = quantity;
        this.deliveryDate = deliveryDate;

        this.totalPrice = fruit.getPricePerUnit()*quantity;
        this.shipmentInventory = new ArrayList<>();
        createShipmentInventory();
    }

    /**
     * Populates shipmentInventory with fruits which have a corresponding id.
     */
    private void createShipmentInventory(){
        String species = this.fruit.getSpecies();
        String cultivar = this.fruit.getCultivar();
        int shelfLife = this.fruit.getShelfLife();
        double pricePerUnit = this.fruit.getPricePerUnit();
        for(int i=0; i < this.quantity; i++){
            Fruit item = new Fruit(species, cultivar, shelfLife, pricePerUnit, this.id);
            this.shipmentInventory.add(item);
        }
    }
    public boolean compareByTotalPrice(Shipment shipment){
        return (this.totalPrice > shipment.totalPrice);
    }

    public boolean afterShipment(Shipment shipment){
        return (this.deliveryDate.after(shipment.deliveryDate));
    }
    public boolean beforeShipment(Shipment shipment){
        return (this.deliveryDate.before(shipment.deliveryDate));
    }
    public boolean isExpired(Date date){
        return (this.deliveryDate.equals(date)) || (this.deliveryDate.after(date));
    }
    public String shortString(){
        //A shorter String of the shipment
        return "%s [%d]: %s".formatted(this.fruit.getFruitTitle(), this.quantity, this.deliveryDate);
    }
    public String toString(){
        return "Shipment #%d\n%s [%d]: $%f\nDelivered on %s\n[Shelf life: %d days]".formatted(this.id, this.fruit.getFruitTitle(), this.quantity, this.totalPrice, this.deliveryDate, this.fruit.getShelfLife());
    }
    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getdeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Fruit> getShipmentInventory() {
        return shipmentInventory;
    }

    public void setShipmentInventory(ArrayList<Fruit> shipmentInventory) {
        this.shipmentInventory = shipmentInventory;
    }
}
