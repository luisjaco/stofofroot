/**
 * <p>The Purchase class contains information about a purchase a customer has made.</p>
 * <p></p>
 * <p>Initialization parameters:</p>
 * <p>int id - the unique id of a purchase.</p>
 * <p>Fruit fruit - the type of fruit which was bought.</p>
 * <p>int quantity - the amount of fruit which were purchased.</p>
 * <p>double price - the amount the customer paid for the purchase.</p>
 */
public class Purchase {
    private int id;
    private Fruit fruit;
    private int quantity;
    private double price;
    public Purchase(int id, Fruit fruit, int quantity, double price){
        this.id = id;
        this.fruit = fruit;
        this.quantity = quantity;
        this.price = price;
    }
    public String toString(){
        return "%s [%d]; $%f".formatted(this.fruit.getFruitTitle(), this.quantity, this.price);
    }

    /**
     * Compares price.
     * @param purchase Purchase to be compared to.
     * @return true if this Purchase has a greater price variable than the parameter.
     */
    public boolean isPriceGreaterThan(Purchase purchase){
        return this.price > purchase.getPrice();
    }

    /**
     * Compares quantity.
     * @param purchase Purchase to be compared to.
     * @return true if this Purchase has a greater quantity variable than the parameter.
     */
    public boolean isQuantityGreaterThan(Purchase purchase){
        return this.quantity > purchase.getQuantity();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
