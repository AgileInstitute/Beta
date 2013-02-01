﻿package Tests;

import java.util.Random;

public class MockRandom extends Random {

	private static final long serialVersionUID = 232589230472485106L;

	public int nextInt(int maxValue) {
		// always return 1/2 max: It isn't random, and that's the point!
		return maxValue / 2;
	}
}
