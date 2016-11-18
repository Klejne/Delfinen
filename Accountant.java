public class Accountant extends User
{
   public static void printDebtors()
   {
      Member.debtors();
   }
   
   public static void writeDebtors()
   {
      Member.debtorsToFile();   
   }
   
   public static void readDebtors()
   {
   
   }
}