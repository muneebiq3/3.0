package javaapplication4;
public class PizzaOrder
{
    private Pizza pizza1;
    private Pizza pizza2;
    private Pizza pizza3;
    public PizzaOrder(Pizza pizza1)
    {
        this.pizza1=pizza1;
    }
    public PizzaOrder(Pizza pizza1, Pizza pizza2)
    {
        this.pizza1=pizza1;
        this.pizza2=pizza2;
    }
    public PizzaOrder(Pizza pizza1, Pizza pizza2, Pizza pizza3)
    {
        this.pizza1=pizza1;
        this.pizza2=pizza2;
        this.pizza3=pizza3;
    }
    public double calcTotal()
    {
        double cost=0;
        if(pizza1!=null)
        {
            cost+=pizza1.calcCost();
        }
        if(pizza2!=null)
        {
            cost+=pizza2.calcCost();
        }
        if(pizza3!=null)
        {
            cost+=pizza3.calcCost();
        }
        return cost;
    }
}