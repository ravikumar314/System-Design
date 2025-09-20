public class Ingredient {
    String Name;
    int Quantity;

    public Ingredient(String name, int quantity){
        this.Name = name;
        this.Quantity = quantity;
    }

    public String getName() {
        return Name;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}
