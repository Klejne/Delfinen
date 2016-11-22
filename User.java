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
      
      
     
   
   
   
}