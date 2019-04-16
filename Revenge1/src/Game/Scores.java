package Game;
import views.UI;

public abstract  class Scores {
	protected static boolean rothenburgIsActivated, totherangIsActivated, theOldWorldIsActivated, hartlandIsActivated, tamarangIsActivated,theMidlandsIsActivated;
	 public boolean taskIsCompleted;
	protected static int Hp;
	protected static int Reputation;
	public abstract void addReputation();
	protected abstract void reduceHp();
	protected abstract void buyHint();
	protected static int eventNumber;
	public abstract void checkAnswer(String response);
	protected static UI myGame;
	public abstract String getEvent();
	public abstract void eventConstructor();
	protected void initialise(UI sendToEvent) {
		this.myGame = sendToEvent;
		this.Hp = 100;
		this.Reputation = 0;
		myGame.setReputation(this.Reputation);
		myGame.setHp(this.Hp);
		System.out.println("I came to this point");
	}
	protected Scores() {	
	}
	protected int getHp() {
		return this.Hp;
		
	}
	protected int getReputation() {
		return this.Reputation;
	}
	

}
