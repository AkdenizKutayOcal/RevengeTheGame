package Game;
import java.awt.EventQueue;

import views.UI;

public class Game {

	
	public static UI sendToEvent;
	
	public Game() {
		
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI window = new UI();
					window.gettingEvents(window);
					sendToEvent = window;
					 startingEvent starting = new startingEvent(sendToEvent);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
