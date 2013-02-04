package StarTrekV2;

public abstract class Subsystem {

	private int damage = 0;

	private int strengthAspect = 100;
	private int repairTimePerDamageUnit = 3;
	private int repairableDamageThreshold = 1000;

	public Subsystem() {
	}

	public Subsystem(
			int strength)
	{
		strengthAspect = strength;
	}

	public boolean isDamaged() {
		return (damage > 0);
	}

	public void takeDamage(
			int energyHit) 
	{
		damage += (energyHit / strengthAspect);
	}

	public boolean isRepairable() {
		if (isDamaged()) {
			return (damage <= repairableDamageThreshold);
		}
		return true;
	}

	public int timeToRepir() {
		return (damage / repairTimePerDamageUnit);
	}
	
	public void repair(int repairEnergy) {
		damage -= repairEnergy;
		if (damage < 0) {
			damage = 0;
		}
	}
}
