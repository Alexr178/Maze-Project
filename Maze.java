/**  This class represents a Maze object.
  *
  * @author Alex Rahaman
 */

public class Maze
{
  //The 15x15 maze array for hard mode
  private Path[][] mazeConfigH = new Path[15][15];
  
  //The 9x9 maze array for normal mode
  private Path[][] mazeConfigN = new Path[9][9];
  
  //The 6x6 maze array for normal mode
  private Path[][] mazeConfigE = new Path[6][6];
  
  //Initializes a Maze object
  public Maze()
  {
    setMazeConfigE();
    setMazeConfigN();
    setMazeConfigH();
  }
  
  //Creates the mazes with their default values
  private void createMaze(Path[][] maze)
  {
    for (int r = 0; r < maze.length; r++)
    {
      for (int c = 0; c < maze[0].length; c++)
      {
        maze[r][c] = new Path(false);
      }
    }
    maze[0][0].setPath(true);
    maze[maze.length - 1][maze[0].length - 1].setPath(true);
    maze[0][0].setPathFound(true);
  }
  
  //Resets the maze at the end of the game
  public void resetMaze(Path[][] maze)
  {
    for (int r = 0; r < maze.length; r++)
    {
      for (int c = 0; c < maze[0].length; c++)
      {
        maze[r][c].setPathFound(false);
      }
    }
    setMazeConfigE();
    setMazeConfigN();
    setMazeConfigH();
  }
  
  //Sets up the maze configuration for easy mode
  private void setMazeConfigE()
  {
    createMaze(mazeConfigE);
    mazeConfigE[0][3].setPath(true);
    mazeConfigE[1][0].setPath(true);
    mazeConfigE[1][2].setPath(true);
    mazeConfigE[1][3].setPath(true);
    mazeConfigE[1][4].setPath(true);
    mazeConfigE[1][5].setPath(true);
    mazeConfigE[2][0].setPath(true);
    mazeConfigE[2][1].setPath(true);
    mazeConfigE[2][2].setPath(true);
    mazeConfigE[3][1].setPath(true);
    mazeConfigE[3][3].setPath(true);
    mazeConfigE[3][4].setPath(true);
    mazeConfigE[3][5].setPath(true);
    mazeConfigE[4][0].setPath(true);
    mazeConfigE[4][1].setPath(true);
    mazeConfigE[4][2].setPath(true);
    mazeConfigE[4][3].setPath(true);
    mazeConfigE[4][5].setPath(true);
    mazeConfigE[5][0].setPath(true);
    mazeConfigE[5][2].setPath(true);
  }
  
  //Sets up the maze configuration for normal mode
  private void setMazeConfigN()
  {
    createMaze(mazeConfigN);
    mazeConfigN[0][3].setPath(true);
    mazeConfigN[0][4].setPath(true);
    mazeConfigN[0][5].setPath(true);
    mazeConfigN[1][0].setPath(true);
    mazeConfigN[1][1].setPath(true);
    mazeConfigN[1][2].setPath(true);
    mazeConfigN[1][3].setPath(true);
    mazeConfigN[1][6].setPath(true);
    mazeConfigN[1][7].setPath(true);
    mazeConfigN[2][2].setPath(true);
    mazeConfigN[2][4].setPath(true);
    mazeConfigN[2][5].setPath(true);
    mazeConfigN[2][6].setPath(true);
    mazeConfigN[3][0].setPath(true);
    mazeConfigN[3][1].setPath(true);
    mazeConfigN[3][2].setPath(true);
    mazeConfigN[3][3].setPath(true);
    mazeConfigN[3][4].setPath(true);
    mazeConfigN[3][6].setPath(true);
    mazeConfigN[3][7].setPath(true);
    mazeConfigN[3][8].setPath(true);
    mazeConfigN[4][0].setPath(true);
    mazeConfigN[4][6].setPath(true);
    mazeConfigN[4][8].setPath(true);
    mazeConfigN[5][0].setPath(true);
    mazeConfigN[5][1].setPath(true);
    mazeConfigN[5][4].setPath(true);
    mazeConfigN[5][5].setPath(true);
    mazeConfigN[5][6].setPath(true);
    mazeConfigN[5][8].setPath(true);
    mazeConfigN[6][1].setPath(true);
    mazeConfigN[6][5].setPath(true);
    mazeConfigN[7][1].setPath(true);
    mazeConfigN[7][2].setPath(true);
    mazeConfigN[7][3].setPath(true);
    mazeConfigN[7][5].setPath(true);
    mazeConfigN[7][6].setPath(true);
    mazeConfigN[7][7].setPath(true);
    mazeConfigN[7][8].setPath(true);
    mazeConfigN[8][1].setPath(true);
    mazeConfigN[8][6].setPath(true);
  }
  
