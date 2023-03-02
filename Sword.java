/**  This class represents a Sword object.
  *
  * @author Alex Rahaman
 */

public class Sword
{
  /** This is the attack power of the sword  */
  private int attackPower;
  
  /** This is the dodge rating of the sword */
  private int dodgeRating;
  
  /** Initializes a sword object 
    *
    *
   */
  public Sword()
  {
    attackPower = 10;
    dodgeRating = 20;
  }
  
  /** Upgrades either the attack power or the dodge rating of the sword by 5 randomly.
    * 
    * 
   */ 
  public void upgradeSword()
  {
    int chance = (int) (Math.random() * 5) + 1;
    if (chance >= 3)
    {
      attackPower += 5;
      System.out.println("Your sword was upgrade to have 5 more attack power, and it now has " + attackPower + " attack power.");
    }
    else
    {
      dodgeRating += 5;
      System.out.println("Your sword was upgrade to have 5 more dodge rating, and it now has " + dodgeRating + " dodge rating.");
    }
  }
  
  /** Returns the attack power of the sword.
    * 
    * @return Sword's attack power
   */ 
  public int getAttackPower()
  {
    return attackPower;
  }
  
  /** Returns the dodge rating of the sword.
    * 
    * @return Sword's dodge rating
   */
  public int getDodgeRating()
  {
    return dodgeRating;
  }
}