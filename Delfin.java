public class Delfin
{  
   public static void main(String[] args)
   {
      MemberList.populate();
      //Member.debtors();
      MemberList.debtorsToFile();
      User.populate();
      
      // while (User.login() == false) // Den bliver kørt igen, hvis login eller password er forkert.
      {
      
      }  
      
      //Accountant.printMenu();
      Chairperson.printMenu();
   }
}