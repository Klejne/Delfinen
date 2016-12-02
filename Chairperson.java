import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintStream;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class Chairperson extends User
{
   public Chairperson(String login, String password)  //constructor
   {
      super(login, password);      
   }
   
   public static void printMenu()
   {
      int choice;
      Scanner input = new Scanner(System.in);
    
      System.out.println("Formand for Delfinen");
      System.out.println("[1] Se medlemmer");
      System.out.println("[2] Indmeld medlemmer");
      System.out.println("[3] Ret i medlemsoplysninger");
      System.out.println("[4] Slet medlem");
      System.out.println("[0] Luk");
      
      System.out.print("Vaelg:");
      
      if (input.hasNextInt())
      {
         choice = input.nextInt();
         switchMenu(input, choice);
      }      
   }
   
   public static void switchMenu(Scanner input, int choice)
   {
      switch (choice)
      {
      
         case 0: System.out.println("Farvel."); break;
        
         case 1: printMembers(); break;
         
         case 2: createMember(); break;
            
         case 3: editMember(); break;
         
         case 4: deleteMember(); break;
         
         default: System.out.println("Prøv igen"); printMenu();       
      }
      
   }
   
   public static void printMembers()
   {
      
      for (Member member : MemberList.all)
      {
         System.out.println(member);
      }
      
      printMenu();
   }
   
   public static void createMember()
   {
      Scanner scanner;
      
      scanner = new Scanner(System.in);
      
      int id = 0;
      
      String name;
      int birthday;
      int birthMonth;
      int birthYear;
      int paidYear = Calendar.getInstance().get(Calendar.YEAR);
      Member last;      //typen Member med navnet last (den sidste oprettet)
      
      last = MemberList.all.get(MemberList.all.size() - 1);
      
      id = last.id + 1;
      
      System.out.println(id);
      
      System.out.println("Indtast navn");
      if (scanner.hasNextLine())
      {
         name = scanner.nextLine();
      }
      else 
      {
         return;
      }
      
      System.out.println("Indtast fødselsdato (dd mm yyyy)");
      if (scanner.hasNextInt())
      {
         birthday = scanner.nextInt();
         birthMonth = scanner.nextInt();
         birthYear = scanner.nextInt();
         
      }
      else 
      {
         return;
      }
      
      GregorianCalendar birthDate = new GregorianCalendar(birthYear, birthMonth-1, birthday);
            
      System.out.printf("Du har tilføjet: %d | %s | %02d/%02d/%d\n", id, name, birthday, birthMonth, birthYear);
     
      MemberList.addMember(id, name, birthDate, paidYear);
      
      
      MemberList.writeToFile();
      
      printMenu();
      
  
   }
   
   public static void editMember()
   {
        
   }
   
   static void deleteMember()
   {
      //Delete member
   }
}