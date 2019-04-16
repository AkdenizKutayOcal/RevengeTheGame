package Game;

import javax.swing.ImageIcon;


import views.UI;

public class Totherang  extends Scores{

	String event = "<html> Welcome to Totherang <br/> what is found at the end of \"time\" <br/> present in \"internal\" and \"external\" </html> ";
	String eventResponse = "e";

	
	public Totherang(UI sendToEvent) {
		myGame = sendToEvent;
		if(this.totherangIsActivated) {
		myGame.setTask(event);
		myGame.getMapLabel().setIcon(new ImageIcon(UI.class.getResource("/resources/tothrangTask.jpg")));
		this.rothenburgIsActivated = false;
		
		}
		else {
			myGame.setTask("Go to Rothenburg");
		}
	}
	public void getTotherang() {
		System.out.println("I came here");
		if(this.totherangIsActivated) {
		myGame.setTask(event);
		
		}
		else {
			myGame.setTask("Go to Rothenburg");
		}
	}

	@Override
	public void addReputation() {
		// TODO Auto-generated method stub
		if (this.taskIsCompleted) {
			myGame.feedBack("Sorry! you already performed this task");
			myGame.setTask("Go to the the Old World");
		}
		else {
			Reputation = Reputation + 10 ;
			this.taskIsCompleted = true;
			myGame.setReputation(Reputation);
			myGame.setHp(Hp);
			myGame.feedBack("Congratulations you earned 10 reputation points");
			myGame.getMapLabel().setIcon(new ImageIcon(UI.class.getResource("/resources/intoOldWorld.jpg")));
			myGame.setTask("Go to the Old World");
			this.theOldWorldIsActivated = true;
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
		getTotherang();
		
	}

}
