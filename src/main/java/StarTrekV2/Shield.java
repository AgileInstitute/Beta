package StarTrekV2;

public class Shield extends RechargableSubsytem {

	public Shield(
			int initialEnergy) 
	{
		super(initialEnergy);
	}

	public boolean isDepleted() {
		return (getEnergy() == 0);
	}
	
	@Override
	public void takeDamage(
			int energyHit) 
	{
		// Shield cannot be damaged. If depleted, it does not absorb any energy
	}

	/**
	 * Returns un-absorbed energy
	 * 
	 * @param energyHit
	 * @return
	 */
	public int absorb(
			int energyHit) 
	{
		if (energyHit <= getEnergy()) {
			// Absorb entire hit
			discharge(energyHit);
			return 0;
		}
		else {
			// Absorb hit partially
			int unabsorbedEnergy = energyHit - getEnergy();
			discharge(getEnergy());
			return unabsorbedEnergy;
		}
	}
}