  //Sets up the maze configuration for hard mode
  private void setMazeConfigH()
  {
    createMaze(mazeConfigH);
    mazeConfigH[0][2].setPath(true);
    mazeConfigH[0][3].setPath(true);
    mazeConfigH[0][4].setPath(true);
    mazeConfigH[0][5].setPath(true);
    mazeConfigH[0][6].setPath(true);
    mazeConfigH[0][7].setPath(true);
    mazeConfigH[0][8].setPath(true);
    mazeConfigH[0][9].setPath(true);
    mazeConfigH[0][10].setPath(true);
    mazeConfigH[0][13].setPath(true);
    mazeConfigH[1][0].setPath(true);
    mazeConfigH[1][1].setPath(true);
    mazeConfigH[1][2].setPath(true);
    mazeConfigH[1][5].setPath(true);
    mazeConfigH[1][7].setPath(true);
    mazeConfigH[1][9].setPath(true);
    mazeConfigH[1][12].setPath(true);
    mazeConfigH[1][13].setPath(true);
    mazeConfigH[2][2].setPath(true);
    mazeConfigH[2][4].setPath(true);
    mazeConfigH[2][5].setPath(true);
    mazeConfigH[2][9].setPath(true);
    mazeConfigH[2][10].setPath(true);
    mazeConfigH[2][11].setPath(true);
    mazeConfigH[2][12].setPath(true);
    mazeConfigH[3][2].setPath(true);
    mazeConfigH[3][4].setPath(true);
    mazeConfigH[3][12].setPath(true);
    mazeConfigH[3][13].setPath(true);
    mazeConfigH[3][14].setPath(true);
    mazeConfigH[4][3].setPath(true);
    mazeConfigH[4][4].setPath(true);
    mazeConfigH[4][8].setPath(true);
    mazeConfigH[4][9].setPath(true);
    mazeConfigH[4][10].setPath(true);
    mazeConfigH[4][12].setPath(true);
    mazeConfigH[5][2].setPath(true);
    mazeConfigH[5][3].setPath(true);
    mazeConfigH[5][6].setPath(true);
    mazeConfigH[5][7].setPath(true);
    mazeConfigH[5][8].setPath(true);
    mazeConfigH[5][10].setPath(true);
    mazeConfigH[5][12].setPath(true);
    mazeConfigH[5][13].setPath(true);
    mazeConfigH[6][2].setPath(true);
    mazeConfigH[6][5].setPath(true);
    mazeConfigH[6][6].setPath(true);
    mazeConfigH[6][8].setPath(true);
    mazeConfigH[6][10].setPath(true);
    mazeConfigH[6][11].setPath(true);
    mazeConfigH[6][13].setPath(true);
    mazeConfigH[7][0].setPath(true);
    mazeConfigH[7][1].setPath(true);
    mazeConfigH[7][2].setPath(true);
    mazeConfigH[7][3].setPath(true);
    mazeConfigH[7][4].setPath(true);
    mazeConfigH[7][5].setPath(true);
    mazeConfigH[7][8].setPath(true);
    mazeConfigH[7][11].setPath(true);
    mazeConfigH[7][13].setPath(true);
    mazeConfigH[7][14].setPath(true);
    mazeConfigH[8][0].setPath(true);
    mazeConfigH[8][10].setPath(true);
    mazeConfigH[8][11].setPath(true);
    mazeConfigH[8][14].setPath(true);
    mazeConfigH[9][0].setPath(true);
    mazeConfigH[9][2].setPath(true);
    mazeConfigH[9][3].setPath(true);
    mazeConfigH[9][4].setPath(true);
    mazeConfigH[9][6].setPath(true);
    mazeConfigH[9][7].setPath(true);
    mazeConfigH[9][8].setPath(true);
    mazeConfigH[9][9].setPath(true);
    mazeConfigH[9][10].setPath(true);
    mazeConfigH[9][14].setPath(true);
    mazeConfigH[10][2].setPath(true);
    mazeConfigH[10][4].setPath(true);
    mazeConfigH[10][5].setPath(true);
    mazeConfigH[10][6].setPath(true);
    mazeConfigH[10][12].setPath(true);
    mazeConfigH[10][13].setPath(true);
    mazeConfigH[10][14].setPath(true);
    mazeConfigH[11][2].setPath(true);
    mazeConfigH[11][3].setPath(true);
    mazeConfigH[11][9].setPath(true);
    mazeConfigH[11][10].setPath(true);
    mazeConfigH[11][11].setPath(true);
    mazeConfigH[11][12].setPath(true);
    mazeConfigH[12][3].setPath(true);
    mazeConfigH[12][5].setPath(true);
    mazeConfigH[12][6].setPath(true);
    mazeConfigH[12][7].setPath(true);
    mazeConfigH[12][11].setPath(true);
    mazeConfigH[13][1].setPath(true);
    mazeConfigH[13][2].setPath(true);
    mazeConfigH[13][3].setPath(true);
    mazeConfigH[13][4].setPath(true);
    mazeConfigH[13][5].setPath(true);
    mazeConfigH[13][9].setPath(true);
    mazeConfigH[13][10].setPath(true);
    mazeConfigH[13][11].setPath(true);
    mazeConfigH[13][12].setPath(true);
    mazeConfigH[13][13].setPath(true);
    mazeConfigH[14][1].setPath(true);
    mazeConfigH[14][13].setPath(true);
  }
  
  //Gets the maze config for easy mode
  public Path[][] getMazeConfigE()
  {
    return mazeConfigE;
  }
  
  //Gets the maze config for normal mode
  public Path[][] getMazeConfigN()
  {
    return mazeConfigN;
  }
  
  //Gets the maze config for hard mode
  public Path[][] getMazeConfigH()
  {
    return mazeConfigH;
  }
}