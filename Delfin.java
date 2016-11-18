public class Delfin
{  
   public static void main(String[] args)
   {
      Member.populate();
      Member.debtors();
      Member.debtorsToFile();

      User.login();
      User.populate();
    

   }
}