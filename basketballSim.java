//**********************
//  AP CSP NBA simulation
//  Richard Vlady
// simulate an NBC season according to the factors of the user
// Referece File (uses "Team", "Game" , "Season" object files)
//*********************

import java.util.ArrayList;

public class basketballSim
{
  // varibables
  private int numGames, numTeams, week, game, temp;
  private boolean outcome;
  private ArrayList<Teams> roster;
  private Teams team;
  private String[][] fullReport;
  ArrayList<Integer> group1;
  ArrayList<Integer> group2;
  
  // constructor 
  public basketballSim (int games, int teams)
  {
    numGames = games;
    numTeams = teams;
    week = 0;
    game = 0;
    
    roster = new ArrayList<Teams>();
    fullReport = new String[games][teams/2];
    group1 = new ArrayList<Integer>();
    group2 = new ArrayList<Integer>();
  }
  
  // constructor to add team
  public void addTeam(String name, int num)
  {
    team = new Teams(name, num);
    roster.add(team);
  }
  
  // simulates a game and creates a game object for each team the has there stats.
  // also stores the game into a 2D array (fullReport) each row being a week and a collom being a game
  private void playGame(int team1, int team2)
  {
    Game teamA = roster.get(team1).playGame();
    Game teamB = roster.get(team2).playGame();
    
    if (teamA.getPoints() > teamB.getPoints())
    {
      teamA.setOutcome(true);
      roster.get(team1).addWin();
    }
    else 
      roster.get(team1).addLose();
    
    if (teamA.getPoints() < teamB.getPoints())
    {
      teamB.setOutcome(true);
      roster.get(team2).addWin();
    }
    else
      roster.get(team2).addLose();
    
    
    if (game > numTeams/2-1)
      resetGame();
    
    fullReport[week][game] = teamA.getPoints() + "-" + teamB.getPoints();
    game++;
  }
  
  //create the grousp to run through the teams and matches
  public void createGroups()
  {
    // remove all prior numbers from the group variable
    while (group1.size() > 0)
      group1.remove(0);
    
    while (group2.size() > 0)
      group2.remove(0);
    
         // GROUP 1
    for (int i = 0; i < numTeams/2; i++)
      group1.add(i);
    
      // GROUP 2
    for (int i = numTeams/2; i < numTeams; i++)
      group2.add(i);
  }
  
  // give tips and simiulate the season
  public void playSeason(ArrayList<Integer> group1, ArrayList<Integer> group2)
  {
    int team1, team2;
    
    System.out.println("-------- TIP --------");
    if (group1.size() < 5)
      System.out.println("You have a small league. Teams will play each other multiple times. You may want to expand.");
    else if (group1.size() < 10)
      System.out.println("Your league is a manageable size. However, the playoffs may be boring. Use a double elimination bracket.");
    else
      System.out.println("Your league is pretty big. Some teams may not play each other.");
    System.out.println("---------------------");
      
    for (int i = 0; i < numGames; i++){
      for (int j = 0; j < (numTeams/2); j++){
        team1 = group1.get(j);
        team2 = group2.get(j); 
         Game teamA = roster.get(team1).playGame();
         Game teamB = roster.get(team2).playGame();
    
         if (teamA.getPoints() > teamB.getPoints()){
           teamA.setOutcome(true);
           roster.get(team1).addWin();
         }
         else 
           roster.get(team1).addLose();
    
         if (teamA.getPoints() < teamB.getPoints())
         {
           teamB.setOutcome(true);
           roster.get(team2).addWin();
         }
         else
           roster.get(team2).addLose();
    
         if (game > numTeams/2-1)
           resetGame(); 
         
    fullReport[week][game] = teamA.getPoints() + "-" + teamB.getPoints();
    game++;
  }  
      temp  = group2.remove(0);
      group2.add(group1.get(group1.size()-1));
      group1.remove(group1.size()-1);
      group1.add(1,temp);
    }
  }
   
  // reutrn the reprot 2D array
  public String[][] getFullReport()
  {
    return fullReport;
  }
  
  
  // starts a new week
  private void resetGame()
  {
    game = 0;
    week++;
  }
    
  
  // return the team object of specific location
  public Teams getTeam(int i)
  {
    return roster.get(i);
  }
  
  // rotate the group to get tge match up for certain weeks
  public void rotateGroups(int weekNum)
  {
    for (int i = 0; i < weekNum; i++)
    {
    temp  = group2.remove(0);
    group2.add(group1.get(group1.size()-1));
    group1.remove(group1.size()-1);
    group1.add(1,temp);
    }
  }
  
  // return group1 at its current possition.
  public ArrayList<Integer> getGroup1()
  {
    return group1;
  }
  
  // return group2 in its current state.
  public ArrayList<Integer> getGroup2()
  {
    return group2;
  }
  
  // return the name of specfici team  
  public String getName(int teamNum)
  {
    return roster.get(teamNum).getName();
  }
  
  
  public String toString()
  {
    String returner = "";
    
   for (int row = 0; row < numGames; row++)
    {
      returner += "\n****** WEEK " + (row+1) + " ******\n";
      for (int i = 0; i < numTeams/2; i++)
        returner += "Game: " + (i+1) + "\t";
      returner += "\n";
      for (int col = 0; col < fullReport[row].length; col++)
      returner += fullReport[row][col] + "\t";
      returner += "\n*******************\n";
   }  
      return returner;
  }
}
  
  
  
  
