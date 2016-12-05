import java.util.ArrayList;

public class Result
{
   public String discipline;
   public int time; 
   public static ArrayList<String> disciplines = new ArrayList();  
   
   public Result(String discipline, int time)  //constructor
   {
      this.discipline = discipline;
      this.time = time;
   }

}