package sstTest;

import org.junit.Assert;
import org.junit.Test;

import sst.Ship;

public class ShipTests {

	@Test
	public void ShipConstruction() {
		String registration = "NCC-1701";
		Ship ship = new Ship(registration);
		Assert.assertEquals(registration, ship.getRegistration());
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
		Assert.assertEquals(50000, ship.getEnergyLevel());
	}
	@Test
	public void TransferEnergyFromShipToShields() {
		Ship ship = new Ship("NCC-1701", 10000);
		ship.transferEnergyToShields(1000);
		Assert.assertEquals(1000, ship.getShieldLevel());
		Assert.assertEquals(9000, ship.getEnergyLevel());
	}
	
	@Test
	public void TransferMoreEnergyThanShieldsCanTake() {
		Ship ship = new Ship("NCC-1701", 20000);
		ship.transferEnergyToShields(9500);
		ship.transferEnergyToShields(1000);
		Assert.assertEquals(10000, ship.getShieldLevel());
		Assert.assertEquals(10000, ship.getEnergyLevel());
	}
	
	@Test
	public void TakeDamage() {
		Ship ship = new Ship("NCC-1701");
		ship.transferEnergyToShields(10000);
		int damage = 1000;
		ship.takeDamage(damage);
		Assert.assertEquals(9000, ship.getShieldLevel());
	}

	@Test
	public void TransferEnergyYouDoNotHave() {
		Ship ship = new Ship("NCC-1701", 1000);
		int deficitEnergy = ship.transferEnergyToShields(2000);
		Assert.assertEquals(1000, ship.getShieldLevel());
		Assert.assertEquals(1000, deficitEnergy);
	}
	
	@Test
	public void CreateShipWithInitialEnergy() {
		Ship ship = new Ship("NCC-1701", 2000);
		int shipEnergy = ship.getEnergyLevel();
		Assert.assertEquals(2000, shipEnergy);
	}
	
	@Test
	public void DamageSubSystem() {
		Ship ship = new Ship("NCC-1701",2000);
		ship.takeDamage(200);
		boolean subSystemIsDamaged = ship.isSubSystemDamaged();
		Assert.assertEquals(true, subSystemIsDamaged);
	}
}
