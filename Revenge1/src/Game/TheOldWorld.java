package Game;

import javax.swing.ImageIcon;


import views.UI;

public class TheOldWorld extends Scores{

	String event = "<html> Welcome to the Old World <br/> To cross this stage you, <br/> You must complete the word puzzle "
			+ "<br/> about programing languages and program development <br/> used by early computers, this programming language "
			+ " consists of binary numbers that correspond to a <br/>"
			+ " computer's electrical state </html> ";
	String eventResponse = "Machine";
	boolean  puzzle1, puzzle2, puzzle3, puzzle4, puzzle5, puzzle6, puzzle7, puzzle8;
	boolean puzzle0 = true;
	
	public TheOldWorld(UI sendToEvent) {
		myGame = sendToEvent;
		if(this.theOldWorldIsActivated) {
		myGame.setTask(event);
		myGame.getMapLabel().setIcon(new ImageIcon(UI.class.getResource("/resources/puzzle1before.jpg")));
		this.totherangIsActivated = false;
		}
		else {
			myGame.setTask("Go to Tothenrang");
		}
	}
	public void getTheOldWorld() {
		
		if(this.theOldWorldIsActivated) {
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
			myGame.setTask("Go to the midlands");
		}
		else {
			Reputation = Reputation + 10 ;
			this.taskIsCompleted = true;
			myGame.setReputation(Reputation);
			myGame.setHp(Hp);
			myGame.getMapLabel().setIcon(new ImageIcon(UI.class.getResource("/resources/intoMidlands.jpg")));
			myGame.feedBack("Congratulations you earned 10 reputation points");
			myGame.setTask("You can now enter The Midlands");
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
		if (puzzle0) {
			
		if(response.equalsIgnoreCase("machine")) {
			myGame.feedBack("Your Answer is Right");
			puzzle1 = true;
			puzzle0 = false;
			myGame.getMapLabel().setIcon(new ImageIcon(UI.class.getResource("/resources/puzzle2before.jpg")));
			event = "<html> Continue the Puzzle Across, 4 letters."
					+ "<br/> the most popular programming language used as of  <br/> June 2010 <br/> </html> ";
			myGame.setTask(event);
			eventResponse = "Java";
		}
		else {
			myGame.feedBack("Your Answer is wrong");
			reduceHp();
		}
		}
		else if (puzzle1) {
			if(response.equalsIgnoreCase(eventResponse)) {
				myGame.feedBack("Your Answer is Right");
				puzzle2 = true;
				puzzle1 = false;
				myGame.getMapLabel().setIcon(new ImageIcon(UI.class.getResource("/resources/puzzle3before.jpg")));
				event = "<html> Continue the Puzzle Down, 9 letters. "
						+ "<br/> a program used with some compilers that transforms   <br/> object code into an executable program <br/> </html> ";
				myGame.setTask(event);
				eventResponse = "Assembler";
			}
			else {
				myGame.feedBack("Your Answer is wrong");
				reduceHp();
			}
		}
		else if (puzzle2) {
			if(response.equalsIgnoreCase(eventResponse)) {
				myGame.feedBack("Your Answer is Right");
				puzzle3 = true;
				puzzle2 = false;
				myGame.getMapLabel().setIcon(new ImageIcon(UI.class.getResource("/resources/puzzle4before.jpg")));
				event = "<html> Continue the Puzzle Across, 3 letters. "
						+ "<br/>the specialized query language that enables users to  <br/>phrase simple or complex requests for data <br/> </html> ";
				myGame.setTask(event);
				eventResponse = "SQL";
			}
			else {
				myGame.feedBack("Your Answer is wrong");
				reduceHp();
			}
		}
		else if (puzzle3) {
			if(response.equalsIgnoreCase(eventResponse)) {
				myGame.feedBack("Your Answer is Right");
				puzzle4 = true;
				puzzle3 = false;
				myGame.getMapLabel().setIcon(new ImageIcon(UI.class.getResource("/resources/puzzle5before.jpg")));
				event = "<html> Continue the Puzzle Across, 8 letters."
						+ "<br/>the first programming language to break programmers' <br/>dependence on machine language <br/> </html> ";
				myGame.setTask(event);
				eventResponse = "Assembly";
			}
			else {
				myGame.feedBack("Your Answer is wrong");
				reduceHp();
			}
		}
		else if (puzzle4) {
			if(response.equalsIgnoreCase(eventResponse)) {
				myGame.feedBack("Your Answer is Right");
				puzzle5 = true;
				puzzle4 = false;
				myGame.getMapLabel().setIcon(new ImageIcon(UI.class.getResource("/resources/puzzle6before.jpg")));
				event = "<html> Continue the Puzzle Across, 11 letters."
						+ "<br/>the language used by a programmer and needs to be <br/>translated into a form recognized by internal hardware <br/> </html> ";
				myGame.setTask(event);
				eventResponse = "Source Code";
			}
			else {
				myGame.feedBack("Your Answer is wrong");
				reduceHp();
			}
		}
		else if (puzzle5) {
			if(response.equalsIgnoreCase(eventResponse)) {
				myGame.feedBack("Your Answer is Right");
				puzzle6 = true;
				puzzle5 = false;
				myGame.getMapLabel().setIcon(new ImageIcon(UI.class.getResource("/resources/puzzle7before.jpg")));
				event = "<html> Continue the Puzzle Down, 5 letters."
						+ "<br/>languages with instructions designed to retrieve and  <br/>edit information included in databases <br/> </html> ";
				myGame.setTask(event);
				eventResponse = "Query";
			}
			else {
				myGame.feedBack("Your Answer is wrong");
				reduceHp();
			}
		}
		else if (puzzle6) {
			if(response.equalsIgnoreCase(eventResponse)) {
				myGame.feedBack("Your Answer is Right");
				puzzle7 = true;
				puzzle6 = false;
				myGame.getMapLabel().setIcon(new ImageIcon(UI.class.getResource("/resources/puzzle8before.jpg")));
				event = "<html> Continue the Puzzle Down, 4 letters."
						+ "<br/>a feature of object-oriented programming where a <br/>blueprint from which objects are made <br/> </html> ";
				myGame.setTask(event);
				eventResponse = "Class";
			}
			else {
				myGame.feedBack("Your Answer is wrong");
				reduceHp();
			}
		}
		else if (puzzle7) {
			if(response.equalsIgnoreCase(eventResponse)) {
				myGame.feedBack("Your Answer is Right");
				puzzle8 = true;
				puzzle7 = false;
				myGame.getMapLabel().setIcon(new ImageIcon(UI.class.getResource("/resources/puzzleComplete.jpg")));
				myGame.setTask(event);
				event = "<html> Your Completed the Puzzle"
						+ "<br/>Hit the submit answer button to earn your reputation <br/> </html> ";
				addReputation();
			}
			else {
				myGame.feedBack("Your Answer is wrong");
				reduceHp();
			}
		}
		else {
			myGame.feedBack("Your Answer is wrong");
			reduceHp();
			
		}
	}

	@Override
	public String getEvent() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void eventConstructor() {
		// TODO Auto-generated method stub
		getTheOldWorld();
		
	}

}