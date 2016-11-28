import java.util.ArrayList;
import java.util.Scanner;

public class MemberList
{
   public static ArrayList<Member> all = new ArrayList();
   
   public static void addMember(int id, String name, int birthday, int balance)
   {  
      Member member = new Member(id, name, birthday, balance);
   }
   
   public static ArrayList<Member> populate()
   {
      Scanner input;
      Member member;
      
      ArrayList<Member> members = new ArrayList<Member>();
      
      input = FileManager.read("members.csv");
      
      
      //useDelimiter splitter på de/t tegn (her: komma) der står i anførselstegn,
      input.useDelimiter(",|" + System.lineSeparator());    //System.lineSeparator læser selv om det er \n, \r eller \n\r

      while (input.hasNextLine())
      {  
         String id = input.next();
         String name = input.next();
         String birthday = input.next();
         String balance = input.next();
          

         int resultID = Integer.parseInt(id);
         int resultBirthday = Integer.parseInt(birthday);
         int resultBalance = Integer.parseInt(balance);
         

         member = new Member(resultID, name, resultBirthday, resultBalance);
         
         MemberList.all.add(member);
         System.out.print(member);  //printer det enkelte medlem
         
      }
      
      //System.out.print(Member.all); //printer ArrayList af members
      return null;

   }

}