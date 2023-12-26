//**********************
//  AP CSP NBA simulation
//  Richard Vlady
// simulate an NBC season according to the factors of the user
// Object file team
//*********************

import java.util.ArrayList;
import java.text.DecimalFormat;

public class Teams 
{
  private int gameNumber, wins, loses, teamNumber;
  private double avgPoints = 0.0, avgAssists = 0.0, avgRebounds = 0.0;
  private String name;
  private Game match;
  private ArrayList<Game> season;
  
  DecimalFormat round = new DecimalFormat("0.##");
  
  // constructor
  public Teams(String team, int number)
  {
    name = team;
    teamNumber = number;
    season = new ArrayList<Game>();
    gameNumber = 0;
  }
  
  // Method to play a game and random the stats
  public Game playGame()
  {
    int points = (int) (Math.random()*70+60);
    int assists = (int) (Math.random()*20+5);
    int rebounds = (int) (Math.random()*20+5);
    
    
    match = new Game(points, assists, rebounds, gameNumber, name);
    gameNumber++;
    avgPoints += points;
    avgAssists += assists;
    avgRebounds += rebounds;
    
    season.add(match);
    
    return match;
  }
  
  // add a win
  public void addWin()
  {
    wins++;
  }
  
  // add a lose
  public void addLose()
  {
    loses++;
  }
  
 
  // return avg points through season
  public double getAvgPoints()
  {
    return avgPoints/gameNumber;
  }
  
  // return average assists
  public double getAvgAssists()
  {
    return avgAssists/gameNumber;
  }
  
  // return average rebounds 
  public double getAvgRebounds()
  {
    return avgRebounds/gameNumber;
  }
  
  // return the game object of a specific game 
  public Game getGame(int i)
  {
    return season.get(i);
  }
  
  // return the team number 
  public int getTeamNumber()
  {
    return teamNumber;
  }
  
  //team the team name 
  public String getName()
  {
    return name;
  }
  
  // to string method
  public String toString()
  {
    String returner;
    
    returner = "\n************************";
    returner += "\n\t" + name + "\nWins: " + wins + "\nLoses: " + loses;
    returner += "\n\tAverages \nPoints: " + round.format(getAvgPoints()) + "\nAssists: " + round.format(getAvgAssists());
    returner += "\nRebounds: " + round.format(getAvgRebounds());
    returner += "\n**********************";
    
    return returner;
  }
}
    
