import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

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
   
   
   
   public static ArrayList<Member> debtor()
   {
      ArrayList<Member> debtor = new ArrayList<Member>();   ///IKKE FÆRDIGT
      
      int i = 0;
      
      for (Member member: all)  //for each
      {        
         if (member.balance < 0)
         {  
            debtor.add(member);
            
            System.out.println(member.name + " " + member.balance);
         }
      }
      
      return debtor;
   }
   
   
   
   
   public static void debtorsToFile()
   {  
      PrintStream output;
      ArrayList<Member> debtorsPrint = debtor();
      
      output = FileManager.write("debt.txt");  
      
      for (int i = 0; i < debtorsPrint.size(); i++)
      {
         output.println(debtorsPrint.get(i));
      }
   } 
   
   public static void populate()
   {
   
      File memberFile = new File("members.csv");
      
      Scanner input;
      
      input = FileManager.read("members.csv");
      
      while (input.hasNextLine())
      {   
         System.out.println(input.nextLine());
      }
      
      /*
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
      */
   }
   
}