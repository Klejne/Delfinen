import java.util.ArrayList;
import java.util.Calendar;

public class Member
{
   public int      id;
   public String   name;
   public Calendar birthday; // Vi kan bruge Calendar, da det er en superklasse af GregorianCalendar
   public int      paidYear;
   public ArrayList<Result> results = new ArrayList();
   
   
   public Member(int id, String name, Calendar birthday, int paidYear)  //constructor
   {
      this.id       = id;
      this.name     = name;
      this.birthday = birthday;
      this.paidYear = paidYear;
   }
   
   /*
      Kaldes automatisk de steder hvor objektet konverteres til en streng, fx når det printes.
    */
   public String toString()
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

      // For hvert `result` af typen `Result` i `ArrayList`en `results`
      for (Result result : results)
      {
         // Dette resultat tæller kun, hvis det er bedre end det hidtil bedste
         // OG (&&) er i den rigtige disciplin.
         if (result.time < bestTime && result.discipline.equals(discipline))
         {
            bestTime = result.time;
         }
      }
      
      return bestTime;
   }
}