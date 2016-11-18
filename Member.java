import java.util.*;
import java.io.*;

public class Member
{
   public int id;
   public int balance;
   public String name;
   public GregorianCalendar/*(int year, int month, int dayOfMonth)*/ birthday;
   
   public static Member[] all = new Member[3];
   
   public String toString()
   {
      String string = String.format("%-15s | %6d", name, balance);
      
      return string;
   }
   
   public Member(int id, String name, int balance)  //constructor
   {
      this.id = id;
      this.name = name;
      this.balance = balance;
   }
   
   public static Member[] debtors()
   {
      Member[] debtor = new Member[1];
      
      for (Member member : all)  //for each
      {        
         if(member.balance < 0)
         {  
            for(int i = 0; i < debtor.length; i++)
            {
               debtor[i] = member;
            }
            //System.out.println(member.name + " " + member.balance);
         }
      }
      
      return debtor;
   }
   
   public static void debtorsToFile()
   {  
      PrintStream output;
      Member[] debtorsPrint = debtors();  
      
      try
      {
         output = new PrintStream(new File("debt.txt"));
      }
      
      catch(FileNotFoundException ex)
      {
         System.out.print(ex);
         return;  
      }
      
      for(int i = 0; i < debtorsPrint.length; i++)
      {
         output.println(Arrays.toString(debtorsPrint));
      }
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