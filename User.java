import java.util.Scanner;
import java.util.ArrayList;

public class User
{
   private String login;
   private String password;
   
   private static ArrayList<User> all = new ArrayList();
   
   
   public User(String login, String password)  //constructor
   {
      this.login = login;
      this.password = password;
      
   }
   
   public static boolean login()
   {
      Scanner loginScanner = new Scanner(System.in);
      
      String userLogin;
      String userPassword;
      boolean success;
      success = false;
      
      System.out.print("Indtast login:");
      
      userLogin = loginScanner.nextLine();
      
      System.out.print("Indtast password:");
      
      userPassword = loginScanner.nextLine();
      
      for (User user : all)  //for each
      {        
         if (user.login.equals(userLogin) && user.password.equals(userPassword))
         {
            System.out.println("Velkommen!");
            success = true;
            
            
          
         }
      }
      
      if (success == false)
      {
         System.out.println("Forkert login eller password");
         
      }

      return success;
   }
      
   public static void populate()
   {
   
      
   
      User ole = new User("Ole Bole", "Bole Ole");
      User hans = new User("Hans P", "hej123");
      User karen = new User("Karen G", "password");
      
      all.add(ole);
      all.add(hans);
      all.add(karen);
      
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
      
         case 0: System.out.println("Goodbye"); break;
         
         case 1: Accountant.printDebtors(); break;
            
         case 2: Accountant.subtractPayment(); break;
         
         default: System.out.println("Prøv igen"); printMenu();       
      }
      
   }

   
   
}