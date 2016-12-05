import java.util.Scanner;
import java.util.ArrayList;

public class Coach extends User
{
   public Coach(String login, String password)  //constructor
   {
      super(login, password);      
   }
   
   public static void printMenu()
   {
      int choice;
      Scanner input = new Scanner(System.in);
    
      System.out.println("Træner for Delfinen");
      System.out.println("[1] Se top 5 resultater for hver disciplin");
      System.out.println("[2] Tilføj resultat");
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
         case 0: System.out.println("Farvel"); break;
         case 1: printResults(); break;    
         case 2: addResult(input); break;
         default: System.out.println("Prøv igen"); printMenu();       
      }     
   }
   
   public static void printResults()
   {
      System.out.printf("%-4s | %-10s | Top 5%s" , "ID", "Navn", System.lineSeparator());
      
      //for hvert discipline af typen String i ArrayListen disciplines i klassen result 
      for (String discipline : Result.disciplines)
      {
         ArrayList<Member> members;
         members = new ArrayList(); 
         
         System.out.println(discipline);
         
         for (Member member : MemberList.all)
         {
            for (Result result : member.results)
            {
               if (result.discipline.equals(discipline))
               {
                  System.out.printf("%4d | %-10s | %4.2f s%s", member.id, member.name, result.time / 1000.0, System.lineSeparator());
               }
            }
         }
         System.out.println();
      }
      
      printMenu();
   }
   
   public static void addResult(Scanner input)
   {
      int memberID;
      
      memberID = 0;
      
      System.out.print("Tast medlemsnummer");
      
      
      
      if (input.hasNextInt())
      {
         Member member = null;
         memberID = input.nextInt();
         
         
         member = MemberList.find(memberID);
         
                  
         if (member == null)
         {
            System.out.print("Kunne ikke finde medlem - prøv igen");
            addResult(input);
            return;
         }
         
         System.out.println(member);
         
         
         
         printMenu();         
      }  
   }
}