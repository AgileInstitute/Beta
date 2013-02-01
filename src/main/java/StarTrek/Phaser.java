package StarTrek;

public class Phaser extends Weapon {

	private static final String AMOUNT = "amount";

	private int energy = 10000;
	
	public Phaser(int initialEnergy) {
		energy = initialEnergy;
	}

	public int energyRemaining() {
	    return energy;
	}

	@Override
	public void fire(Galaxy wg) {
		int amount = Integer.parseInt(wg.parameter(AMOUNT));
		Klingon enemy = (Klingon) wg.variable(TARGET);
		if (energy >= amount) {
			int distance = enemy.distance();
			if (distance > 4000) {
				wg.writeLine("Klingon out of range of phasers at " + distance + " sectors...");
			} else {
				int damage = amount - (((amount /20)* distance /200) + Game.rnd(200));
				if (damage < 1) {
					damage = 1;
				}
				wg.writeLine("Phasers hit Klingon at " + distance + " sectors with " + damage + " units");
				if (damage < enemy.getEnergy()) {
					enemy.setEnergy(enemy.getEnergy() - damage);
					wg.writeLine("Klingon has " + enemy.getEnergy() + " remaining");
				} else {
					wg.writeLine("Klingon destroyed!");
					enemy.delete();
				}
			}
			energy -= amount;

		} else {
			wg.writeLine("Insufficient energy to fire phasers!");
		}
	}
}
