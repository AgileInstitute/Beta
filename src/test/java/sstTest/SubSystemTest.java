package sstTest;

import junit.framework.Assert;

import org.junit.Test;

import sst.SubSystem;

public class SubSystemTest {
	SubSystem subSystem = new SubSystem(200, 100);

	@Test
	public void repairDates() {
		subSystem.damage(301);

		int expected = 15;
		int actual = subSystem.getTenthsOfRepairDays();

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void checkDamage() {
		Assert.assertFalse("Subsystem should not be damaged at start",
				subSystem.isDamaged());
	}

	@Test
	public void checkMaxDamage() {
		subSystem.damage(3000);
		int actual = subSystem.getTenthsOfRepairDays();
		int expected = 100;
		
		Assert.assertEquals(expected, actual);
		
	}
}
