public class Purchase {
    /*The Purchase class contains information about a purchase a customer has made. The class contains the following information:
    Initialization parameters:
    - id->int: the unique id of a purchase.
    - fruit->Fruit: the type of fruit which was bought.
    - quantity->int: the amount of fruit which were purchased.
    - price->double: the amount the customer paid for the purchase.
     */
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
