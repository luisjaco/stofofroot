import java.util.Date;
import java.util.ArrayList;
public class Shipment {
    /*
    The Shipment class contains information for each shipment a store may make.
    The information for the Shipment class is as follows:
    Initialization parameters:
    - id->int: the id of the shipment.
    - deliveryDate->Date: the date the shipment was delivered.
    - fruit->Fruit: the Fruit class of the fruit involved in the shipment.
    - quantity->int: the quantity of fruit in the shipment.

    Variables:
    - shipmentInventory->ArrayList(<Fruit>): an ArrayList of Fruit with the corresponding shipment id.
    - totalPrice->double: total price of shipment; fruit.pricePerUnit * quantity.
     */
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
    private void createShipmentInventory(){
        //Populates shipmentInventory with fruits which have a corresponding id.
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
        //Returns true is this.totalPrice is greater than the parameter's totalPrice.
        return (this.totalPrice > shipment.totalPrice);
    }

    public boolean afterShipment(Shipment shipment){
        //Returns true if this.deliveryDate is after the parameters deliveryDate.
        return (this.deliveryDate.after(shipment.deliveryDate));
    }

    public boolean beforeShipment(Shipment shipment){
        //Returns true if this.deliveryDate is after the parameters deliveryDate.
        return (this.deliveryDate.before(shipment.deliveryDate));
    }

    public boolean isExpired(Date date){
        // Returns true if this.deliveryDate is equal to or after the date parameter.
        return (this.deliveryDate.equals(date)) || (this.deliveryDate.after(date));
    }
    public String shortString(){
        //A shorter String of the shipment
        return "%s: %s".formatted(this.fruit.getFruitTitle(), this.deliveryDate);
    }
    public String toString(){
        return "Shipment #%d\n%s [%d]: $%f\nDelivered on %s".formatted(this.id, this.fruit.getFruitTitle(), this.quantity, this.totalPrice, this.deliveryDate);
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

    public void setdeliveryDate(Date deliveryDate) {
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
