package Game;

import java.util.ArrayList;

public class Fight {
	
	public ArrayList <Character> characters=new ArrayList<Character>();
	
	
	private String fightMessage="";
	public boolean isKing=false;
	
	
	public void createEnemy(Character c1) {								//We have to use this to new Enemies
		//Enemy enemy= new Enemy(100,0);
		characters.add(c1);
		
	}
	
	public void createPlayer(Character c1) {             //When Player enters fight we have to reuse this
		//Player player = new Player(hp,rp);
		characters.add(c1);
		
	}
	public void playerAttack() {		
		 
		int playerDamage = 0;
		playerDamage = new java.util.Random().nextInt(20);
		
		characters.get(1).setHP(characters.get(1).getHP()-playerDamage);
		enemyAttack();
		fightMessage="You attacked and gave "+playerDamage+" damage.\n He also attacked you and now you have "+characters.get(0).getHP()+" health.";
		
		if(characters.get(1).getHP()==0) {
			arenafightOver();
		}
	}
	
	public void enemyAttack() {		
		 
		int enemyDamage = 0;
		enemyDamage = new java.util.Random().nextInt(10);
		
		characters.get(0).setHP(characters.get(0).getHP()-enemyDamage);
		fightMessage="Enemy attacked and gave you"+enemyDamage+" damage";
	}
	public void arenafightOver() {
		//If player wins
		if(characters.get(1).getHP()<0) {
			if(isKing==false)
			fightMessage="Good Job You Won The Battle. Doctors Helped You To Heal and You earned 20 gold";
			else if(isKing==true) {
				fightMessage="You killed the King and run away.You also stole some gold that you may need.";
			}
			characters.get(0).setHP(characters.get(0).getHP()+40);
			characters.get(0).setGold(characters.get(0).getGold()+20);
		}
		
		else if(characters.get(0).getHP()<0&&isKing==false) {
			fightMessage="What a Shame! You Lost The Battle.One old man you helped you to heal";
			characters.get(0).setHP(characters.get(0).getHP()+30);
		}
	}

	public String getFightMessage() {
		return fightMessage;
	}

	public void setFightMessage(String fightMessage) {
		this.fightMessage = fightMessage;
	}
	

}
