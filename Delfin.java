public class Delfin
{
   /* Tina, Peter, Karo, Emma */
   public static void main(String[] args)
   {
      MemberList.readFromFile();
      User.populate();

      // Sp�rg efter username og password indtil login lykkes.
      while (User.login() == false) { }
        
      Accountant.printMenu();
      Chairperson.printMenu();
      Coach.printMenu();
   }
}