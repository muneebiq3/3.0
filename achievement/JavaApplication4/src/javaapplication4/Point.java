package javaapplication4;
public class Point 
{
    private double x_cord;
    private double y_cord;
    public Point(double x, double y)
    {
        this.x_cord=x;
        this.y_cord=y;
    }
    public void setter_x(double x)
    {
        this.x_cord=x;
    }
    public double getter_x()
    {
        return x_cord;
    }
    public void setter_y(double y)
    {
        this.y_cord=y;
    }
    public double getter_y()
    {
        return y_cord;
    }
    public void display()
    {
        System.out.println("X-cordinate: "+getter_x());
        System.out.println("Y-cordinate: "+getter_y());
    }
}