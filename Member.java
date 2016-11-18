import java.util.*;
import java.io.*;

public class Member
{
   public int id;
   public int balance;
   public String name;
   public GregorianCalendar/*(int year, int month, int dayOfMonth)*/ birthday;
   
   public static Member[] all = new Member[3];
   
   public Member(int id, String name, int balance)  //constructor
   {
      this.id = id;
      this.name = name;
      this.balance = balance;
   }
   
   public static Member[] debtors()
   {
      for (Member member : all)  //for each
      {        
         if(member.balance < 0)
         {
            System.out.println(member.name + " " + member.balance);
         }
      }
      
      return null;
   }
   
   public static void debtorsToFile()
   {  
      File debt = new File("debt.txt");
      Scanner input;
      
      try
      {
         input = new Scanner(debt);
      }
      
      catch(FileNotFoundException ex)
      {
         System.out.print(ex);
         return;  
      }
      
      //output.println("HHH");
      
      //Hent info om medlemmer i gæld
      //Skriv ud til fil
   } 
   
   public static void populate()
   {
      Member ole = new Member(1, "Ole Bole", 300);
      Member hans = new Member(2, "Hans P", 400);
      Member karen = new Member(3, "Karen G", -100);
      
      all[0] = ole;
      all[1] = hans;
      all[2] = karen;
      
      for (int i = 0; i < 3; i++)
      {
         //System.out.println(all[i].balance);  //Arrays.toString(all)
      }
   }
   
}