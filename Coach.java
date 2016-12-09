import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintStream;

public class Coach extends User
{
   private static final int TOP_SWIMMER_COUNT = 5;


   /* Tina, Peter, Karo, Emma */
   public Coach(String login, String password)  //constructor
   {
      super(login, password);      
   }


   /* Tina, Peter, Karo, Emma */
   public static void printMenu()
   {
      int choice;
      Scanner input = new Scanner(System.in);
    
      System.out.println("Træner for Delfinen");
      System.out.println("[1] Se top 5 resultater for hver disciplin");
      System.out.println("[2] Udskriv top 5 resultater for hver disciplin til fil");
      System.out.println("[3] Tilføj resultat");
      System.out.println("[0] Luk");
      
      System.out.print("Vaelg:");
      
      if (input.hasNextInt())
      {
         choice = input.nextInt();
         switchMenu(input, choice);
      }      
   }


   /* Tina, Peter, Karo, Emma */
   private static void switchMenu(Scanner input, int choice)
   {
      switch (choice)
      {
         case 0: System.out.println("Farvel"); break;
         case 1: printResults(); break;
         case 2: resultsToFile(); break;       
         case 3: addResult(input); break;
         default: System.out.println("Prøv igen"); printMenu();       
      }     
   }


   /* Tina, Peter, Karo, Emma */
   private static ArrayList<Member> getTopSwimmers(String discipline)
   {
      ArrayList<Member> members;
      ArrayList<Member> topSwimmers;
      
      members = new ArrayList();
      topSwimmers = new ArrayList(); 
      
      for (Member member : MemberList.getAll())
      {
         for (Result result : member.getResults())
         {
            if (result.getDiscipline().equals(discipline))
            {
               if (members.contains(member) == false)
               {
                  members.add(member);
               }
            }
         }
      }
      
      for (int i = 1; i <= TOP_SWIMMER_COUNT; i++)
      {
         Member bestMember;
         
         if (members.size() == 0)
         {
            break;
         }
   
         bestMember = members.get(0);
         
         for (Member member : members)
         {
            if (bestMember.bestTime(discipline) > member.bestTime(discipline))
            {
               bestMember = member;               
            }
         }
         
         topSwimmers.add(bestMember);
         members.remove(bestMember);
      }
         
      return topSwimmers;
   }


   /* Tina, Peter, Karo, Emma */
   private static void printResults()
   {
      //for hvert discipline af typen String i ArrayListen disciplines i klassen result 
      for (String discipline : Result.getDisciplines())
      {
         int position;
         ArrayList<Member> members;
         members = getTopSwimmers(discipline); 
         
         System.out.println(discipline);
         System.out.printf("%-2s | %-4s | %-10s | Toptid%s" ,"#", "ID", "Navn", System.lineSeparator());
         
         position = 1;
         
         for (Member bestMember : members)
         {  
            System.out.printf("%d. | %4d | %-10s | %4.2f s%s", position, bestMember.getId(), bestMember.getName(), bestMember.bestTime(discipline) / 1000.0, System.lineSeparator());
            position++;
         }
         
         System.out.println();
      }
      
      printMenu();
   }


   /* Tina, Peter, Karo, Emma */
   private static void resultsToFile()
   {
      PrintStream output;
      
      output = FileManager.write("top.txt"); 
      
      for (String discipline : Result.getDisciplines())
      {
         int position;
         ArrayList<Member> members;
         members = getTopSwimmers(discipline); 
         
         output.println(discipline);
         output.printf("%-2s | %-4s | %-10s | Toptid%s" ,"#", "ID", "Navn", System.lineSeparator());
         
         position = 1;
         
         for (Member bestMember : members)
         {  
            output.printf("%d. | %4d | %-10s | %4.2f s%s", position, bestMember.getId(), bestMember.getName(), bestMember.bestTime(discipline) / 1000.0, System.lineSeparator());
            position++;
         }
         
         output.println();
      }
      
      printMenu();
   }


   /* Tina, Peter, Emma */
   private static void addResult(Scanner input)
   {
      int memberID;
      
      System.out.print("Tast medlemsnummer");
      
      if (input.hasNextInt())
      {
         Member member;
         memberID = input.nextInt();
         
         member = MemberList.find(memberID);
         
         if (member == null)
         {
            System.out.print("Kunne ikke finde medlem - prøv igen");
            addResult(input);
            return;
         }
         
         input.nextLine();    //HACK: slug linjeskift
         
         System.out.println(member.prettyPrint());
         System.out.println("Disciplin?");
         
         String discipline;
         discipline = input.nextLine();
         
         System.out.println(discipline);
         System.out.println("Indtast tid i sekunder");
         
         String time;
         time = input.nextLine();
         time = time.replaceAll(",", ".");   //replaceAll-metoden ændrer komma til punktum
         
         double resultTime;
         resultTime = Double.parseDouble(time);
          
         System.out.println(resultTime);
         
         Result result;
         result = new Result(discipline.toUpperCase(), (int) (resultTime * 1000));
         member.getResults().add(result);
         
         MemberList.writeToFile();
         
         printMenu();         
      }  
   }
}