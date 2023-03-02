/**  This class represents a MazeGame object.
  *
  * @author Alex Rahaman
 */

import java.util.Scanner;

public class MazeGame
{
  //Initializes the maze object
  private Maze maze = new Maze();
  
  //Stores the maze config for easy mode
  private Path[][] mazeE = maze.getMazeConfigE();
  
  //Stores the maze config for normal mode 
  private Path[][] mazeN = maze.getMazeConfigN();
  
  //Stores the maze config for hard mode
  private Path[][] mazeH = maze.getMazeConfigH();
  
  //Keeps the main maze used in each game
  private Path[][] mainMaze;
  
  //Stores the dragon array for easy mode
  private Dragon[] dragonArrE = new Dragon[6];
  
  //Stores the dragon array for normal mode
  private Dragon[] dragonArrN = new Dragon[9];
  
  //Stores the dragon array for hard mode
  private Dragon[] dragonArrH = new Dragon[13];
  
  //Keeps the main dragon array used in each game
  private Dragon[] mainDragArr;
  
  //Scanner object
  private Scanner scan = new Scanner(System.in);
  
  //The player object
  private Player player;
  
  //Player's name
  private String name;
  
  //Player's first initial
  private String initial;
  private boolean playAgain;
  private String difficulty;
  private boolean endReached;
  
  //Initializes a MazeGame object
  public MazeGame(){}
  
  
  //The play method to play the game
  public void play()
  {
    playAgain = true;
    welcome();
    while (playAgain)
    {
      start();
      int maxRow = mainMaze.length - 1;
      int maxCol = mainMaze[0].length - 1;
      endReached = false;
      while (!endReached)
      {
        int pRow = player.getRow();
        int pCol = player.getCol();
        if (pRow == maxRow && pCol == maxCol)
        {
          gameEnd();
          break;
        }
        System.out.println("Where do you want to move?:");
        checkPaths();
        makeMove();
        if (endReached)
        {
          break;
        }
        displayMaze(mainMaze);
      }
    }
  }
  
  //Method to organize the start of the game each time it loops after you play again
  public void start()
  {
    System.out.print("What difficulty do you want to choose for your maze? (E)asy, (N)ormal, or (H)ard: ");
    difficulty = scan.nextLine().toLowerCase();
    if (difficulty.equals("e"))
    {
      mainMaze = mazeE;
      mainDragArr = dragonArrE;
    }
    else if (difficulty.equals("n"))
    {
      mainMaze = mazeN;
      mainDragArr = dragonArrN;
    }
    else if (difficulty.equals("h"))
    {
      mainMaze = mazeH;
      mainDragArr = dragonArrH;
    }
    else
    {
      System.out.println("Please try again with the right input");
      while (!(difficulty.equals("e") || difficulty.equals("n") || difficulty.equals("h")))
      {
        difficulty = scan.nextLine().toLowerCase();
        if (difficulty.equals("e"))
        {
          mainMaze = mazeE;
          mainDragArr = dragonArrE;
        }
        else if (difficulty.equals("n"))
        {
          mainMaze = mazeN;
          mainDragArr = dragonArrN;
        }
        else if (difficulty.equals("h"))
        {
          mainMaze = mazeH;
          mainDragArr = dragonArrH;
        }
      }
    }
    initializeDragArr();
    displayMaze(mainMaze);
  }
  
  //Method to welcome the player and organize the details before the game loops
  public void welcome()
  {
    System.out.println("Welcome to the Maze Runner Game!");
    System.out.println("In this game you can choose to go through three different\nmazes of ascending difficulty.");
    System.out.println("The paths inside the mazes are all hidden and are only shown\nwhen you reach them.");
    System.out.println("You will enter the maze from the top left of the maze, and your\nobjective is to find a path to escape through the bottom right exit of the maze.");
    System.out.println("-- Beware every time you have to move back to where you came from, you will\nbe confronted by a dragon and will have to slay it to continue. Good luck!");
    System.out.println();
    System.out.print("What is your name? ");
    name = scan.nextLine();
    player = new Player(name);
    initial = player.getInitial().toUpperCase();
  }
  
