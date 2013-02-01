package StarTrek;

public class Photon extends Weapon {
	
	private int torpedoes = 8;
	
	public Photon(int torpedoes) {
		this.torpedoes = torpedoes;
	}

	public void setTorpedoes(int value) {
		torpedoes = value;
	}
	
    public int getTorpedoes() {
    	return torpedoes;
    }

	@Override
	public void fire(Galaxy wg) {
		Klingon enemy = (Klingon) wg.variable(TARGET);
		if (torpedoes  > 0) {
			int distance = enemy.distance();
			if ((Game.rnd(4) + ((distance / 500) + 1) > 7)) {
				wg.writeLine("Torpedo missed Klingon at " + distance + " sectors...");
			} else {
				int damage = 800 + Game.rnd(50);
				wg.writeLine("Photons hit Klingon at " + distance + " sectors with " + damage + " units");
				if (damage < enemy.getEnergy()) {
					enemy.setEnergy(enemy.getEnergy() - damage);
					wg.writeLine("Klingon has " + enemy.getEnergy() + " remaining");
				} else {
					wg.writeLine("Klingon destroyed!");
					enemy.delete();
				}
			}
			torpedoes -= 1;

		} else {
			wg.writeLine("No more photon torpedoes!");
		}
	}
}
