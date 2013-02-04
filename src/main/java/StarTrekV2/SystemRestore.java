package StarTrekV2;


public class SystemRestore {

	private static final int ENGERGY_THRESHOLD = 1000;
	
	public void fixSubsystem(Subsystem subsystem) {
		// TODO Auto-generated method stub
		RechargableSubsytem rcss = (RechargableSubsytem) subsystem;
		rcss.repair(ENGERGY_THRESHOLD);
	}
}
