package StarTrekV2;

public abstract class Subsytem {

	private int damage = 0;
	private int strengthAspect = 1;

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
}
