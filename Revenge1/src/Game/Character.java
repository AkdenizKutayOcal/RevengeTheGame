package Game;

public abstract class Character {

	protected int HP,DP,RP;//Health Point, DamagePoint, Reputation
	protected int gold=0;
	public Character(int hp,int rp) {
		HP=hp;
		RP=rp;
		//DP=dp;
	}

	public void healer() {
		HP=+50;
	}
	
	
	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	public int getDP() {
		return DP;
	}

	public void setDP(int dP) {
		DP = dP;
	}

	public int getRP() {
		return RP;
	}

	public void setRP(int rP) {
		RP = rP;
	}
	
}
