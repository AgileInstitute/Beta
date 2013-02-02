package StarTrekV2;

public abstract class Subsytem {

	protected int energy;
	protected boolean damaged = false;
	
	public Subsytem(
			int initialEnergy) 
	{
		energy = initialEnergy;
	}

	public boolean isDamaged() {
		return damaged;
	}
	
	public int getEnergy() {
		return energy;
	}
	
	public int hit(
			int energyHit) 
	{
		int remainingEnergy = energy - energyHit;

		if (remainingEnergy > 0) {
			// Absorb energy
			energy = remainingEnergy;
		}
		else {
			energy = 0;
			damaged = true;
		}
		
		return remainingEnergy;
	}
}
