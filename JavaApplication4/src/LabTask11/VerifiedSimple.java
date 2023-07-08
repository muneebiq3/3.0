package LabTask11;
public class VerifiedSimple extends Simple
{
    public VerifiedSimple(){}
    public VerifiedSimple(double num1, double num2) 
    {
        super(num1, num2);
    }
    public void add()
    {
        double num3=num1+num2;
        System.out.println(num1+" + "+num2+" = "+num3);
    }
    public void div()
    {
        if(num2!=0)
        {
            double num3=num1/num2;
            System.out.println(num1+" / "+num2+" = "+num3);
        }
        else
        {
            System.out.println("ERROR!");
        }
    }
    public void checkValues()
    {
        if(num1>0 && num2>0)
        {
            add();
            div();
        }
        else
        {
            System.out.println("ERROR!");
        }
    }
}