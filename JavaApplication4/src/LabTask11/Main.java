package LabTask11;
import java.util.*;
public class Main
{
    public static void main(String[] args) 
    {
       Scanner input=new Scanner(System.in);
       System.out.print("Enter the first number: ");
       double num1=input.nextDouble();
       System.out.print("Enter the second number: ");
       double num2=input.nextDouble();
       VerifiedSimple vs=new VerifiedSimple(num1, num2);
       vs.checkValues();
       vs.sub();
       vs.mul();
    }
}