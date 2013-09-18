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
	
	public void transferEnergyToShields(int energy) {
		this.shield.transferEnergy(energy);
	}
	
	public int getEnergyLevel() {
		return this.energy;
	}
}
