public class Delfin
{
   public static void main(String[] args)
   {
      MemberList.readFromFile();
      User.populate();

      // Spørg efter username og password indtil login lykkes.
      // while (User.login() == false) { }

      Accountant.printMenu();
      Chairperson.printMenu();
      Coach.printMenu();
   }
}