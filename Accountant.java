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
      System.out.println("[2] Træk kontingent fra alle medlemmer");
      System.out.println("[0]");
      
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
            
         case 2: subtractPayment(); break;
         
         default: System.out.println("Prøv igen"); printMenu();       
      }
      
   }
   
   public static void printDebtors()
   {
      MemberList.debtors();
   }
   
   public static void writeDebtors()
   {
      //Member.debtorsToFile();   
   }
   
   public static void readDebtors()
   {
   
   }
   
   public static void subtractPayment()
   {
   
   }
}