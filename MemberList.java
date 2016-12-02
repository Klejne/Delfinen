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
      Member member = new Member(id, name, birthday, paidYear);
      
      MemberList.all.add(member);
   }
   
   
   public static void readFromFile()
   {
      Scanner input;
      Member member;
      
      input = FileManager.read("members.csv");
      
      
      //useDelimiter splitter på de/t tegn (her: komma) der står i anførselstegn.
      //System.lineSeparator læser selv om det er \n, \r eller \n\r
      input.useDelimiter(",|" + System.lineSeparator());    

      while (input.hasNext())
      {  
         String id;           //vi læser det som string, fordi den kan splitte på et komma
         String name;
         String birthday;
         String birthYear;
         String birthMonth;
         String paidYear;
         
         id = input.next();
         name = input.next();
         birthYear = input.next();
         birthMonth = input.next();
         birthday = input.next();
         paidYear = input.next();
         
         int resultID;
         int resultBirthday;
         int resultBirthMonth;
         int resultBirthYear;
         int resultPaidYear;
         
         resultID = Integer.parseInt(id);      //konverterer String til int
         resultBirthday = Integer.parseInt(birthday);
         resultBirthMonth = Integer.parseInt(birthMonth)-1;
         resultBirthYear = Integer.parseInt(birthYear);
         resultPaidYear = Integer.parseInt(paidYear);
         
         GregorianCalendar birthDate = new GregorianCalendar(resultBirthYear, resultBirthMonth, resultBirthday);
         
         member = new Member(resultID, name, birthDate, resultPaidYear);
         
         MemberList.all.add(member);
         
      }
      
      //System.out.print(MemberList.all); //printer ArrayList af members
      

   }
   
   public static void writeToFile()
   {
      PrintStream output;
      output = FileManager.write("members.csv");  
      
      //for hvert member af typen Member i ArrayListen MemberList.all 
      for (Member member : MemberList.all)
      {
         output.printf("%d,%s,%d,%d,%d,%d%s",
            member.id,
            member.name,
            member.birthday.get(Calendar.YEAR),
            member.birthday.get(Calendar.MONTH)+1,
            member.birthday.get(Calendar.DAY_OF_MONTH),
            member.paidYear,
            System.lineSeparator()
         );
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