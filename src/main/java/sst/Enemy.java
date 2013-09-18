package sst;

public class Enemy {

	public void attack(Ship ship, int power) {
		ship.takeDamage(power);
	}

}
