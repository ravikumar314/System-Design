import java.util.List;
import java.util.Map;

public class CoffeeMachine {
    int numOutlet;
    List<Beverage> beverageList;
    List<Ingredient> ingredientList;

    public CoffeeMachine(int numOutlet, List<Beverage> beverageList, List<Ingredient> ingredientList){
        this.beverageList = beverageList;
        this.numOutlet = numOutlet;
        this.ingredientList = ingredientList;
    }

    public void serveBeverage(Beverage beverage){

        for(Map.Entry<String, Integer> entry : beverage.getIngredientQuantity().entrySet()){
            String ingredientName = entry.getKey();
            int requiredQuantity = entry.getValue();

            Ingredient ingredient = findIngredient(ingredientName);

            if(ingredient != null && ingredient.Quantity >= requiredQuantity){
                ingredient.setQuantity(ingredient.getQuantity() - requiredQuantity);
            }
            else{
                System.out.println("Insufficient " + ingredientName + "for " + beverage.getBeverageName() );
                return ;
            }
        }

        System.out.println(beverage.getBeverageName() + " served");
    }

    public void refillIngredient(String ingredientName, int quantity){
        Ingredient ingredient = findIngredient(ingredientName);

        if(ingredient == null){
            System.out.println("Ingredient" + ingredientName + " not found");
        }
        else{
            ingredient.setQuantity(ingredient.getQuantity() + quantity);
            System.out.println("Ingredient " + ingredientName + "refilled to " + ingredient.getQuantity());
        }
    }

    public Ingredient findIngredient(String ingredientName){

        for(Ingredient ingredient : ingredientList){
            if(ingredient.getName().equals(ingredientName))
                  return ingredient;
        }
        return null;
    }

    public void trackIngredient(){
        for(Ingredient ingredient : ingredientList){
            if(ingredient.getQuantity() < 11)
               System.out.println(ingredient.getName() + " is running low");
        }
    }

}
