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


   public String toString()
   {
      return login + ":" + password;
   }


   public boolean equals(Object other)
   {
      if (this == other)
      {
         return true;
      }
      else
      {
         return false;
      }
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

      // For hver user af typen User i ArrayListen all
      for (User user : all)
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
      User admin;
      User root;
      User user;

      admin = new User("admin", "1234");
      root = new User("root", "god");
      user = new User("user", "password");
      
      all.add(admin);
      all.add(root);
      all.add(user);
   }
}