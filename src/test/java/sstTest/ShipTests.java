package sstTest;

import org.junit.*;

import sst.Ship;

public class ShipTests {

	@Test
	public void ShipConstruction() {
		String registration = "NCC-1701";
		Ship ship = new Ship(registration);
		Assert.assertEquals("Ship registration should be NCC-1701", registration, ship.getRegistration());
	}

	@Test
	public void ShieldsAtStart() {
		Ship ship = new Ship("NCC-1701");
		Assert.assertEquals(0, ship.getShieldLevel());
	}
	
	@Test
	public void TransferEnergyToShields() {
		Ship ship = new Ship("NCC-1701");
		ship.transferEnergyToShields(1000);
		Assert.assertEquals(1000, ship.getShieldLevel());
	}
	
	@Test
	public void ShipEnergyAtStart() {
		Ship ship = new Ship("NCC-1701");
		Assert.assertEquals(Ship._INITIAL_ENERGY, ship.getEnergyLevel());
	}
}
