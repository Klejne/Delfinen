import java.util.Scanner;

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
      System.out.printf("%4s | %-10s | Sidst Betalt%s" , "ID", "Navn", System.lineSeparator());
      
      //for hvert member af typen Member i ArrayListen MemberList.debtors 
      for (Member member : MemberList.all)
      {
         System.out.printf("%4d | %-10s | %5d%s", member.id, member.name, member.paidYear, System.lineSeparator());
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