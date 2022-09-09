/*
Define a class Number_Array.Accept numbers from user and store it in array.Find out
average.Show appropriate exception lke ArrayIndex related.
 */
import java.util.*;
class Ass_4program3
{
    public static void main(String args[])
    {
        Scanner sobj = new Scanner(System.in);
        System.out.println("How many Elements you want to enter : ");
        int iValue=sobj.nextInt();
        try
        {
         if(iValue <= 0)
         {
            throw new ArrayIndex("Number must be positive");
         }
         else
         {
            Number_Array nobj = new Number_Array(iValue);
            nobj.Accept();
            double fRet=nobj.Average();
    
            System.out.println("Average is : "+fRet);
         }
        }
        catch(Exception e)
        {
            System.out.println("Exception Occured : "+e);
        }
    }
}
class Number_Array
{
    public int Arr[];
    int size;

    public Number_Array(int size)
    {
        this.size=size;
        Arr=new int[size];
    }

    public void Accept()
    {
        Scanner sobj = new Scanner(System.in);
        System.out.println("Enter the Elements : ");
        for(int i=0;i<Arr.length;i++)
        {
            Arr[i]=sobj.nextInt();
        }
    }
    public double Average()
    {
        double average=0.0;
        int iSum=0;
        for(int i=0;i<Arr.length;i++)
        {
            iSum+=Arr[i];
        }
        average=(double)iSum/Arr.length;
        return average;
    }
}
class ArrayIndex extends Exception
{
    public ArrayIndex(String str)
    {
        super(str);
    }
}