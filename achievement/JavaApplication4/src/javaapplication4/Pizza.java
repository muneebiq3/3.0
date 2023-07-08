package javaapplication4;
public class Pizza 
{
    private String size;
    private int cheese_toppings;
    private int pepperoni_toppings;
    private int ham_toppings;
    public Pizza(String size, int cheese_toppings, int pepperoni_toppings, int ham_toppings)
    {
        this.size=size;
        this.cheese_toppings=cheese_toppings;
        this.pepperoni_toppings=pepperoni_toppings;
        this.ham_toppings=ham_toppings;
    }
    public void size_setter(String size)
    {
        this.size=size;
    }
    public String size_getter()
    {
        return size;
    }
    public void cheese_setter(int cheese)
    {
        this.cheese_toppings=cheese;
    }
    public int cheese_getter()
    {
        return cheese_toppings;
    }
    public void pepperoni_setter(int pepperoni)
    {
        this.pepperoni_toppings=pepperoni;
    }
    public int pepperoni_getter()
    {
        return pepperoni_toppings;
    }
    public void ham_setter(int ham)
    {
        this.ham_toppings=ham;
    }
    public int ham_getter()
    {
        return ham_toppings;
    }
    public double calcCost()
    {
        double cost = 0;
        int toppings;
        switch (size) 
        {
            case "small":
            case "Small":
            case "SMALL":
            {
                toppings=cheese_toppings+pepperoni_toppings+ham_toppings;
                toppings=2*toppings;
                cost+=10+toppings;
                break;
            }
            case "medium":
            case "Medium":
            case "MEDIUM":
            {
                toppings=cheese_toppings+pepperoni_toppings+ham_toppings;
                toppings=2*toppings;
                cost+=12+toppings;
                break;
            }
            case "large":
            case "Large":
            case "LARGE":
            {
                toppings=cheese_toppings+pepperoni_toppings+ham_toppings;
                toppings=2*toppings;
                cost+=14+toppings;
                break;
            }
        }
        return cost;
    }
    public String getDescription()
    {
        String description;
        description="Size: "+size+"\nQuantity: Cheese-"+cheese_toppings+" Pepperoni-"+pepperoni_toppings+" Ham-"+ham_toppings;
        return description;
    }
}