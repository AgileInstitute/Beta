import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import StarTrekV2.Subsystem;
import StarTrekV2.SystemRestore;
import StarTrekV2.Weapon;
import StarTrekV2.Engine;
import StarTrekV2.LifeSupport;


public class SystemRestoreTest {
	Engine engine;
	Weapon weapon;
	LifeSupport lifeSupport;
	SystemRestore systemRestore;
	
	@Before
	public void initialize(){
		engine = new Engine(1000);
		weapon = new Weapon(1000);
		lifeSupport = new LifeSupport(1000);
		
		engine.takeDamage(500);
		weapon.takeDamage(500);
		lifeSupport.takeDamage(500);
		
		systemRestore = new SystemRestore();
	}

	@Test
	public void testEngineRecharge(){
		Subsystem subsystem = engine;
		Assert.assertTrue(subsystem.isDamaged() == true);
		
		systemRestore.fixSubsystem(subsystem);
		
		Assert.assertTrue(!subsystem.isDamaged() == true);
	}
	
	@Test
	public void testWeaponRecharge(){
		Subsystem subsystem = weapon;
		Assert.assertTrue(subsystem.isDamaged() == true);	
		
		systemRestore.fixSubsystem(subsystem);
		
		Assert.assertTrue(!subsystem.isDamaged() == true);
	}
	
	@Test
	public void testLifeSuportRecharge(){
		Subsystem subsystem = weapon;
		Assert.assertTrue(subsystem.isDamaged() == true);		
		
		systemRestore.fixSubsystem(subsystem);
		
		Assert.assertTrue(!subsystem.isDamaged() == true);
	}
}
