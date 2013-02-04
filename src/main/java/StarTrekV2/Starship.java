package StarTrekV2;

import java.util.ArrayList;
import java.util.List;

public class Starship {

	public Shield shield = new Shield(5000);
	public List<Subsytem> subSystems;
	
	public Starship() {
		subSystems = new ArrayList<Subsytem>();
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
	public void hitStarship(
			int energyHit) 
	{
		int unabsorbedEnergy = energyHit;

		if (!shield.isDepleted()) {
		// Hit shield first
			unabsorbedEnergy = shield.absorb(energyHit);
		}

		if (unabsorbedEnergy > 0) {
			// Distribute unabsorbed energy evenly between subsytems
			int unabsorbedEnergyPerSubsystem = unabsorbedEnergy / subSystems.size();
			for (Subsytem subSystem : subSystems) {
				subSystem.takeDamage(unabsorbedEnergyPerSubsystem);
				if (unabsorbedEnergy == 0) {
					break;
				}
			}
		}
	}
}
