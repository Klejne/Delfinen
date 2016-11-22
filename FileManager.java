import java.io.PrintStream;
import java.io.File;
import java.io.FileNotFoundException;

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
}