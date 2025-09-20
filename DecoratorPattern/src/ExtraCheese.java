public class ExtraCheese extends DecoratorTopping{
    BasePizza pizza;

    public ExtraCheese(BasePizza pizza){
        this.pizza = pizza;
    }

    @Override
    public int cost() {
        return this.pizza.cost() + 20;
    }
}
