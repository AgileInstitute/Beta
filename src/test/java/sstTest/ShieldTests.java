package sstTest;

import junit.framework.Assert;

import org.junit.Test;

import sst.Shield;

public class ShieldTests {
	@Test
	public void TransferEnergyToShields() {
		Shield shield = new Shield();
		int energyToTransfer = 1000;
		shield.transferEnergy(energyToTransfer);
		Assert.assertEquals(energyToTransfer, shield.getEnergyLevel());
	}
	
	@Test
	public void TestInitialEnergyConstructor() {
		int initialEnergy = 1000;
		Shield shield = new Shield(initialEnergy);
		Assert.assertEquals(initialEnergy, shield.getEnergyLevel());
	}
	
	@Test
	public void OverloadMaximumShieldEnergy() {
		Shield shield = new Shield(Shield._MAX_SHIELD_ENERGY);
		shield.transferEnergy(1000);
		Assert.assertEquals(Shield._MAX_SHIELD_ENERGY, shield.getEnergyLevel());
	}
	
	@Test
	public void NoLessThanZeroShieldEnergy() {
		Shield shield = new Shield(1000);
		int deficit = shield.transferEnergy(-2000);
		Assert.assertEquals(0, shield.getEnergyLevel());
		Assert.assertEquals(-1000, deficit);
	}
	
	@Test
	public void FindHowMuchIsLeftOverFromOverloadMaximumShieldEnergy() {
		Shield shield = new Shield(Shield._MAX_SHIELD_ENERGY);
		int transferAmount = 1000;
		int remainder = shield.transferEnergy(transferAmount);
		Assert.assertEquals(transferAmount, remainder);
	}
	
	@Test
	public void DamageShields() {
		Shield shield = new Shield(1000);
		int damage = 500;
		shield.takeDamage(damage);
		Assert.assertEquals(500, shield.getEnergyLevel());
	}
	
	@Test
	public void DamageToShip() {
		Shield shield = new Shield(1000);
		int damage = 2000;
		int subsystemDamage = shield.takeDamage(damage);
		Assert.assertEquals(1000, subsystemDamage);
	}
}
