public class Delfin
{  
   public static void main(String[] args)
   {
      MemberList.populate();
      //Member.debtors();
      Member.debtorsToFile();
      User.populate();
      
      // while (User.login() == false) // Den bliver k�rt igen, hvis login eller password er forkert.
      {
      
      }  
      
      Accountant.printMenu();
   }
}