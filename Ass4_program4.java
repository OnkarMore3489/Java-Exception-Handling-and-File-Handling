/*
write a program to accept a string as command line argument and perform following operations:

1.check whether it is a file or directory.
2.If it is a directory,list the content of directory,count how many files the directory has
3.Delete all files in that directory having extention .txt.(Ask the user if the file have to deleted).
4.If it is file,display all information about the file(path,size,attribute).
 */
import java.io.*;
import java.util.*;
class Ass4_program4 
{
    public static void main(String args[])throws Exception
    {
        try
        {
         File file = new File(args[0]);

         if(file.isDirectory())
         {
            System.out.println("It is a Directory");
            File content[]=file.listFiles();
            int count=0;
            for(File name : content)
            {
              count++;
              System.out.println(name);
            }
            System.out.println("no of files in directory : "+count);
            
            Scanner sobj = new Scanner(System.in);
            System.out.println("Do u want to delete the files having extention .txt  1 for yes 0 for no: ");
            int c=sobj.nextInt();

            for(File name : content)
            {
                   String a=name.getName();
                   boolean bRet=a.contains(".txt");

                   if(bRet==true && c==1)
                   {
                     
                    if(name.delete())
                    {
                    System.out.println("Successfull");

                    }
                    else
                    {
                        System.out.println("Unable to delete file");
                    }
               }
            }
         }
         if(file.isFile())
         {
            System.out.println("It is a File");

            System.out.println("path is : "+file.getAbsolutePath());
            System.out.println("size of file is : "+file.length());
            
            if (file.canRead())
            System.out.println("Readable");
         else
            System.out.println("Not Readable");
         if (file.canWrite())
            System.out.println("Writable");
         else
            System.out.println("Not Writable");
         }
    }
    catch(Exception e){

    }
    }    
}
