/**  This class represents a Path object.
  *
  * @author Alex Rahaman
 */

public class Path
{
  //Whether the path in the maze is open or not
  private boolean openPath;
  
  //Whether the path in the maze has been found or not
  private boolean pathFound;
  
  //Initializes a Path object
  public Path(boolean openPath)
  {
    this.openPath = openPath;
    pathFound = false;
  }
  
  //Gets if the path is open
  public boolean isOpenPath()
  {
    return openPath;
  }
  
  //Gets if the path has been found
  public boolean isPathFound()
  {
    return pathFound;
  }
  
  //Sets the path to be open or closed
  public void setPath(boolean type)
  {
    openPath = type;
  }
  
  //Sets the path to be found or unexplored
  public void setPathFound(boolean found)
  {
    pathFound = found;
  }
}