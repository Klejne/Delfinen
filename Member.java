import java.util.*;
import java.io.*;


public class Member
{
   public int id;
   public int balance;
   public String name;
   public GregorianCalendar/*(int year, int month, int dayOfMonth)*/ birthday;
   
   public static Member[] all = new Member[5];
   
   public String toString()   //kaldes automatisk de steder hvor objektet automatisk konverteres til en streng
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
      Member[] debtor = new Member[2];
      int i = 0;
      
      for (Member member : all)  //for each
      {        
         if (member.balance < 0)
         {  
            debtor[i] = member;
            i++;
            
            System.out.println(member.name + " " + member.balance);
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
      
      for (int i = 0; i < debtorsPrint.length; i++)
      {
         output.println(debtorsPrint[i]);
      }
   } 
   
   public static void populate()
   {
      Member ole = new Member(1, "Ole Bole", 300);
      Member hans = new Member(2, "Hans P", 400);
      Member karen = new Member(3, "Karen G", -100);
      Member kåre = new Member(4, "Kåre Pol", -300);
      Member louise = new Member(5, "Louise Ålle", 400);
      
      all[0] = ole;
      all[1] = hans;
      all[2] = karen;
      all[3] = kåre;
      all[4] = louise;
      
      for (int i = 0; i < 4; i++)
      {
         //System.out.println(all[i].balance);  //Arrays.toString(all)
      }
   }
   
}