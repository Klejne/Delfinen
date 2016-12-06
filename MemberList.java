import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintStream;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class MemberList
{
   public static ArrayList<Member> all = new ArrayList();


   public static void addMember(int id, String name, Calendar birthday, int paidYear)
   {
      Member member;
      member = new Member(id, name, birthday, paidYear);

      MemberList.all.add(member);
   }


   public static void readFromFile()
   {
      Scanner input;
      Member member;

      input = FileManager.read("members.csv");
      
      
      /*
         useDelimiter splitter p� de/t tegn (her: komma) der st�r i anf�rselstegn.
         System.lineSeparator l�ser selv om det er \n, \r eller \n\r
      */
      input.useDelimiter(",|" + System.lineSeparator());

      while (input.hasNext())
      {
         String line;
         Scanner inputLine;

         // Vi l�ser alt input som string, s� at kunne splitte p� komma.
         String id;
         String name;
         String birthday;
         String birthYear;
         String birthMonth;
         String paidYear;

         int resultID;
         int resultBirthday;
         int resultBirthMonth;
         int resultBirthYear;
         int resultPaidYear;

         Calendar birthDate;

         // Opret en ny Scanner, der kun scanner den linje vi kigger p�.
         // P� den m�de kan vi se, n�r vi er n�et enden af linjen (s� er der ikke flere Results)
         line = input.nextLine();
         inputLine = new Scanner(line);

         // Split p� komma og linjeseparatoren (linjeskift, etc.)
         inputLine.useDelimiter(",|" + System.lineSeparator());

         // Indl�s alle felter for dette medlem.
         id         = inputLine.next();
         name       = inputLine.next();
         birthYear  = inputLine.next();
         birthMonth = inputLine.next();
         birthday   = inputLine.next();
         paidYear   = inputLine.next();

         // Konvert�r alle Strings der skal v�re ints til int
         resultID         = Integer.parseInt(id);
         resultBirthday   = Integer.parseInt(birthday);
         resultBirthMonth = Integer.parseInt(birthMonth)-1; // GregorianCalendar tror Januar er m�ned 0.
         resultBirthYear  = Integer.parseInt(birthYear);
         resultPaidYear   = Integer.parseInt(paidYear);

         birthDate = new GregorianCalendar(resultBirthYear, resultBirthMonth, resultBirthday);

         member = new Member(resultID, name, birthDate, resultPaidYear);

         // S� l�nge der er mere tilbage i linjen, l�ser vi et resultat mere ind.
         while (inputLine.hasNext())
         {
            int resultTime;
            String discipline;
            String time;
            Result result;

            discipline = inputLine.next();
            discipline = discipline.toUpperCase();

            time = inputLine.next();
            resultTime = Integer.parseInt(time);

            result = new Result(discipline, resultTime);

            member.results.add(result);

            // Vi tilf�jer kun den disciplin vi lige har l�st, hvis den ikke findes i listen allerede.
            if (Result.disciplines.contains(discipline) == false)
            {
               Result.disciplines.add(discipline);
            }
         }

         MemberList.all.add(member);
      }
   }


   public static Member find(int memberID)
   {
      // For hvert `member` af typen `Member` i `ArrayList`en `MemberList.all`
      for (Member member : MemberList.all)
      {
         if (memberID == member.id)
         {
            return member;
         }
      }

      return null;
   }


   public static void writeToFile()
   {
      PrintStream output;
      output = FileManager.write("members.csv");

      // For hvert `member` af typen `Member` i `ArrayList`en `MemberList.all`
      for (Member member : MemberList.all)
      {
         output.printf("%d,%s,%d,%d,%d,%d",
            member.id,
            member.name,
            member.birthday.get(Calendar.YEAR),
            member.birthday.get(Calendar.MONTH)+1,
            member.birthday.get(Calendar.DAY_OF_MONTH),
            member.paidYear

         );

         // For hvert `result` af typen `Result` i `ArrayList`en `member.results`
         for (Result result : member.results)
         {
            output.printf(",%s,%d", result.discipline, result.time);
         }

         output.println();
      }
   }


   public static ArrayList<Member> debtors()
   {
      ArrayList<Member> debtors;
      debtors = new ArrayList();

      // For hvert `member` af typen `Member` i `ArrayList`en `MemberList.all`
      for (Member member : MemberList.all)
      {
         if (member.paidYear < Calendar.getInstance().get(Calendar.YEAR))
         {
            debtors.add(member);
         }
      }

      return debtors;
   }
}