package sstTest;

import junit.framework.Assert;

import org.junit.Test;

import sst.Enemy;
import sst.Ship;


public class EnemyTests {
	@Test
	public void testSmallAttack() {
		Enemy enemy = new Enemy();
		
		Ship ship = new Ship("registration");
		ship.transferEnergyToShields(1000);
		enemy.attack(ship, 300);
		int remainingShieldLevel = ship.getShieldLevel();
		int expected = 700;
		
		Assert.assertEquals(expected, remainingShieldLevel);
	}
}
