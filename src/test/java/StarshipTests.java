import org.junit.*;

import StarTrekV2.Starship;
import StarTrekV2.Subsytem;

public class StarshipTests {

	@Test
	public void testIfShieldIsStillStrong() {
		Starship ship = new Starship();
		ship.hitStarship(1000);
		
		Assert.assertTrue(ship.shield.getEnergy() > 0);
	}

	@Test
	public void testIfAnyComponentOfStarshipIsDamaged() {
		Starship ship = new Starship();
		ship.hitStarship(20000);
		
		Assert.assertTrue("Shield is not depleted", ship.shield.getEnergy() == 0);
		
		// Check if at list one component was damaged.
		boolean anythingDamaged = false;

		for (Subsytem subsystem : ship.subSystems) {
			anythingDamaged = anythingDamaged || subsystem.isDamaged();
		}

		Assert.assertTrue("Shield is depeleted but there is a subsytem that is active", anythingDamaged);
	}
	
	@Test
	public void testIsShieldIsDepletedButAllOtherComponentsOfStarshipAreActive() {
		Starship ship = new Starship();
		ship.hitStarship(5000);
		
		Assert.assertTrue("Shield is not depled", ship.shield.isDepleted());
		
		for (Subsytem subsystem : ship.subSystems) {
			Assert.assertFalse("Subsystem is damage while it is supposed to be active", subsystem.isDamaged());
		}
	}

	@Test
	public void testIfComponentNeedsToBeRecharged() {
		
	}
}
