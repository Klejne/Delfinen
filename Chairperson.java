import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintStream;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class Chairperson extends User
{
   /* Tina, Peter, Karo, Emma */
   public Chairperson(String login, String password)  //constructor
   {
      super(login, password);      
   }


   /* Tina, Peter, Karo, Emma */
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


   /* Tina, Peter, Karo, Emma */
   private static void switchMenu(Scanner input, int choice)
   {
      switch (choice)
      {
      
         case 0: System.out.println("Farvel."); break;
        
         case 1: printMembers(); break;
         
         case 2: createMember(); break;
            
         case 3: editMember(input); break;
         
         case 4: deleteMember(input); break;
         
         default: System.out.println("Prøv igen"); printMenu();       
      }
      
   }


   /* Tina, Peter, Karo, Emma */
   private static void printMembers()
   {
      for (Member member : MemberList.getAll())
      {
         System.out.println(member.prettyPrint());
      }
      
      printMenu();
   }


   /* Tina, Peter, Emma */
   private static void createMember()
   {
      Scanner scanner;
      
      scanner = new Scanner(System.in);
      
      int id;
      
      String name;
      int birthday;
      int birthMonth;
      int birthYear;
      int paidYear = Calendar.getInstance().get(Calendar.YEAR);
      Member last;      //typen Member med navnet last (den sidste oprettet)
      
      last = MemberList.getAll().get(MemberList.getAll().size() - 1);
      
      id = last.getId() + 1;
      
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


   /* Tina, Peter, Emma */
   private static void editMember(Scanner input)
   {
      int memberID;
      
      System.out.print("Tast medlemsnummer");
      
      if (input.hasNextInt())
      {  
         int choice;
         Member member;
         memberID = input.nextInt();
         
         choice = 0;
         member = MemberList.find(memberID);
         
                  
         if (member == null)
         {
            System.out.print("Kunne ikke finde medlem - prøv igen");
            return;
         }
         
         System.out.println(member.prettyPrint());
         System.out.println("[1] Ret navn");
         System.out.println("[0] Gå tilbage");
         
         System.out.print("Vaelg:");
      
         if (input.hasNextInt())
         {
            choice = input.nextInt();
         }
         
         switch (choice)
         {
            case 1: editName(input, member); break;    
            case 2: break;
            default: System.out.println("Prøv igen"); printMenu();       
         }

         printMenu();
      }         
   }


   /* Tina, Peter, Karo, Emma */
   private static void editName(Scanner input, Member member)
   {
      
      System.out.println("Indtast nyt navn");
      
      input.nextLine();    //HACK:sluger linjeskift for meget fra nextInt i editMember()

      if (input.hasNextLine())
      {
         member.setName(input.nextLine());
         System.out.println(member.prettyPrint());
         
         MemberList.writeToFile();
      }
   }


   /* Tina, Peter, Karo, Emma */
   private static void deleteMember(Scanner input)
   {
      int memberID;

      System.out.print("Tast medlemsnummer");
      
      if (input.hasNextInt())
      {  
         Member member;
         memberID = input.nextInt();
         
         member = MemberList.find(memberID);
         
         if (member == null)
         {
            System.out.print("Kunne ikke finde medlem - prøv igen");
            return;
         }
         
         System.out.println(member.prettyPrint());
         System.out.println("[1] Slet medlem" + member.getName());
         System.out.println("[0] Gå tilbage");
         
         System.out.print("Vaelg:");
      
         if (input.nextInt() == 1)
         {
            MemberList.getAll().remove(member);
            
            printMembers();
            MemberList.writeToFile();
         }
      }
 
      printMenu(); 
   }
}