  //Method to organize the ending sequence of the game to ask the player if they will play again or not and to potentially reset the game
  public void gameEnd()
  {
    System.out.print("Congratulations! You reached the end of the maze and have escaped.\nWill you play again? (Y)es or (N)o: ");
    endReached = true;
    String choice = scan.nextLine().toLowerCase();
    if (choice.equals("y"))
    {
      resetGame();
    }
    else if (choice.equals("n"))
    {
      playAgain = false;
    }
    else
    {
      System.out.println("Please try again with the right input");
      while (!(choice.equals("y") || choice.equals("n")))
      {
        System.out.print("Do you want to play again? (Y)es or (N)o: ");
        choice = scan.nextLine().toLowerCase();
        if (choice.equals("y"))
        {
          resetGame();
        }
        else if (choice.equals("n"))
        {
          playAgain = false;
        }
      }
    }
  }
  
  //Resets the game so it can be played again normally
  private void resetGame()
  {
    maze.resetMaze(mainMaze);
    player.resetPlayer();
  } 
  
  //Checks the available paths in the maze to give proper available directions to the player
  public void checkPaths()
  {
    if (checkDownPath())
    {
      System.out.println("Will you move (d)own?");
    }
    if (checkUpPath())
    {
      System.out.println("Will you move (u)p?");
    }
    if (checkRightPath())
    {
      System.out.println("Will you move (r)ight?");
    }
    if (checkLeftPath())
    {
      System.out.println("Will you move (l)eft?");
    }
    if (!(player.getRow() == 0 & player.getCol() == 0))
    {
      System.out.println("Will you move (b)ack to where you came from?");
    }
    System.out.print("Move: ");
  }
  
  //Initializes the dragons in the dragon array
  public void initializeDragArr()
  {
    for (int i = 0; i < mainDragArr.length; i++)
    {
      mainDragArr[i] = new Dragon();
    }
  }
  
  //Checks if there are dragons available and which dragon is confronting the player
  public Dragon activeDragon()
  {
    for (Dragon dragon : mainDragArr)
    {
      if (!(dragon.isDead()))
      {
        return dragon;
      }
    }
    return null;
  }
  
  //Makes the player move in the maze based on the player's choice if it is valid
  //Makes the player fight a dragon, if there are dragons that are alive, whenever they choose to move backwards
  public void makeMove()
  {
    String choice = scan.nextLine().toLowerCase();
    if (choice.equals("d") && checkDownPath())
    {
      player.moveDown();
    }
    else if (choice.equals("u") && checkUpPath())
    {
      player.moveUp();
    }
    else if (choice.equals("r") && checkRightPath())
    {
      player.moveRight();
    }
    else if (choice.equals("l") && checkLeftPath())
    {
      player.moveLeft();
    }
    else if (choice.equals("b") && !(player.getRow() == 0 & player.getCol() == 0))
    {
      boolean flag = player.moveBack();
      System.out.println();
      if (!(activeDragon() == null) && flag)
      {
        System.out.println("You are confronted by a dragon for moving back!");
        dragonEncounter();
      }
      else if (activeDragon() == null)
      {
        System.out.println("All dragons have been slayed. You can move back freely now.");
      }
      else
      {
        System.out.println("Please choose another option.");
      }
    }
    mainMaze[player.getRow()][player.getCol()].setPathFound(true);
  }
  
  //Method to organize the situation where the player encounters the dragon
  public void dragonEncounter()
  {
    Dragon activeDragon = activeDragon();
    while(!(activeDragon.isDead()) && !(endReached))
    { 
      System.out.println("Whats your next move?\n(A)ttack!\n(C)heck overall stats");
      String choice = scan.nextLine().toLowerCase();
      System.out.println();
      if (choice.equals("a"))
      {
        attackSequence();
      }
      else if (choice.equals("c"))
      {
        player.checkOverallStats();
      }
      else
      {
        System.out.println("Please try again with the right input");
      }
    }
  }
  
