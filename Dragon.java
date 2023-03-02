/**  This class represents a Dragon object.
  *
  * @author Alex Rahaman
 */
public class Dragon
{
  
  /** This is the amount of health the dragon has */
  private int health;
  
  /** This is the amount of strength the dragon has */
  private int strength;
  
  /** This is the level of the dragon */
  private int level;
  
  /** This is whether the dragon is dead or not */
  private boolean dead;

  /** Initializes a Dragon object 
    * <p>
    * Sets the strength of a dragon randomly based on the dragon's level.
    *
   */
  public Dragon()
  {
    health = 100;
    level = (int) (Math.random() * 3) + 1;
    if (level == 3)
    {
      strength = (int) (Math.random() * 3) + 3;
    }
    else if (level == 2)
    {
      strength = (int) (Math.random() * 4) + 3;
    }
    else
    {
      strength = (int) (Math.random() * 6) + 5;
    }
    dead = false;
  }
  
  /** Resets the dragon object to its original values in the constructor. 
    *
    *
   */
  public void resetDragon()
  {
    health = 100;
    level = (int) (Math.random() * 3) + 1;
    if (level == 3)
    {
      strength = (int) (Math.random() * 3) + 3;
    }
    else if (level == 2)
    {
      strength = (int) (Math.random() * 4) + 3;
    }
    else
    {
      strength = (int) (Math.random() * 6) + 5;
    }
    dead = false;
  }
  
  /** Determines how much damage the dragon takes and prints out that value as well as the dragon's health.
    * <p>
    * If the dragon's health is 0 or falls below 0 after taking damage, the method sets the dead boolean
    * to be true, sets the dragon's health to 0, and prints that the dragon has been slayed.
    * <p>
    * If the dead boolean is true, the dragon does not take anymore damage, and the method prints that
    * the dragon has been killed.
    *
    * @param damage The amount of damage the dragon will take
   */
  public void takeDamage(int damage)
  {
    if (dead)
    {
      System.out.println("The dragon is already dead!");
    }
    else
    {
      health -= damage;
      if (health <= 0)
      {
        health = 0;
      }
      System.out.println("The dragon takes " + damage + " damage and now has " + health + " health.");
      if (health <= 0)
      {
        dead = true;
        System.out.println("The dragon has been slayed!");
      }
    }
  }
  
  /** Prints out the amount of damage that the dragon attacks for and returns that damage.
    *
    * @return The amount of damage that the dragon attacks for.
   */
  public int attack()
  {
    return strength * level;
  }
  
  /** When a dragon is slayed, decides which outcome out of four possible outcomes will occur.
    * <p>
    * There is a 1/3 chance for each outcome and the outcomes are either 
    * the player will heal a random amount of their health, the player will get an upgrade
    * for their sword stats, or the player will get nothing.
    *
    * @param player A player object 
   */
  public void slayOutcome(Player player)
  {
    if (dead)
    {
      int chance = (int) (Math.random() * 3) + 1;
      if (chance == 3)
      {
        player.getSword().upgradeSword();
      }
      else if (chance == 2)
      {
        int healing = (int) (Math.random() * 7) + 10;
        if ((player.getHealth() + healing) >= 100)
        {
          int healthTillMax = 100 - player.getHealth();
          player.heal(healthTillMax);
        }
        else
        {
          player.heal(healing);
        }
      }
      else
      {
        System.out.println("The dragon did not have any loot");
      }
    }
  }
  
  /** Returns the dragon's strength
    *
    * @return Dragon's strength
   */
  public int getStrength()
  {
    return strength;
  }
  
  /** Returns the dragon's health
    *
    * @return Dragon's health
   */
  public int getHealth()
  {
    return health;
  }
  
  /** Returns the dragon's level
    *
    * @return Dragon's level
   */
  public int getLevel()
  {
    return level;
  }
  
  /** Returns if the dragon is dead or not
    *
    * @return False or true depending on if dragon is alive or not
   */
  public boolean isDead()
  {
    return dead;
  }
}