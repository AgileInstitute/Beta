package StarTrekV2;

public class Shield extends Subsytem {

	private boolean activated = true;
	
	public Shield(
			int initialEnergy) 
	{
		super(initialEnergy);
	}

	public boolean isActivated() {
		return activated;
	}
	
	public void deplete() {
		activated = false;
	}
	
	@Override
	public int hit(int energyHit) {
		if (activated) {
			int remainingEnergy = super.hit(energyHit);
			if (remainingEnergy <= 0) {
				// Deplete shield
				deplete();
			}
			return remainingEnergy;
		}
		return -energyHit;
	}
}
