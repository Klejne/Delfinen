import java.util.ArrayList;
import java.util.Scanner;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class Member
{
   public int id;
   public String name;
   public GregorianCalendar birthday;
   public int paidYear;
   public ArrayList<Result> results = new ArrayList();
   
   
   public Member(int id, String name, GregorianCalendar birthday, int paidYear)  //constructor
   {
      this.id = id;
      this.name = name;
      this.birthday = birthday;
      this.paidYear = paidYear;
   }
   
   
   public String toString()   //kaldes automatisk de steder hvor objektet konverteres til en streng
   {
      String string;
      string = String.format("%-4d %-15s %02d/%02d/%d %d",
         id,
         name,
         birthday.get(Calendar.DAY_OF_MONTH),
         birthday.get(Calendar.MONTH)+1,
         birthday.get(Calendar.YEAR),
         paidYear
      );
      
      return string;
   }
   
   
   public int bestTime(String discipline)
   {
      int bestTime;
      
      bestTime = Integer.MAX_VALUE;
      
      for (Result result : results)
      {
         if (result.time < bestTime)
         {
            bestTime = result.time;
         }
      }
      
      return bestTime;
      
   }
   
   
}