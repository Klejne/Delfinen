import java.io.PrintStream;
import java.io.File;
import java.io.FileNotFoundException;

public class FileManager
{
   public static void write(String filename, String text)
   {
      PrintStream output;
      
      try
      {
         output = new PrintStream(new File(filename));
      }
      
      catch(FileNotFoundException ex)
      {
         System.out.print(ex);
         return;  
      }
      
      output.print(text);
   }
}