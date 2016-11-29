import java.util.ArrayList;
import java.util.Scanner;

public class Member
{
   public int id;
   public int balance;
   public String name;
   public int birthday;
   
   
   public String toString()   //kaldes automatisk de steder hvor objektet konverteres til en streng
   {
      String string;
      string = String.format("%-4d %-15s %d %5d", id, name, birthday, balance);
      
      return string;
   }
   
   
   public Member(int id, String name, int birthday, int balance)  //constructor
   {
      this.id = id;
      this.name = name;
      this.birthday = birthday;
      this.balance = balance;
   }
     
}