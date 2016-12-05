import java.util.Scanner;
import java.util.ArrayList;

public class Coach extends User
{
   public Coach(String login, String password)  //constructor
   {
      super(login, password);      
   }
   
   public static void printMenu()
   {
      int choice;
      Scanner input = new Scanner(System.in);
    
      System.out.println("Træner for Delfinen");
      System.out.println("[1] Se top 5 resultater for hver disciplin");
      System.out.println("[2] Tilføj resultat");
      System.out.println("[0] Luk");
      
      System.out.print("Vaelg:");
      
      if (input.hasNextInt())
      {
         choice = input.nextInt();
         switchMenu(input, choice);
      }      
   }
   
   public static void switchMenu(Scanner input, int choice)
   {
      switch (choice)
      {
         case 0: System.out.println("Farvel"); break;
         case 1: printResults(); break;    
         case 2: addResult(input); break;
         default: System.out.println("Prøv igen"); printMenu();       
      }     
   }
   
   public static void printResults()
   {
      
      //for hvert discipline af typen String i ArrayListen disciplines i klassen result 
      for (String discipline : Result.disciplines)
      {
         ArrayList<Member> members;
         members = new ArrayList(); 
         
         System.out.println(discipline);
         System.out.printf("%-2s | %-4s | %-10s | Toptid%s" ,"#", "ID", "Navn", System.lineSeparator());
         
         for (Member member : MemberList.all)
         {
            for (Result result : member.results)
            {
               if (result.discipline.equals(discipline))
               {
                  if (members.contains(member) == false)
                  {
                     members.add(member);
                  }
               }
            }
         }
         
         for (int i = 1; i <= 5; i++)
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
            
            members.remove(bestMember);
            System.out.printf("%d. | %4d | %-10s | %4.2f s%s", i, bestMember.id, bestMember.name, bestMember.bestTime(discipline) / 1000.0, System.lineSeparator());
            
         }
         
         System.out.println();
      }
      
      printMenu();
   }
   
   public static void addResult(Scanner input)
   {
      int memberID;
      
      memberID = 0;
      
      System.out.print("Tast medlemsnummer");
      
      
      
      if (input.hasNextInt())
      {
         Member member = null;
         memberID = input.nextInt();
         
         
         member = MemberList.find(memberID);
         
                  
         if (member == null)
         {
            System.out.print("Kunne ikke finde medlem - prøv igen");
            addResult(input);
            return;
         }
         
         System.out.println(member);
         
         
         
         printMenu();         
      }  
   }
}