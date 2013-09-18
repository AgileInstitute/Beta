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
		Assert.assertEquals("Energy should be at 1000", energyToTransfer, shield.getEnergyLevel());
	}
	
	@Test
	public void TestInitialEnergyConstructor() {
		int initialEnergy = 1000;
		Shield shield = new Shield(initialEnergy);
		Assert.assertEquals("Energy should be at 1000", initialEnergy, shield.getEnergyLevel());
	}
	
	@Test
	public void OverloadMaximumShieldEnergy() {
		Shield shield = new Shield(Shield._MAX_SHIELD_ENERGY);
		shield.transferEnergy(1000);
		Assert.assertEquals("Energy should be at 10000", Shield._MAX_SHIELD_ENERGY, shield.getEnergyLevel());
	}
	
	@Test
	public void NoLessThanZeroShieldEnergy() {
		Shield shield = new Shield();
		shield.transferEnergy(-1000);
		Assert.assertEquals("Energy should be at 0", 0, shield.getEnergyLevel());
	}
}
