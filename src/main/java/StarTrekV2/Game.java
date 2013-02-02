package StarTrekV2;

/**
 * Create energy source
 * Send energy hit to Subsystem
 * Subsystem checks energy level of the shield
 * 		If shield energy > 0, absorb the energy hit
 * 		If shield energy <= 0, send energy hit to Strategic subsystem
 * Check if shield energy = 0, deplete the shield
 * Check if the Strategic subsystem is damaged or not, report subsystem status
 * 
 * @author Agile Sprinters
 * @created 02/01/2013 
 */
public class Game {

	public Energy energySource = new Energy(10000);
	public Shield shield = new Shield(5000);
	
	/**
	 * @param subSystem
	 * @param energyHit
	 */
	public void hitStarship(
			int energyHit) 
	{
		
	}
}
