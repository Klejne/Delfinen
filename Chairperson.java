import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintStream;

public class Chairperson extends User
{
   public Chairperson(String login, String password)  //constructor
   {
      super(login, password);      
   }
   
   public static void printMenu()
   {
      int choice;
      Scanner input = new Scanner(System.in);
    
      System.out.println("Formand for Delfinen");
      System.out.println("[1] Se medlemmer");
      System.out.println("[2] Indmeld medlemmer");
      System.out.println("[3] Ret i medlemsoplysninger");
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
      
         case 0: System.out.println("Farvel."); break;
        
         case 1: printMembers(); break;
         
         case 2: createMember(); break;
            
         case 3: editMember(); break;
         
         default: System.out.println("Prøv igen"); printMenu();       
      }
      
   }
   
   public static void printMembers()
   {
      
      for (Member member : MemberList.all)
      {
         System.out.println(member);
      }
      
   }
   
   public static void createMember()
   {
      ArrayList<Member> member2 = MemberList.all;
      Scanner scanner = new Scanner(System.in);
      
      //PrintStream output;
      //output = FileManager.write("members.csv");  
      
      int id = 0;
      String name = "";
      int birthday = 0;
      int balance = 0;
      
      System.out.println("Indtast navn");
      while(scanner.hasNextLine())
      {
         name = scanner.nextLine();
      }
      
      System.out.println(name);
      //output.println(name);
      
      MemberList.addMember(id, name, birthday, balance);
      
      
      /*for (int i = 0; i < member2.size(); i++)
      {
         output.print(member2.add(i));
      }*/
   
   }
   
   public static void editMember()
   {
      //Search for member, and edit it.   
   }
}