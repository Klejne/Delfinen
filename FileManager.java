import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class FileManager
{
   public static PrintStream write(String filename)
   {
      PrintStream output;
      
      try
      {
         output = new PrintStream(new File(filename));
      }
      catch(FileNotFoundException ex)
      {
         System.out.print(ex);
         return null;  
      }
      
      return output;
   }
   
   public static Scanner read(String filename)
   {
   
      File file = new File(filename);
      
      Scanner input;
      
      try
      {
         input = new Scanner(file);
      }
      catch (FileNotFoundException ex)
      {
         System.out.println(ex);
         return null;
      }
      return input;
   }
   
}