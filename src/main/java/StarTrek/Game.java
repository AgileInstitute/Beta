package StarTrek;

import java.util.Random;

import Untouchables.WebGadget;

public class Game {

	private static final String PHOTON = "photon";
	private static final String PHASER = "phaser";
	private static final String COMMAND = "command";

	private Phaser phaser = new Phaser(10000);
	private Photon photon = new Photon(8);

	public int getRenamingEnergy() {
		return phaser.energyRemaining();
	}

	public void setTorpedoes(int value) {
		photon.setTorpedoes(value);
	}
	
	public int getTorpedoes() {
		return photon.getTorpedoes();

	}

    public void fireWeapon(WebGadget wg) {
        fireWeapon(new Galaxy(wg));
    }

    public void fireWeapon(Galaxy wg) {
        if (wg.parameter(COMMAND).equals(PHASER)) {
			phaser.fire(wg);

		} else if (wg.parameter(COMMAND).equals(PHOTON)) {
			photon.fire(wg);
		}
	}

    // note we made generator public in order to mock it
    // it's ugly, but it's telling us something about our *design!* ;-)
	public static Random generator = new Random();

	public static int rnd(int maximum) {
		return generator.nextInt(maximum);
	}
}
