package StarTrekV2;

public class Energy {
	
	private int energyLevel;
	
	public Energy(int initialEnergy) {
		energyLevel = initialEnergy;
	}
	
	public void refill(int energy) {
		energyLevel += energy;
	}

	public int discharge(int energy) {
		int energyLeft = energyLevel - energy;
		if (energyLeft < 0) {
			energyLevel = 0;
		}
		else {
			energyLevel = energyLeft;
			energyLeft = 0;
		}
		return -energyLeft;
	}
}
