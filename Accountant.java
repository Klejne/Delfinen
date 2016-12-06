import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.io.PrintStream;


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
      System.out.println("[2] Udskriv medlemmer i restance til fil");
      System.out.println("[3] Opdater Medlemsbetaling");
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
         case 2: debtorsToFile(); break;  
         case 3: updatePayment(input); break;
         default: System.out.println("Prøv igen"); printMenu();       
      }     
   }
   
   public static void printDebtors()
   {
      System.out.printf("%4s | %-10s | Sidst Betalt%s" , "ID", "Navn", System.lineSeparator());
      
      //for hvert member af typen Member i ArrayListen MemberList.debtors 
      for (Member member : MemberList.debtors())
      {
         System.out.printf("%4d | %-10s | %5d%s", member.getId(), member.getName(), member.getPaidYear(), System.lineSeparator());
      }
      
      printMenu();
   }
   
   
   public static void debtorsToFile()
   {  
      PrintStream output;
      ArrayList<Member> debtorsPrint;
      
      output = FileManager.write("debt.csv"); 
      debtorsPrint = MemberList.debtors();
      
      for (Member debtor : debtorsPrint)  //for each
      {
         output.printf("%d,%s,%d",
            debtor.getId(),
            debtor.getName(),
            debtor.getPaidYear()
         );

         output.println();
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
         Member member = null;
         memberID = input.nextInt();
         
         
         member = MemberList.find(memberID);
         
                  
         if (member == null)
         {
            System.out.print("Kunne ikke finde medlem - prøv igen");
            updatePayment(input);
            return;
         }
         
         System.out.println(member.prettyPrint());
         System.out.println("[1] Har betalt i år");
         System.out.println("[0] Gå tilbage");
         
         if (input.nextInt() == 1)
         {
            // Finder det nuværende år, og bruger dét.
            member.setPaidYear(Calendar.getInstance().get(Calendar.YEAR));
            System.out.println(member.prettyPrint());

            MemberList.writeToFile();
         }
         printMenu();         
      }  
   }
}