public class Delfin
{  
   public static void main(String[] args)
   {
      MemberList.readFromFile();
      //MemberList.debtors();
      MemberList.debtorsToFile();
      User.populate();
      
      // while (User.login() == false) // Den bliver k�rt igen, hvis login eller password er forkert.
      {
      
      }  
      
      //Accountant.printMenu();
      Chairperson.printMenu();
   }
}