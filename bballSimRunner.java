//**********************
//  AP CSP NBA simulation
//  Richard Vlady
// simulate an NBC season according to the factors of the user
// Runner File (uses "basketballSim", "Team", "Game" , "Season" object files)
//*********************

import java.util.Scanner;
import java.util.ArrayList;

public class bballSimRunner
{
  public static void main(String[]args)
  {
    Scanner scan = new Scanner(System.in);
    
    int prefWeek = 1, prefGame;
    ArrayList<Integer> group1 = new ArrayList<Integer>();
    ArrayList<Integer> group2 = new ArrayList<Integer>();
    
    basketballSim season;
    
    // pRINT THE instructions and purpose of this program
    System.out.println("*****************************************************");
    System.out.println("This program will simulate a baksetball season.");
    System.out.println("Follow the prompts to simulate your prefered season.");
    System.out.println("*****************************************************");
    
    // read info for constuctor of season
    System.out.println("How many teams are in this league? (even number)");
    int numTeams = scan.nextInt();
    System.out.println("How many games will each team play?");
    int numGames = scan.nextInt();

    
    season = new basketballSim(numGames, numTeams);
    
    // for loop to take in the team names
    for (int i = 0; i < numTeams; i++)
    {
      System.out.println("Name of team " + (i+1));
      String teamName = scan.next();
      season.addTeam(teamName, i+1);
      
    }
    
    // call of methods to forms the scedual and then simulate the season.
    season.createGroups();
    group1 = season.getGroup1();
    group2 = season.getGroup2();
    
    season.playSeason(group1, group2);
    
    // allows the user to determine if they want to see the season stats for all the teams.
    System.out.println("Would you like to see each teams stats? (yes or no)");
    String cent = scan.next();
    
    if (cent.equals("yes"))
      for (int i = 0; i < numTeams; i++)
      System.out.println(season.getTeam(i));
    
    // creates 2D array with the whole season and prints it
    String[][] fullReport = season.getFullReport();
  
    System.out.println("Would you like to see the season results? (yes or no)");
    String cent2 = scan.next();
    
    if (cent2.equals("yes"))
    System.out.println(season); // toString method that print out information in fullReport list
    
    
    // while loop to allow user to pull stats of any game
    while (prefWeek != -2)
    {
      System.out.println("Which games stats would you like to see?\n (week \"-1\" to exit)");
      System.out.println("Week:");
      prefWeek = scan.nextInt()-1;
      if (prefWeek != -2)
      {
        System.out.println("Game:");
        prefGame = scan.nextInt()-1;
    
        season.createGroups();
        season.rotateGroups(prefWeek);
            
        group1 = season.getGroup1();
        group2 = season.getGroup2();
    
        System.out.println("\n********************");
        System.out.println(season.getTeam(group1.get(prefGame)).getGame(prefWeek));
        System.out.println(season.getTeam(group2.get(prefGame)).getGame(prefWeek));
        System.out.println("********************\n");
      }
    }
  
  }
}  
    
