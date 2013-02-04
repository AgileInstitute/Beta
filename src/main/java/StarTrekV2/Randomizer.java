package StarTrekV2;

import java.util.Random;

public class Randomizer {

	private final Random rnd = new Random(System.currentTimeMillis());

	public int nextInt(
			int maximum)
	{
		return rnd.nextInt(maximum);
	}
}
