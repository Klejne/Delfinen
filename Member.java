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
   
   public String toString()   //kaldes automatisk de steder hvor objektet automatisk konverteres til en streng
   {
      String string = String.format("%-4d %-15s %d %5d \n", id, name, birthday, balance);
      
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
      
      for (Member member : MemberList.all)  //for each
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
         output.print(debtorsPrint.get(i));
      }
   }   
}