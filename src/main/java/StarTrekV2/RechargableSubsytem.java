package StarTrekV2;

public abstract class RechargableSubsytem extends Subsystem {

	private int energy;

	public RechargableSubsytem(
			int initialEnergy)
	{
		energy= initialEnergy;
	}
	
	public int getEnergy() {
		return energy;
	}

	public void recharge(
			int extraEnergy) 
	{
		energy += extraEnergy;
	}
	
	public void discharge(
			int energyCharge) 
	{
		energy -= energyCharge;
	}
}
