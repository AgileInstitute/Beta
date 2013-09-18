package sst;

public class Ship {
	public static final int _INITIAL_ENERGY = 50000;
	private String registration = null;
	private Shield shield = null;
	int energy = 0;
	
	public Ship(String registration) {
		this.registration = registration;
		this.shield = new Shield();
		this.energy = _INITIAL_ENERGY;
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

	public void transferEnergyToShields(int energy) {
		int transferAmount = energy;
		if (transferAmount > getEnergyLevel()) {
			transferAmount = getEnergyLevel();
		}
		if (shield.getEnergyLevel() + energy > Shield._MAX_SHIELD_ENERGY) {
			transferAmount = shield.getEnergyLevel() + energy - Shield._MAX_SHIELD_ENERGY;
		}
		shield.transferEnergy(transferAmount);
		this.energy -= transferAmount;
	}
	
	public void takeDamage(int damage) {
		shield.transferEnergy(-damage);
	}
}
