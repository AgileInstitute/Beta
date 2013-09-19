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
	
	/**
	 * @param energy to transfer to shields
	 * @return amount of energy that wasn't transferred to shields
	 */
	public int transferEnergy(int energy) {
		int remainingEnergy = 0;
		energyLevel += energy;
		if (energyLevel > _MAX_SHIELD_ENERGY) {
			remainingEnergy = energyLevel - _MAX_SHIELD_ENERGY;
			energyLevel = _MAX_SHIELD_ENERGY;
		}
		if (energyLevel < 0) {
			remainingEnergy = energyLevel;
			energyLevel = 0;
		}
		return remainingEnergy;
	}
	
	public int takeDamage(int damage) {
		int overflow = 0;
		if (damage > energyLevel) {
			overflow = damage - energyLevel;
			energyLevel = 0;
		} else {
			energyLevel -= damage;
		}
		return overflow;
	}
	
	public int getEnergyLevel() {
		return energyLevel;
	}
}
