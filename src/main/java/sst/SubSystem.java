package sst;

public class SubSystem {
	int tenthsOfRepairDays = 0;
	int maxTenthsOfRepairDays = 0;
	int energyToDamageFactor = 0;

	
	public SubSystem(int energyToDamageFactor, int maxRepairTenthsOfDays) {
		this.energyToDamageFactor = energyToDamageFactor;
		this.maxTenthsOfRepairDays = maxRepairTenthsOfDays;
	}
	
	public void getDamage(int energy) {
		int additionalRepairDays =  (energy * 10) /  (energyToDamageFactor);
		this.tenthsOfRepairDays += additionalRepairDays;
		if (this.tenthsOfRepairDays > this.maxTenthsOfRepairDays) {
			tenthsOfRepairDays = maxTenthsOfRepairDays;
		}
	}
	
	public int getTenthsOfRepairDays() {
		return tenthsOfRepairDays;
	}

	public boolean isDamaged() {
		if (tenthsOfRepairDays == 0) {
			return false;
		} else  {
			return true;
		}
	}
	
	public void repairDamage(int tenthsOfStarDays) {
		if (this.tenthsOfRepairDays < tenthsOfStarDays) {
			this.tenthsOfRepairDays = 0;
		} else {
			this.tenthsOfRepairDays -= tenthsOfStarDays;
		}
	}
}
