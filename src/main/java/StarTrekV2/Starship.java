package StarTrekV2;

import java.util.ArrayList;
import java.util.List;

public class Starship {

	private Shield shield = new Shield(5000);
	private List<StrategicSubsytem> subSystems;
	
	public Starship() {
		subSystems = new ArrayList<StrategicSubsytem>();
		subSystems.add(new Engine(5000));
		subSystems.add(new Weapon(5000));
		subSystems.add(new LifeSupport(5000));
	}

	/**
	 * Subsystem checks energy level of the shield
	 * 		If shield energy > 0, absorb the energy hit
	 * 		If shield energy <= 0, send energy hit to Strategic subsystem
	 * Check if shield energy = 0, deplete the shield
	 * Check if the Strategic subsystem is damaged or not, report subsystem status
	 * 
	 * @param energyHit
	 */
	public void hitStarship(int energyHit) {
		// Hit shield first
		int remainingEnergy = shield.hit(energyHit);
		if (remainingEnergy < 0) {
			for (StrategicSubsytem subSystem : subSystems) {
				remainingEnergy = subSystem.hit(-remainingEnergy);
				if (remainingEnergy == 0) {
					break;
				}
			}
		}
	}
}
