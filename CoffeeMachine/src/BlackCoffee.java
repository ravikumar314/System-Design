import java.util.Map;

public class BlackCoffee implements Beverage {
    String beverageName;
    Map<String, Integer> ingredientQuantity;

    public BlackCoffee(String beverageName, Map<String, Integer> ingredientQuantity){
        this.beverageName = beverageName;
        this.ingredientQuantity = ingredientQuantity;
    }

    @Override
    public String getBeverageName() {
        return beverageName;
    }

    @Override
    public Map<String, Integer> getIngredientQuantity() {
        return ingredientQuantity;
    }
}
