package Game;


import views.UI;

public class TheMidlands extends Scores {
	UI game;
	String event = "<html> Do you think getting into the midlands <br/> is that easy? go to Rothenburg <br/> But Remember \"I did not\" sent you</html> ";
	

	public String getEvent() {
		return this.event;
	}
	public TheMidlands(UI sendToEvent) {
		// TODO Auto-generated constructor stub
		sendToEvent.setTask(event);
		this.game = sendToEvent;
		
		sendToEvent.setReputation(this.Reputation);
		if(this.Reputation<10) {
			addReputation();
		}
		sendToEvent.setReputation(this.Reputation);
		this.rothenburgIsActivated = true;
	}
	public void getTheMidlands() {
		myGame.setTask(event);
		
		
		myGame.setReputation(this.Reputation);
		if(this.Reputation<10) {
			addReputation();
		}
		myGame.setReputation(this.Reputation);
		this.rothenburgIsActivated = true;
	}
	@Override
	public void addReputation() {
		// TODO Auto-generated method stub
		this.Reputation = this.Reputation + 10;
	}

	@Override
	protected void reduceHp() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void buyHint() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkAnswer(String response) {
		// TODO Auto-generated method stub
	}
	@Override
	public void eventConstructor() {
		// TODO Auto-generated method stub
		getTheMidlands();
		
	}

}
