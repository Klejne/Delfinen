import java.util.ArrayList;
import java.util.Calendar;

public class Member
{
   private int      id;
   private String   name;
   private Calendar birthday; // Vi kan bruge Calendar, da det er en superklasse af GregorianCalendar
   private int      paidYear;

   private ArrayList<Result> results = new ArrayList();
   
   
   public Member(int id, String name, Calendar birthday, int paidYear)  //constructor
   {
      this.id       = id;
      this.name     = name;
      this.birthday = birthday;
      this.paidYear = paidYear;
   }


   public int getId()
   {
      return id;
   }


   public String getName()
   {
      return name;
   }


   public void setName(String name)
   {
      this.name = name;
   }


   public Calendar getBirthday()
   {
      return birthday;
   }


   public int getPaidYear()
   {
      return paidYear;
   }


   public void setPaidYear(int paidYear)
   {
      this.paidYear = paidYear;
   }


   public ArrayList<Result> getResults()
   {
      return results;
   }

   
   /*
      Kaldes automatisk de steder hvor objektet konverteres til en streng, fx når det printes.
    */
   public String toString()
   {
      String string ;
      string = id + ",";
      string = string + name + ",";
      string = string + birthday.get(Calendar.DAY_OF_MONTH) + "/";
      string = string + (birthday.get(Calendar.MONTH) + 1) + "/";
      string = string + birthday.get(Calendar.YEAR) + ",";
      string = string + paidYear;

      // For hvert result af typen Result i ArrayListen results
      for (Result result : results)
      {
         string = string + "," + result; // Vi udnytter toString() i Result-klassen her
      }

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


   public String prettyPrint()
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
         if (result.getTime() < bestTime && result.getDiscipline().equals(discipline))
         {
            bestTime = result.getTime();
         }
      }
      
      return bestTime;
   }
}