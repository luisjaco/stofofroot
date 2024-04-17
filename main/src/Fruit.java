public class Fruit {
    /*
    The Fruit class is a class which contains many different characteristics of fruit.
    These characteristics include:
    Initialization parameters:
    - id->int: (optional) id of the shipment fruit belongs to, if applicable.
    - species->String: species of fruit (apple, or banana).
    - cultivar->String: cultivated variety of fruit (Granny Smith (apple) or Lakatan (banana)).
    - shelfLife->int: shelf life of fruit in days.
    - pricePerUnit->double: price per unit of fruit.
     */
    private int shipmentID = -1;
    private String species;
    private String cultivar;
    private int shelfLife;
    private double pricePerUnit;
    public Fruit(String species, String cultivar, int shelfLife, double pricePerUnit){
        this.species = species;
        this.cultivar = cultivar;
        this.shelfLife = shelfLife;
        this.pricePerUnit = pricePerUnit;
    }
    public Fruit(String species, String cultivar, int shelfLife, double pricePerUnit, int shipmentID){
        this.species = species;
        this.cultivar = cultivar;
        this.shelfLife = shelfLife;
        this.pricePerUnit = pricePerUnit;
        this.shipmentID = shipmentID;
    }
    public boolean compareByPrice(Fruit fruit){
        // Returns true if this.pricePerUnit is greater than the parameters pricePerUnit.
        return (this.pricePerUnit > fruit.pricePerUnit);
    }
    public boolean compareByShelfLife(Fruit fruit){
        // Returns true if this.shelfLife is greater than the parameters shelfLife.
        return (this.shelfLife > fruit.shelfLife);
    }

    public String toString(){
        String str = "~%s %s~\nshelfLife: %d\npricePerUnit: %f".formatted(this.cultivar, this.species, this.shelfLife, this.pricePerUnit);
        if (this.shipmentID != -1){
            str += "\nshipmentID: %d".formatted(this.shipmentID);
        }
        return str;
    }

    public String getFruitTitle(){
        //Returns a string of both the cultivar and species.
        return this.cultivar + " " + this.species;
    }
    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getCultivar() {
        return cultivar;
    }

    public void setCultivar(String cultivar) {
        this.cultivar = cultivar;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(int shelfLife) {
        this.shelfLife = shelfLife;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public int getShipmentID() {
        return shipmentID;
    }

    public void setShipmentID(int shipmentID) {
        this.shipmentID = shipmentID;
    }
}
