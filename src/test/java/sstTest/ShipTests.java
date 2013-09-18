package sstTest;

import org.junit.*;

import sst.Shield;
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
	@Test
	public void TransferEnergyFromShipToShields() {
		Ship ship = new Ship("NCC-1701");
		int shipEnergyBefore = ship.getEnergyLevel();
		ship.transferEnergyToShields(1000);
		Assert.assertEquals(1000, ship.getShieldLevel());
		Assert.assertEquals(shipEnergyBefore-1000, ship.getEnergyLevel());
	}
	
	@Test
	public void TransferMoreEnergyThanShieldsCanTake() {
		Ship ship = new Ship("NCC-1701");
		ship.transferEnergyToShields(Shield._MAX_SHIELD_ENERGY-500);
		int shipEnergyBefore = ship.getEnergyLevel();
		ship.transferEnergyToShields(1000);
		Assert.assertEquals(Shield._MAX_SHIELD_ENERGY, ship.getShieldLevel());
		Assert.assertEquals(shipEnergyBefore-500, ship.getEnergyLevel());
	}
	
	@Test
	public void TakeDamage() {
		Ship ship = new Ship("NCC-1701");
		ship.transferEnergyToShields(Shield._MAX_SHIELD_ENERGY);
		int damage = 1000;
		int shieldBefore = ship.getShieldLevel();
		ship.takeDamage(damage);
		Assert.assertEquals(shieldBefore-damage, ship.getShieldLevel());
	}

	@Test
	public void TransferEnergyYouDoNotHave() {
		Ship ship = new Ship("NCC-1701");
		ship.transferEnergyToShields(Shield._MAX_SHIELD_ENERGY);
		ship.takeDamage(Shield._MAX_SHIELD_ENERGY);
		ship.transferEnergyToShields(Shield._MAX_SHIELD_ENERGY);
		ship.takeDamage(Shield._MAX_SHIELD_ENERGY);
		ship.transferEnergyToShields(Shield._MAX_SHIELD_ENERGY);
		ship.takeDamage(Shield._MAX_SHIELD_ENERGY);
		ship.transferEnergyToShields(Shield._MAX_SHIELD_ENERGY);
		ship.takeDamage(Shield._MAX_SHIELD_ENERGY);
		ship.transferEnergyToShields(Shield._MAX_SHIELD_ENERGY);
		ship.takeDamage(Shield._MAX_SHIELD_ENERGY);
		ship.transferEnergyToShields(Shield._MAX_SHIELD_ENERGY);
		Assert.assertEquals(0, ship.getShieldLevel());
	}
}
