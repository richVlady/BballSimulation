//**********************
//  AP CSP NBA simulation
//  Richard Vlady
// simulate an NBC season according to the factors of the user
// Object file game
//*********************

public class Game
{
  private int points, assists, rebounds, week, game, teamNumber;
  private boolean outcome;
  private String result, name;
  
  
  public Game(int score, int assistsA, int reboundsA,int gameA, String teamName)
  {
    points = score;
    assists = assistsA;
    rebounds = reboundsA;
    game = gameA;
    outcome = false;
    name = teamName;
  }
  
  // used to set the outcome of the game in other files 
  public void setOutcome(boolean result)
  {
    outcome = result;
  }
  
  // return the outcome of the game
  public boolean getOutcome()
  {
    return outcome;
  }
  
  // return the points that the team scored in the game
  public int getPoints()
  {
    return points;
  }
  
  
  public String toString()
  {
    String returner;
    
    if (outcome)
      result = "winner";
    else
      result = "loser";
    returner = name + "(" + result + ")";
    returner += "\nPoints: " + points + "\nAssists: " + assists + "\nRebounds: " + rebounds;
    
    return returner;
  }
}
