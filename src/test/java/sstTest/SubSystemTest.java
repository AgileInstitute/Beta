package sstTest;

import junit.framework.Assert;

import org.junit.Test;

import sst.SubSystem;

public class SubSystemTest {
	SubSystem subSystem = new SubSystem(200, 100);

	@Test
	public void repairDates() {
		subSystem.getDamage(301);

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
		subSystem.getDamage(3000);
		int actual = subSystem.getTenthsOfRepairDays();
		int expected = 100;
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void RepairDamageByTimeLapse() {
		subSystem.getDamage(400);
		subSystem.repairDamage(10);
		Assert.assertEquals(true,subSystem.isDamaged());
		Assert.assertEquals(10, subSystem.getTenthsOfRepairDays());
	}
	
	@Test
	public void CompletelyRepairByTimeLapse() {
		subSystem.getDamage(200);
		subSystem.repairDamage(10);
		Assert.assertEquals(false, subSystem.isDamaged());		
	}
}
