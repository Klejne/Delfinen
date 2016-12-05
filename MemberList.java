import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintStream;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class MemberList
{
   public static ArrayList<Member> all = new ArrayList();


   public static void addMember(int id, String name, GregorianCalendar birthday, int paidYear)
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
         useDelimiter splitter på de/t tegn (her: komma) der står i anførselstegn.
         System.lineSeparator læser selv om det er \n, \r eller \n\r
      */
      input.useDelimiter(",|" + System.lineSeparator());

      while (input.hasNext())
      {
         String line;
         Scanner inputLine;

         // Vi læser alt input som string, så at kunne splitte på komma.
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

         line = input.nextLine();
         inputLine = new Scanner(line);
         inputLine.useDelimiter(",|" + System.lineSeparator());

         id = inputLine.next();
         name = inputLine.next();
         birthYear = inputLine.next();
         birthMonth = inputLine.next();
         birthday = inputLine.next();
         paidYear = inputLine.next();

         // Konvertér alle Strings der skal være ints til int
         resultID = Integer.parseInt(id);
         resultBirthday = Integer.parseInt(birthday);
         resultBirthMonth = Integer.parseInt(birthMonth)-1;
         resultBirthYear = Integer.parseInt(birthYear);
         resultPaidYear = Integer.parseInt(paidYear);

         Calendar birthDate = new GregorianCalendar(resultBirthYear, resultBirthMonth, resultBirthday);

         member = new Member(resultID, name, birthDate, resultPaidYear);

         // Så længe der er mere tilbage i linjen, læser vi et resultat mere ind.
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

            // Vi tilføjer kun den disciplin vi lige har læst, hvis den ikke findes i listen allerede.
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

      //for hvert member af typen Member i ArrayListen MemberList.all
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

         for (Result result : member.results)
         {
            output.printf(",%s,%d", result.discipline, result.time);
         }

         output.println();
      }
   }

   public static ArrayList<Member> debtors()
   {
      ArrayList<Member> debtors = new ArrayList<Member>();

      for (Member member : MemberList.all)  //for each
      {
         if (member.paidYear < Calendar.getInstance().get(Calendar.YEAR))
         {
            debtors.add(member);

            //System.out.println(member.name + " " + member.balance);
         }
      }

      return debtors;
   }

}