import org.junit.*;

import StarTrekV2.Starship;
import StarTrekV2.Subsytem;

public class MyUnitTest {
	
	@Test
	public void testStrongShield() {
		Starship ship = new Starship();
		ship.hitStarship(1000);
		
		Assert.assertTrue(ship.shield.getEnergy() > 0);
	}
	
	@Test
	public void testShieldDamaged() {
		Starship ship = new Starship();
		ship.hitStarship(20000);
		
		Assert.assertTrue(ship.shield.getEnergy() == 0);
		
		for (Subsytem subsystem : ship.subSystems) {
			Assert.assertTrue(subsystem.isDamaged());
		}
	}
	
	@Test
	public void testShieldDepleted() {
		Starship ship = new Starship();
		ship.hitStarship(5000);
		
		Assert.assertTrue(ship.shield.isDepleted());
		
		for (Subsytem subsystem : ship.subSystems) {
			Assert.assertFalse(subsystem.isDamaged());
		}
	}
}
