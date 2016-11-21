import java.util.*;
import java.io.*;
import java.util.ArrayList;


public class Member
{
   public int id;
   public int balance;
   public String name;
   //public GregorianCalendar (int year, int month, int dayOfMonth) birthday;
   public int birthday;
   
   public static ArrayList<Member> all = new ArrayList();
   
   public String toString()   //kaldes automatisk de steder hvor objektet automatisk konverteres til en streng
   {
      String string = String.format("%-15s | %6d", name, balance);
      
      return string;
   }
   
   public Member(int id, String name, int birthday, int balance)  //constructor
   {
      this.id = id;
      this.name = name;
      this.birthday = birthday;
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
      /*File f = new File("members.txt");
      int nr;
      Member member = new Member();
      
      Pizza[] pizzabuffer = new Pizza[100];
      nr = 0;
      
      
      Scanner input;
      try
      {
         input = new Scanner(f, StandardCharsets.UTF_8.name());
      }
      catch(FileNotFoundException ex)
      {
         System.out.println(ex);
         return;
      }*/
      
   
      Member ole = new Member(1, "Ole Bole", 1987, 300);
      Member hans = new Member(2, "Hans P", 1887, 400);
      Member karen = new Member(3, "Karen G", 2000, -100);
      Member kåre = new Member(4, "Kåre Pol", 1987, -300);
      Member louise = new Member(5, "Louise Ålle", 1999, 400);
      
      all.add(ole);
      all.add(hans);
      all.add(karen);
      all.add(kåre);
      all.add(louise);
      
      System.out.println(all);
   }
   
}