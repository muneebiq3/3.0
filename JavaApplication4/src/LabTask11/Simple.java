package LabTask11;
public abstract class Simple 
{
    protected double num1;
    protected double num2;
    Simple(){}
    Simple(double num1, double num2)
    {
        this.num1=num1;
        this.num2=num2;
    }
    public abstract void add();
    public void sub()
    {
        double num3=num1-num2;
        System.out.println(num1+" - "+num2+" = "+num3);
    }
    public void mul()
    {
        double num3=num1*num2;
        System.out.println(num1+" * "+num2+" = "+num3);
    }
    public abstract void div();
}