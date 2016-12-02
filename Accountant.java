import java.util.Scanner;

public class Accountant extends User
{
   public Accountant(String login, String password)  //constructor
   {
      super(login, password);      
   }
   
   public static void printMenu()
   {
      int choice;
      Scanner input = new Scanner(System.in);
    
      System.out.println("Kasserer for Delfinen");
      System.out.println("[1] Se medlemmer i restance");
      System.out.println("[2] Opdater Medlemsbetaling");
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
         case 1: printDebtors(); break;    
         case 2: updatePayment(input); break;
         default: System.out.println("Prøv igen"); printMenu();       
      }     
   }
   
   public static void printDebtors()
   {
      System.out.printf("%4s | %-10s | Sidst Betalt%s" , "ID", "Navn", System.lineSeparator());
      
      //for hvert member af typen Member i ArrayListen MemberList.debtors 
      for (Member member : MemberList.debtors())
      {
         System.out.printf("%4d | %-10s | %5d%s", member.id, member.name, member.paidYear, System.lineSeparator());
      }
      
      printMenu();
   }
   
   public static void updatePayment(Scanner input)
   {
      int memberID;
      
      memberID = 0;
      
      System.out.print("Tast medlemsnummer");
      
      
      
      if (input.hasNextInt())
      {
         Member foundMember = null;
         memberID = input.nextInt();
         
         
         for (Member member : MemberList.all)
         {
            if (memberID == member.id)
            {
               foundMember = member;
               
               break;
            }               
         }
         
         if (foundMember == null)
         {
            System.out.print("Kunne ikke finde medlem - prøv igen");
            updatePayment(input);
            return;
         }
         
         System.out.println(foundMember);
         System.out.println("[1] Har betalt i år");
         System.out.println("[0] Gå tilbage");
         
         if (input.nextInt() == 1)
         {
            foundMember.paidYear = 2016;
            System.out.println(foundMember);
            
            MemberList.writeToFile();
         }
         printMenu();         
      }  
   }
}