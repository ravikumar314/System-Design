import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {


        // add ingredeint at start
        Ingredient water = new Ingredient("water", 100);
        Ingredient milk = new Ingredient("milk", 100);
        Ingredient coffee = new Ingredient("coffee", 100);
        Ingredient sugar = new Ingredient("sugar", 100);

        // prepare the list of ingredient
        List<Ingredient> ingredientList = Arrays.asList(water, milk, coffee, sugar);

        // beverage 1
        Map<String, Integer> black = new HashMap<>();
        black.put("milk", 0);
        black.put("water", 20);
        black.put("coffee", 10);
        Beverage blackCoffee = new BlackCoffee("blackCoffee", black);

        // beverage 2
        Map<String, Integer> cold = new HashMap<>();
        cold.put("milk", 10);
        cold.put("water", 10);
        cold.put("coffee", 30);
        Beverage coldCoffee = new ColdCoffe("coldCoffee", cold);

        // prepare the list of beverage
        List<Beverage> beverageList = Arrays.asList(blackCoffee, coldCoffee);

        // initialize the coffee machine with these ingredient

        CoffeeMachine Machine = new CoffeeMachine(2,  beverageList, ingredientList);

        Machine.serveBeverage(blackCoffee); // serve black coffe
        Machine.refillIngredient("water", 100);

    }
}