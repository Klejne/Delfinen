import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintStream;

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
      
      input = FileManager.read("members.csv");
      
      
      //useDelimiter splitter på de/t tegn (her: komma) der står i anførselstegn.
      //System.lineSeparator læser selv om det er \n, \r eller \n\r
      input.useDelimiter(",|" + System.lineSeparator());    

      while (input.hasNextLine())
      {  
         String id;           //vi læser det som string, fordi den kan splitte på et komma
         String name;
         String birthday;
         String balance;
         
         id = input.next();
         name = input.next();
         birthday = input.next();
         balance = input.next();
         
         int resultID;
         int resultBirthday;
         int resultBalance;
         
         resultID = Integer.parseInt(id);      //konverterer String til int
         resultBirthday = Integer.parseInt(birthday);
         resultBalance = Integer.parseInt(balance);
         
         member = new Member(resultID, name, resultBirthday, resultBalance);
         
         MemberList.all.add(member);
         
      }
      
      //System.out.print(MemberList.all); //printer ArrayList af members
      return null;

   }
   
   
   public static ArrayList<Member> debtors()
   {
      ArrayList<Member> debtors = new ArrayList<Member>();
      
      for (Member member : MemberList.all)  //for each
      {        
         if (member.balance < 0)
         {  
            debtors.add(member);
            
            //System.out.println(member.name + " " + member.balance);
         }
      }
      
      return debtors;
   }
   
   
   public static void debtorsToFile()
   {  
      PrintStream output;
      ArrayList<Member> debtorsPrint;
      
      output = FileManager.write("debt.txt"); 
      debtorsPrint = debtors();
      
      for (Member debtor : debtorsPrint)  //for each
      {
         output.print(debtor);
      }
   } 

}