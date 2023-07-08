package javaapplication4;
import java.util.*;
public class MainPizza 
{
    public static void main(String [] args)
    {
        Scanner input=new Scanner(System.in);
        String size = null,temp;
        int cheese_toppings=0, pepperoni_toppings=0, ham_toppings=0;
        System.out.print("Enter the number of pizzas you want: ");
        int number=input.nextInt();
        Pizza [] pizza;
        pizza=new Pizza[number];
        for (int i=0;i<pizza.length;i++)
        {
            System.out.print("\nPizza "+(i+1)+"\nSelect the Variation: ");
            temp=input.next();
            if("small".equals(temp)||"Small".equals(temp)||"SMALL".equals(temp)||"medium".equals(temp)||"Medium".equals(temp)||"MEDIUM".equals(temp)||"large".equals(temp)||"Large".equals(temp)||"LARGE".equals(temp))
            {
                size=temp;
            }
            else
            {
                System.out.println("Please Select from the given variations.");
            } 
            System.out.print("Enter the number of Cheese Toppings: ");
            cheese_toppings=input.nextInt();
            System.out.print("Enter the number of Pepperoni Toppings: ");
            pepperoni_toppings=input.nextInt();
            System.out.print("Enter the number of Ham Toppings: ");
            ham_toppings=input.nextInt();
            pizza[i]=new Pizza(size, cheese_toppings, pepperoni_toppings, ham_toppings);
            System.out.println("\nYour Order Details of Pizza "+(i+1)+" are:\n"+pizza[i].getDescription());
        }
        System.out.print("\nEnter the serial number of any two pizzas you want to order: ");
        int s1=input.nextInt();
        if(s1>pizza.length||s1<0)
        {
            System.out.print("Please select the right option.");
        }
        else
        {
            System.out.print("Enter the serial number of any two pizzas you want to order: ");
            int s2=input.nextInt();
            if(s2>pizza.length||s2<0||s2==s1)
            {
                System.out.print("Please select the right option.");
            }
            else
            {
                PizzaOrder order=new PizzaOrder(pizza[s1], pizza[s2]);
                System.out.println("\nThe total bill of your Order is: $"+order.calcTotal());
            }
        } 
    }
}