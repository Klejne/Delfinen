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
      catch (FileNotFoundException exception)
      {
         System.out.print(exception);
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
      catch (FileNotFoundException exception)
      {
         System.out.println(exception);
         return null;
      }

      return input;
   }
   
}