package Game;

import java.util.Random;

public class King extends Character{
	
	 static Random rand;
	 private static int dp= rand.nextInt((8 - 0) + 1) + 0; //Damage of King is between 8-0
	 
	public King(int hp, int rp) {
		super(hp,rp);
		DP=dp;
		
	}


}
