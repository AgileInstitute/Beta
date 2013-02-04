package StarTrekV2;

public abstract class Subsytem {

	private int damage = 0;

	private int strengthAspect = 100;
	private int repareTimePerDamageUnit = 3;
	private int reparableDamageThreshold = 1000;

	public Subsytem() {
	}

	public Subsytem(
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

	public boolean isReparable() {
		if (isDamaged()) {
			return (damage <= reparableDamageThreshold);
		}
		return true;
	}

	public int timeToRepare() {
		return (damage / repareTimePerDamageUnit);
	}
	
	public void recharge() {
		// TODO
	}
}
