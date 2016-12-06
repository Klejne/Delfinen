import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class FileManager
{
   /* Peter, Emma */
   public static PrintStream write(String filename)
   {
      File file;
      file = new File(filename);

      try
      {
         return new PrintStream(file);
      }
      catch (FileNotFoundException exception)
      {
         System.out.print(exception);
         return null;
      }
   }


   /* Peter, Emma */
   public static Scanner read(String filename)
   {
      File file;
      file = new File(filename);

      try
      {
         return new Scanner(file);
      }
      catch (FileNotFoundException exception)
      {
         System.out.println(exception);
         return null;
      }
   }
}