public class Mushroom extends DecoratorTopping{
    BasePizza pizza;

    public Mushroom(BasePizza pizza){
        this.pizza = pizza;
    }
    @Override
    public int cost() {
        return this.pizza.cost() + 30;
    }
}
