/*
Define a class MyDate(day,month,year) with methods to accept and display a MyDate object.
Accept date as dd,mm,yy. Throw user define exception "InvalidDateException" if the date is 
invalid check for leap year also.
 */
import java.util.*;

class Ass4_program1 
{
    public static void main(String args[])
    {
        Mydate mobj=new Mydate();
        mobj.Accept();
        mobj.Display();
        mobj.Leap();
    }    
}
class Mydate
{
    public int Day;
    public int Month;
    public int Year;

    public void Accept()
    {
        Scanner sobj=new Scanner(System.in);
        System.out.println("Enter the Date : ");
        String str=sobj.nextLine();

        String Arr[]=str.split(" ");

        this.Day=Integer.parseInt(Arr[0]);
        this.Month=Integer.parseInt(Arr[1]);
        this.Year=Integer.parseInt(Arr[2]);

        try
        {
         if(Month>12 || Day>31 || Month==2 && Day>29 && (Year%4==0) || Month==2 && Day>28 && (Year%4!=0))
         {
             throw new InvalidDate("InvalidDateException");
         }
        }
        catch(Exception e)
        {
            System.out.println("Exception Occured : "+e);
        }
    }

    public void Display()
    {
        System.out.print("Date is : "+this.Day+" "+this.Month+" "+this.Year+" ");
        System.out.println();
    }

    public void Leap()
    {
        if(Year%4==0)
        {
            System.out.println("Leap Year");
        }
        else
        {
            System.out.println("Not Leap Year");
        }
    }
}
class InvalidDate extends Exception
{
    public InvalidDate(String str)
    {
        super(str);
    }
}