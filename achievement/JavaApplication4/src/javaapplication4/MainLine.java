package javaapplication4;
import java.util.*;
public class MainLine 
{
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        System.out.println("Line 1:");
        System.out.print("Enter the x-cordinate for starting Point: ");
        double line1_x1=input.nextDouble();
        System.out.print("Enter the y-cordinate for starting Point: ");
        double line1_y1=input.nextDouble();
        Point line1_startingPoint=new Point(line1_x1,line1_y1);
        System.out.print("\nEnter the x-cordinate for ending Point: ");
        double line1_x2=input.nextDouble();
        System.out.print("Enter the y-cordinate for ending Point: ");
        double line1_y2=input.nextDouble();
        Point line1_endingPoint=new Point(line1_x2,line1_y2);
        Line l1=new Line(line1_startingPoint,line1_endingPoint);
        System.out.println("\nThe length of the first line is: "+l1.length());
        System.out.println("\nLine 2:");
        System.out.print("Enter the x-cordinate for starting Point: ");
        double line2_x1=input.nextDouble();
        System.out.print("Enter the y-cordinate for starting Point: ");
        double line2_y1=input.nextDouble();
        Point line2_startingPoint=new Point(line2_x1,line2_y1);
        System.out.print("\nEnter the x-cordinate for ending Point: ");
        double line2_x2=input.nextDouble();
        System.out.print("Enter the y-cordinate for ending Point: ");
        double line2_y2=input.nextDouble();
        Point line2_endingPoint=new Point(line2_x2,line2_y2);
        Line l2=new Line(line2_startingPoint,line2_endingPoint);
        System.out.println("\nThe length of the second line is: "+l2.length());
    }
}