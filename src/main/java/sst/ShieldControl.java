package sst;

public class ShieldControl extends SubSystem {
	private int energyLevel = 0;
	static public int _MAX_SHIELD_ENERGY = 10000;
	static public int _ENERGY_TO_DAMAGE = 500;
	static public int _MAX_REPAIR_TENTHS_OF_DAYS = 500;

	public ShieldControl() {
		super(_ENERGY_TO_DAMAGE, _MAX_REPAIR_TENTHS_OF_DAYS);
		energyLevel = 0;
	}
	
	public ShieldControl(int initialEnergy) {
		super(_ENERGY_TO_DAMAGE, _MAX_REPAIR_TENTHS_OF_DAYS);
		energyLevel = initialEnergy;
	}
	
	/**
	 * Transfer energy to shields
	 * If energy param is negative, then we're taking energy out of the shields to put into the ship.
	 * If the energy transfer wasn't successfully completed, the remainder (excess or deficit) is
	 * returned to calling function.
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
