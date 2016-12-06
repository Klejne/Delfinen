import java.util.ArrayList;

public class Result
{
   private String discipline;
   private int time;

   private static ArrayList<String> disciplines = new ArrayList();


   public Result(String discipline, int time)  //constructor
   {
      this.discipline = discipline;
      this.time = time;
   }


   public String getDiscipline()
   {
      return discipline;
   }


   public int getTime()
   {
      return time;
   }


   public static ArrayList<String> getDisciplines()
   {
      return disciplines;
   }


   public String toString()
   {
      String string;
      string = discipline + ":";
      string = string + time;
      return string;
   }


   public boolean equals(Object other)
   {
      if (this == other)
      {
         return true;
      }
      else
      {
         return false;
      }
   }
}