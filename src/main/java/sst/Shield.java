package sst;

public class Shield {
	private int energyLevel = 0;
	static public int _MAX_SHIELD_ENERGY = 10000;

	public Shield() {
		energyLevel = 0;
	}
	
	public Shield(int initialEnergy) {
		energyLevel = initialEnergy;
	}
	
	public void transferEnergy(int energy) {
		energyLevel += energy;
		if (energyLevel > _MAX_SHIELD_ENERGY) {
			energyLevel = _MAX_SHIELD_ENERGY;
		}
		if (energyLevel < 0) {
			energyLevel = 0;
		}
	}
	
	public int getEnergyLevel() {
		return energyLevel;
	}
}
