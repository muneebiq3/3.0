package javaapplication4;
public class Line 
{
    private Point startPoint;
    private Point endPoint;
    public Line(Point p, Point e)
    {
        this.startPoint=p;
        this.endPoint=e;
    }
    public double length()
    {
        double length;
        length=Math.sqrt(Math.pow(endPoint.getter_x()-startPoint.getter_x(), 2))+Math.pow(endPoint.getter_y()-startPoint.getter_y(),2);
        return length;
    }
}