/**  This class represents a Player object.
  *
  * @author Alex Rahaman
 */
 
public class Player
{
  
  /** This is the player's name */
  private String name;
  
  //The player's row position
  private int row;
  
  //The player's previous row position
  private int lastRow;
  
  //The player's column position
  private int col;
  
  //The player's previous column position
  private int lastCol;
  
  /** This is the player's health */
  private int health;
  
  /** This is whether or not the player is dead */
  private boolean dead;
  
  /** This is a sword object for the player */
  private Sword sword = new Sword();
  
  /** Initializes a player object.
    * 
    * @param name Player's name
   */ 
  public Player(String name)
  {
    this.name = name;
    row = 0;
    col = 0;
    lastRow = row;
    lastCol = col;
    health = 125;
    dead = false;
  }
  
  //Moves the player down in the maze
  public void moveDown()
  {
    lastRow = row;
    lastCol = col;
    row++;
  }
  
  //Moves the player up in the maze
  public void moveUp()
  {
    lastRow = row;
    lastCol = col;
    row--;
  }
  
  //Moves the player to the right in the maze
  public void moveRight()
  {
    lastCol = col;
    lastRow = row;
    col++;
  }
  
  //Moves the player to the left in the maze
  public void moveLeft()
  {
    lastCol = col;
    lastRow = row;
    col--;
  }
  
  //Moves the player back to their previous position in the maze
  public boolean moveBack()
  {
    if (lastRow == row && lastCol == col)
    {
      return false;
    }
    else
    {
      row = lastRow;
      col = lastCol;
      return true;
    }
  }
  
  //Gets the player's first initial from their name to use as a symbol in the maze
  public String getInitial()
  {
    return name.substring(0, 1);
  }
  
  //Gets the player's row position
  public int getRow()
  {
    return row;
  }
  
  //Gets the player's column position
  public int getCol()
  {
    return col;
  }
  
  //Gets the player's previous row position
  public int getLastRow()
  {
    return lastRow;
  }
  
  //Gets the player's previous column position
  public int getLastCol()
  {
    return lastCol;
  }
  
  /** Resets the player object to its original values in the constuctor.
    * 
    * 
   */ 
  public void resetPlayer()
  {
    dead = false;
    health = 125;
    row = 0;
    col = 0;
    lastRow = 0;
    lastCol = 0;
    sword = new Sword();
  }
  
  /** Returns a value for the damage the player will deal based on the attack
    * power of the player's sword and a random multiplier.
    * 
    * @return Amount of attack damage
   */ 
  public int attack()
  {
    return sword.getAttackPower() * ((int) (Math.random() * 5) + 1);
  }
  
  /** Reduces the health of the player based on the damage that was dealt
    * to the player by the dragon.
    * <p>
    * Prints out the amount of damage the player took and if the player dodges
    * then the player takes no damage.
    * 
    * @param damage Damage dealt to player
   */ 
  public void takeDamage(int damage)
  {
    int chance = (int) (Math.random() * 100) + 1;
    if (chance > sword.getDodgeRating())
    { 
      health -= damage;
      if (health <= 0)
      {
        dead = true;
        health = 0;
        System.out.println("You took " + damage + " damage and you now have " + health + " health remaining.");
      }
      else
      {
        System.out.println("You took " + damage + " damage and you now have " + health + " health remaining.");
      }
    }
    else
    {
      System.out.println("You dodged the dragon's attack!");
    }
  }
  
  /** Heals the player's health by a specific amount.
    * 
    * @param healthAmount Amount of health being healed
   */ 
  public void heal(int healthAmount)
  {
    health += healthAmount;
    System.out.println("You healed " + healthAmount + " health and now have " + health + " health.");
  }
  
  /** Returns the player's health
    * 
    * @return Player's health
   */ 
  public int getHealth()
  {
    return health;  
  }
  
  /** Returns whether or not the player is dead.
    * 
    * @return Whether or not the player is dead
   */ 
  public boolean isDead()
  {
    return dead;
  }
  
  /** Returns the player's sword object
    * 
    * @return Sword object
   */ 
  public Sword getSword()
  {
    return sword;  
  }
  
  /** Checks the player's overall stats for health and sword stats.
    * 
    * 
   */   
  public void checkOverallStats()
  {
    System.out.println("You currently have " + health + " health.");
    System.out.println("You also have " + sword.getAttackPower() + " attack power and " + sword.getDodgeRating() + " dodge rating on your sword.");
  }
}