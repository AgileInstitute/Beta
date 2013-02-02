package StarTrekV2;

public abstract class Subsytem {

	protected int energy;
	protected boolean damage = false;
	
	public Subsytem(
			int initialEnergy) 
	{
		energy = initialEnergy;
	}

	public int hit(int energyHit) {
		int remainingEnergy = energy - energyHit;

		if (remainingEnergy > 0) {
			// Absort energy
			energy = remainingEnergy;
		}
		else {
			energy = 0;
			damage = true;
		}
		
		return remainingEnergy;
	}
}
