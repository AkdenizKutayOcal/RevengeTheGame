package Game;


import views.UI;

import javax.swing.ImageIcon;

import resources.*;

public class Rothenburg extends Scores {

	String event = "<html> Welcome to Rothenburg <br/> Who sent you to Rothernburg? <br/> </html> ";
	String eventResponse = "i did not";

	
	public Rothenburg(UI sendToEvent) {
		myGame = sendToEvent;
		if(this.rothenburgIsActivated) {
		sendToEvent.setTask(event);
		myGame.getMapLabel().setIcon(new ImageIcon(UI.class.getResource("/resources/rothenburgTask.jpg")));
		this.theMidlandsIsActivated = false;
		
		}
		else {
			myGame.setTask("Go to the Midlands");
		}
	}
	public void getRothenburg() {
		
		if(this.rothenburgIsActivated) {
		myGame.setTask(event);
		
		}
		else {
			myGame.setTask("Go to the Midlands");
		}
	}

	@Override
	public void addReputation() {
		// TODO Auto-generated method stub
		if (this.taskIsCompleted) {
			myGame.feedBack("Sorry! you already performed this task");
			myGame.setTask("Go to Totherang");
		}
		else {
			Reputation = Reputation + 10 ;
			this.taskIsCompleted = true;
			myGame.setReputation(Reputation);
			myGame.setHp(Hp);
			myGame.feedBack("Congratulations you earned 10 reputation points");
			myGame.getMapLabel().setIcon(new ImageIcon(UI.class.getResource("/resources/intoTothrang.jpg")));
			myGame.setTask("Go to the Totherang");
			this.totherangIsActivated = true;
		}
		
	}

	@Override
	protected void reduceHp() {
		// TODO Auto-generated method stub
		this.Hp -= 1;
		myGame.setHp(Hp);
	}

	@Override
	protected void buyHint() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkAnswer(String response) {
		response.toLowerCase();
		response.trim();
		if(response.equalsIgnoreCase(eventResponse)) {
			addReputation();
			
		}
		else if (response.equalsIgnoreCase("next")) {
			Reputation = Reputation + 40 ;
		}
		else {
			myGame.feedBack("Your Answer is wrong");
			reduceHp();
			
		}
	}

	@Override
	public String getEvent() {
		// TODO Auto-generated method stub
		return event;
	}
	@Override
	public void eventConstructor() {
		// TODO Auto-generated method stub
		getRothenburg();
		
	}

}