  //Taken and adjusted from my DragonSlayer project to add some action**
  /** Plays out the attack sequence of the battle between the player
    * and the dragon.
    * <p>
    * If the player is killed by a dragon, the game ends and the player
    * is asked if they would like to play again.
    *
   */
  public void attackSequence()
  {
    Scanner scan = new Scanner(System.in);
    Dragon activeDragon = activeDragon();
    int dmg = 0;
    if (!(activeDragon.isDead()))
    {
      dmg = player.attack();
      activeDragon.takeDamage(dmg);
      activeDragon.slayOutcome(player);
      if (!(activeDragon.isDead()))
      {
        dmg = activeDragon.attack();
        player.takeDamage(dmg);
        if (player.isDead())
        {
          System.out.println("The dragon has killed you. Game over.");
          endReached = true;
          System.out.print("Do you want to play again? (Y)es or (N)o: ");
          String choice = scan.nextLine().toLowerCase();
          if (choice.equals("y"))
          {
            resetGame();
          }
          else if (choice.equals("n"))
          {
            playAgain = false;
          }
          else
          {
           System.out.println("Please try again with the right input");
           while (!(choice.equals("y") || choice.equals("n")))
            {
              System.out.print("Do you want to play again? (Y)es or (N)o: ");
              choice = scan.nextLine().toLowerCase();
              if (choice.equals("y"))
              {
                resetGame();
              }
              else if (choice.equals("n"))
              {
                playAgain = false;
                break;
              }
            }
          }
        }
      }
    }
  }

  //Checks whether the path downwards is available
  public boolean checkDownPath()
  {
    int r = player.getRow() + 1;
    int c = player.getCol();
    if ((r - 1) == 0 && c == 0)
    {
      return true;
    }
    if (r < 0 || r > mainMaze.length - 1 || c < 0 || c > mainMaze[0].length - 1 || r == player.getLastRow())
    {
      return false;
    }
    if (mainMaze[r][c].isOpenPath())
    {
      return true;
    }
    return false;
  }
  
  //Checks whether the path upwards is available
  public boolean checkUpPath()
  {
    int r = player.getRow() - 1;
    int c = player.getCol();
    if (r < 0 || r > mainMaze.length - 1 || c < 0 || c > mainMaze[0].length - 1 || r == player.getLastRow())
    {
      return false;
    }
    if (mainMaze[r][c].isOpenPath())
    {
      return true;
    }
    return false;
  }
  
  //Checks whether the path to the right is available
  public boolean checkRightPath()
  {
    int r = player.getRow();
    int c = player.getCol() + 1;
    if (r < 0 || r > mainMaze.length - 1 || c < 0 || c > mainMaze[0].length - 1 || c == player.getLastCol())
    {
      return false;
    }
    if (mainMaze[r][c].isOpenPath())
    {
      return true;
    }
    return false;
  }
  
  //Checks whether the path to the left is available
  public boolean checkLeftPath()
  {
    int r = player.getRow();
    int c = player.getCol() - 1;
    if (r < 0 || r > mainMaze.length - 1 || c < 0 || c > mainMaze[0].length - 1 || c == player.getLastCol())
    {
      return false;
    }
    if (mainMaze[r][c].isOpenPath())
    {
      return true;
    }
    return false;
  }
  
  //Displays the maze and adjusts the display based on which paths are found
  public void displayMaze(Path[][] maze)
  {
    System.out.println();
    int pRow = player.getRow();
    int pCol = player.getCol();
    for (int r = 0; r < maze.length; r++)
    {
      for (int c = 0; c < maze[0].length; c++)
      {
        if (pRow == r & pCol == c)
        {
          System.out.print("[" + initial + "]");
        }
        else if (r == maze.length - 1 & c == maze[0].length - 1)
        {
          System.out.print("[X] <--- End");
        } 
        else if (maze[r][c].isPathFound())
        {
          System.out.print("[X]");
        }
        else
        {
          System.out.print("[ ]");
        }
      }
      System.out.println();
    }
  }
}