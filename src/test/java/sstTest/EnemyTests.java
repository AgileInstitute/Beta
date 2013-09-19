package sstTest;

import java.util.HashMap;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import sst.Enemy;
import sst.Ship;
import sst.SubSystem;

public class EnemyTests {

	HashMap<String, SubSystem> mapOfSubSystems;

	@Before
	public void initializeSubSystems() {
		mapOfSubSystems = new HashMap<String, SubSystem>();
		mapOfSubSystems.put("Weapons", new SubSystem(2000, 200));
		mapOfSubSystems.put("Engine", new SubSystem(1500, 100));
		mapOfSubSystems.put("LifeSupport", new SubSystem(1000, 100));
	}

	@Test
	public void testSmallAttack() {
		Enemy enemy = new Enemy();
		
		Ship ship = new Ship("registration", mapOfSubSystems);
		ship.transferEnergyToShields(1000);
		enemy.attack(ship, 300);
		int remainingShieldLevel = ship.getShieldLevel();
		int expected = 700;
		
		Assert.assertEquals(expected, remainingShieldLevel);
	}
}
