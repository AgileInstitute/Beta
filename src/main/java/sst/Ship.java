package sst;

public class Ship {
	public static final int _DEFAULT_INITIAL_ENERGY = 50000;
	private String registration = null;
	private ShieldControl shield = null;
	int energy = 0;
	
	public Ship(String registration) {
		this.registration = registration;
		this.shield = new ShieldControl();
		this.energy = _DEFAULT_INITIAL_ENERGY;
	}
	
	public Ship(String registration, int initialEnergy) {
		this.registration = registration;
		this.shield = new ShieldControl();
		this.energy = initialEnergy;
	}

	public String getRegistration() {
		return registration;
	}
	
	public int getShieldLevel() {
		return this.shield.getEnergyLevel();
	}

	public int getEnergyLevel() {
		return this.energy;
	}

	/**
	 * 
	 * @param energy to transfer
	 * @return energy deficit that ship was unable to transfer
	 */
	public int transferEnergyToShields(int energy) {
		int transferAmount = energy;
		int deficitEnergy = 0;
		if (transferAmount > getEnergyLevel()) {
			transferAmount = getEnergyLevel();
			deficitEnergy = energy - transferAmount;
		}
		if (shield.getEnergyLevel() + energy > ShieldControl._MAX_SHIELD_ENERGY) {
			transferAmount = shield.getEnergyLevel() + energy - ShieldControl._MAX_SHIELD_ENERGY;
		}
		shield.transferEnergy(transferAmount);
		this.energy -= transferAmount;
		return deficitEnergy;
	}
	
	public void takeDamage(int damage) {
		shield.transferEnergy(-damage);
	}
}
