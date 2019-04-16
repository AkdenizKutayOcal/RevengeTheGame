package views;
import Game.Game;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Game.Enemy;
import Game.Fight;
import Game.Game;
import Game.Player;
import Game.Rothenburg;
import Game.Scores;
import Game.TheMidlands;
import Game.TheOldWorld;
import Game.Totherang;
import Game.startingEvent;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UI extends JFrame implements MouseListener{

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	CardLayout c1= new CardLayout();
	CardLayout marketC1= new CardLayout();
	
	
	
	startingEvent starting;
	static UI sendToEvent ;
	private int eventNumber;
	Player ourPlayer = new Player(100,0);
	
	
	Fight fight;
	//////
	
	
	///////////////////////////////////////////////
	// Some of the Needed Buttons-Labels
	///////////////////////////////////////////////
	JLabel IntroductoryMessage, BuyHint, myTask, hpLabel, hpPoints, reputationPoints, firstTimeMessage,feedBackLabel,
	welcomeToMidland, mapLabel;
	JButton runAwayButton;
	JButton btnNewButton_2;
	JButton NoFightButton,nextButtonEnterence1,kingFightButton,KillButton,DonotKillButton,KF_nextB1,KF_nextB2,KF_nextB3,endTheGameB;
	JLabel KingsEnteranceText;
	JLabel enemyHP;
	JLabel fightHP;
	JLabel fightLabel,KingFightDialoge,GameOverMessage,enemyImg;
	private JTextField txtEnterYourAnswer;
	private JButton proceedButton;
	
	///////////////////////////////////////////////
	//Game Variables
	///////////////////////////////////////////////
	
	public static String name;
	ArrayList<Scores> myEvents = new ArrayList<>();
	private boolean shop= false;
	boolean isFightOver=false;
	private String Hp = "" + ourPlayer.getHP();
	private String reputation = "" + ourPlayer.getRP();
	private String gold = "" + ourPlayer.getGold();
	public int damage=(int)Math.random();
	public String getAnswer() {
		return this.txtEnterYourAnswer.getText();
	}

	public void setReputation(int reputation2) {
		reputation = "" + reputation2;
		this.reputationPoints.setText("  " + reputation2);
	}
	public void gettingEvents(UI event) {
		sendToEvent = event;
	}

	public void setHp(int hp2) {
		hpPoints.setText("  " + hp2);
	}

	public void setTask(String event) {
		myTask.setText(event);
	}

	public void feedBack(String feedBack) {
		feedBackLabel.setText(feedBack);
	}
	// Get map label and change map picture
	public JLabel getMapLabel() {
		return this.mapLabel;
	}
	//
	
	
	
	public UI() {
		
		initComponents();
		createEvents();
		
		
	}
	

	
	public void initComponents() {
		

		///////////////////////////////////////////////
		//Creating Frame
		///////////////////////////////////////////////

		setIconImage(Toolkit.getDefaultToolkit().getImage(UI.class.getResource("/resources/rev.png")));
		setTitle("---Revenge The Game---");
		setBackground(Color.BLACK);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(1000,600);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(c1);

		///////////////////////////////////////////////
		//Start Screen
		///////////////////////////////////////////////

		JPanel startScreen = new JPanel();
		startScreen.setBackground(Color.BLACK);
		contentPane.add(startScreen, "1");

		JLabel revengeImage = new JLabel("");
		revengeImage.setBackground(Color.BLACK);
		revengeImage.setIcon(new ImageIcon(UI.class.getResource("/resources/Revenge MainMenu600-356.jpg")));
		revengeImage.setPreferredSize(new Dimension(600, 357));
		revengeImage.setMaximumSize(new Dimension(600, 357));
		revengeImage.setMinimumSize(new Dimension(600, 357));
		revengeImage.setOpaque(true);
		revengeImage.setSize(600,357);

		JButton creditButton = new JButton("Credits");
		creditButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		creditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				c1.show(contentPane,"12");
			}
		});
		creditButton.setForeground(Color.WHITE);
		buttonGroup.add(creditButton);
		creditButton.setBackground(Color.BLACK);

		JButton startButton = new JButton("Start!");
		startButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.next(contentPane);
			}
		});
		
		startButton.setForeground(Color.WHITE);
		buttonGroup.add(startButton);
		startButton.setBackground(Color.BLACK);
		
		GroupLayout gl_startScreen = new GroupLayout(startScreen);
		gl_startScreen.setHorizontalGroup(
			gl_startScreen.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_startScreen.createSequentialGroup()
					.addGap(191)
					.addComponent(revengeImage, GroupLayout.PREFERRED_SIZE, 602, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(191, Short.MAX_VALUE))
				.addGroup(gl_startScreen.createSequentialGroup()
					.addGap(187)
					.addComponent(creditButton, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 367, Short.MAX_VALUE)
					.addComponent(startButton, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addGap(193))
		);
		gl_startScreen.setVerticalGroup(
			gl_startScreen.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_startScreen.createSequentialGroup()
					.addContainerGap(67, Short.MAX_VALUE)
					.addComponent(revengeImage, GroupLayout.PREFERRED_SIZE, 359, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
					.addGroup(gl_startScreen.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_startScreen.createSequentialGroup()
							.addComponent(creditButton)
							.addGap(39))
						.addGroup(Alignment.TRAILING, gl_startScreen.createSequentialGroup()
							.addComponent(startButton)
							.addGap(43))))
		);
		startScreen.setLayout(gl_startScreen);
		
		///////////////////////////////////////////////
		//StoryScreen1
		///////////////////////////////////////////////
		
		JPanel storyScreen1 = new JPanel();
		storyScreen1.setBackground(Color.BLACK);
		contentPane.add(storyScreen1, "2");

		JLabel storyScreen1Image = new JLabel("");
		storyScreen1Image.setSize(new Dimension(800, 500));
		storyScreen1Image.setIcon(new ImageIcon(UI.class.getResource("/resources/storyPanel1Img.jpg")));
		storyScreen1Image.setBackground(Color.BLACK);
		storyScreen1Image.setOpaque(true);

		JButton storyScreen1contButton = new JButton("");
		storyScreen1contButton.setIcon(new ImageIcon(UI.class.getResource("/resources/nextImg.jpg")));
		storyScreen1contButton.setBackground(Color.BLACK);
		storyScreen1contButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.next(contentPane);
			}
		});
		GroupLayout gl_storyScreen1 = new GroupLayout(storyScreen1);
		gl_storyScreen1.setHorizontalGroup(
			gl_storyScreen1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_storyScreen1.createSequentialGroup()
					.addGap(110)
					.addComponent(storyScreen1Image, GroupLayout.PREFERRED_SIZE, 765, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
					.addComponent(storyScreen1contButton, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_storyScreen1.setVerticalGroup(
			gl_storyScreen1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_storyScreen1.createSequentialGroup()
					.addContainerGap()
					.addComponent(storyScreen1Image, GroupLayout.PREFERRED_SIZE, 540, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_storyScreen1.createSequentialGroup()
					.addContainerGap(541, Short.MAX_VALUE)
					.addComponent(storyScreen1contButton, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addGap(2))
		);
		storyScreen1.setLayout(gl_storyScreen1);

		///////////////////////////////////////////////
		//StoryScreen2
		///////////////////////////////////////////////

		JPanel storyScreen2 = new JPanel();
		storyScreen2.setBackground(Color.BLACK);
		contentPane.add(storyScreen2, "3");

		JLabel storyScreen2Image = new JLabel("");
		storyScreen2Image.setIcon(new ImageIcon(UI.class.getResource("/resources/storyScreen2Img.jpg")));
		storyScreen2Image.setBackground(Color.BLACK);
		storyScreen2Image.setOpaque(true);

		JButton storyScreen2contButton = new JButton("");
		storyScreen2contButton.setIcon(new ImageIcon(UI.class.getResource("/resources/nextImg.jpg")));
		storyScreen2contButton.setBackground(Color.BLACK);
		storyScreen2contButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.next(contentPane);
			}
		});
		GroupLayout gl_storyScreen2 = new GroupLayout(storyScreen2);
		gl_storyScreen2.setHorizontalGroup(
			gl_storyScreen2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_storyScreen2.createSequentialGroup()
					.addGap(109)
					.addComponent(storyScreen2Image, GroupLayout.PREFERRED_SIZE, 766, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(109, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_storyScreen2.createSequentialGroup()
					.addContainerGap(930, Short.MAX_VALUE)
					.addComponent(storyScreen2contButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_storyScreen2.setVerticalGroup(
			gl_storyScreen2.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_storyScreen2.createSequentialGroup()
					.addContainerGap()
					.addComponent(storyScreen2Image)
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addComponent(storyScreen2contButton, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
		);
		storyScreen2.setLayout(gl_storyScreen2);

		///////////////////////////////////////////////
		//StoryScreen3
		///////////////////////////////////////////////

		JPanel storyScreen3 = new JPanel();
		storyScreen3.setBackground(Color.BLACK);
		contentPane.add(storyScreen3, "4");

		JLabel storyScreen3Image = new JLabel("");
		storyScreen3Image.setIcon(new ImageIcon(UI.class.getResource("/resources/storyPanel3Img.jpg")));
		storyScreen3Image.setBackground(Color.BLACK);
		storyScreen3Image.setOpaque(true);

		JButton storyScreen3contButton = new JButton("");
		storyScreen3contButton.setIcon(new ImageIcon(UI.class.getResource("/resources/nextImg.jpg")));
		storyScreen3contButton.setBackground(Color.DARK_GRAY);
		storyScreen3contButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.next(contentPane);
			}
		});
		GroupLayout gl_storyScreen3 = new GroupLayout(storyScreen3);
		gl_storyScreen3.setHorizontalGroup(
			gl_storyScreen3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_storyScreen3.createSequentialGroup()
					.addGap(82)
					.addComponent(storyScreen3Image, GroupLayout.PREFERRED_SIZE, 820, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(82, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_storyScreen3.createSequentialGroup()
					.addContainerGap(922, Short.MAX_VALUE)
					.addComponent(storyScreen3contButton, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(16))
		);
		gl_storyScreen3.setVerticalGroup(
			gl_storyScreen3.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_storyScreen3.createSequentialGroup()
					.addContainerGap()
					.addComponent(storyScreen3Image)
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addComponent(storyScreen3contButton, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(1))
		);
		storyScreen3.setLayout(gl_storyScreen3);

		///////////////////////////////////////////////
		//AcceptancePanel
		///////////////////////////////////////////////

		JPanel accaptence = new JPanel();
		accaptence.setBackground(Color.BLACK);
		contentPane.add(accaptence, "5");

		JLabel accaptencePanelimg = new JLabel("");
		accaptencePanelimg.setIcon(new ImageIcon(UI.class.getResource("/resources/acceptence.jpg")));
		accaptencePanelimg.setBackground(Color.BLACK);
		accaptencePanelimg.setOpaque(true);

		JButton gaveUpButton = new JButton("Gave up like a loser!");
		gaveUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.first(contentPane);
			}
		});
		gaveUpButton.setForeground(Color.WHITE);
		gaveUpButton.setBackground(Color.BLACK);

		JButton acceptButton = new JButton("Accept the Mission!");
		acceptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.show(contentPane, "13");
			}
		});
		acceptButton.setForeground(Color.WHITE);
		acceptButton.setBackground(Color.BLACK);
		GroupLayout gl_accaptence = new GroupLayout(accaptence);
		gl_accaptence.setHorizontalGroup(
			gl_accaptence.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_accaptence.createSequentialGroup()
					.addGap(137)
					.addComponent(gaveUpButton, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
					.addGap(253)
					.addComponent(acceptButton)
					.addGap(136))
				.addGroup(Alignment.LEADING, gl_accaptence.createSequentialGroup()
					.addGap(27)
					.addComponent(accaptencePanelimg, GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
					.addGap(26))
		);
		gl_accaptence.setVerticalGroup(
			gl_accaptence.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_accaptence.createSequentialGroup()
					.addGap(44)
					.addComponent(accaptencePanelimg, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addGroup(gl_accaptence.createParallelGroup(Alignment.BASELINE)
						.addComponent(gaveUpButton)
						.addComponent(acceptButton))
					.addContainerGap())
		);
		accaptence.setLayout(gl_accaptence);
		
		///////////////////////////////////////////////
		//introduction
		///////////////////////////////////////////////
		
		JPanel introduction = new JPanel();
		introduction.setBackground(Color.BLACK);
		contentPane.add(introduction, "13");
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(UI.class.getResource("/resources/Introduction.jpg")));
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setPreferredSize(new Dimension(900, 500));
		lblNewLabel_1.setSize(new Dimension(900, 500));
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setIcon(new ImageIcon(UI.class.getResource("/resources/nextImg.jpg")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.show(contentPane, "6");
			}
		});
		btnNewButton.setBackground(Color.DARK_GRAY);
		GroupLayout gl_introduction = new GroupLayout(introduction);
		gl_introduction.setHorizontalGroup(
			gl_introduction.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_introduction.createSequentialGroup()
					.addGap(38)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 909, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(37, Short.MAX_VALUE))
				.addGroup(gl_introduction.createSequentialGroup()
					.addContainerGap(927, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(13))
		);
		gl_introduction.setVerticalGroup(
			gl_introduction.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_introduction.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 524, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
		);
		introduction.setLayout(gl_introduction);
		
		///////////////////////////////////////////////
		//mainScreenOutside
		///////////////////////////////////////////////
		
		JPanel mainScreenOutside = new JPanel();
		mainScreenOutside.setBackground(Color.BLACK);
		contentPane.add(mainScreenOutside, "6");
		mainScreenOutside.setLayout(new CardLayout(0, 0));
		
		JSplitPane splitPane0 = new JSplitPane();
		mainScreenOutside.add(splitPane0, "name_24961195794152");
		JSplitPane taskPane = new JSplitPane();
		taskPane.setBackground(new Color(255, 255, 204));
		taskPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane0.setRightComponent(taskPane);

		JLabel lblYourTask = new JLabel("Your Task");
		lblYourTask.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		taskPane.setLeftComponent(lblYourTask);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.4);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		taskPane.setRightComponent(splitPane);

		JSplitPane splitPane_6 = new JSplitPane();
		splitPane_6.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(splitPane_6);

		txtEnterYourAnswer = new JTextField();
		txtEnterYourAnswer.setText("enter your answer here");
		txtEnterYourAnswer.setToolTipText("enter your answer here");
		txtEnterYourAnswer.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		splitPane_6.setLeftComponent(txtEnterYourAnswer);
		txtEnterYourAnswer.setColumns(10);

		JSplitPane splitPane_7 = new JSplitPane();
		splitPane_7.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_6.setRightComponent(splitPane_7);
		
		JButton submitAnswerButton = new JButton("Submit Your Answer");
		submitAnswerButton.setBackground(new Color(204, 255, 204));
		submitAnswerButton.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		splitPane_7.setLeftComponent(submitAnswerButton);
		submitAnswerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myEvents.get(eventNumber).checkAnswer(txtEnterYourAnswer.getText());

			}
		});

		JSplitPane splitPane_8 = new JSplitPane();
		splitPane_8.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_7.setRightComponent(splitPane_8);

		BuyHint = new JLabel("");
		BuyHint.setHorizontalAlignment(SwingConstants.CENTER);
		BuyHint.setFont(new Font("Times New Roman", Font.BOLD, 13));
		splitPane_8.setLeftComponent(BuyHint);

		feedBackLabel = new JLabel("Feed Back On Your Ans");
		feedBackLabel.setHorizontalAlignment(SwingConstants.CENTER);
		feedBackLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		splitPane_8.setRightComponent(feedBackLabel);

		String whatToDo = "<html> Hey You There! <br/> Enter the Midlands</html>";
		myTask = new JLabel(whatToDo);
		myTask.setVerticalAlignment(SwingConstants.TOP);
		myTask.setFont(new Font("Times New Roman", Font.BOLD, 17));
		splitPane.setLeftComponent(myTask);

		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.1);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane0.setLeftComponent(splitPane_1);

		mapLabel = new JLabel("");
		mapLabel.setIcon(new ImageIcon(UI.class.getResource("/resources/MapOutsideLast.jpg")));
		splitPane_1.setRightComponent(mapLabel);
		mapLabel.addMouseListener(this);

		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_1.setLeftComponent(splitPane_2);

		JSplitPane splitPane_3 = new JSplitPane();
		splitPane_3.setResizeWeight(0.2);
		splitPane_2.setLeftComponent(splitPane_3);

		hpLabel = new JLabel("HP Available          ");
		hpLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		splitPane_3.setLeftComponent(hpLabel);

		hpPoints = new JLabel(Hp);
		hpPoints.setText(Hp);
		hpPoints.setHorizontalAlignment(SwingConstants.CENTER);
		hpPoints.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		splitPane_3.setRightComponent(hpPoints);

		JSplitPane splitPane_4 = new JSplitPane();
		splitPane_2.setRightComponent(splitPane_4);

		JSplitPane splitPane_5 = new JSplitPane();
		splitPane_4.setRightComponent(splitPane_5);

		JLabel reputationlabel = new JLabel("REPUTATION POINTS");
		reputationlabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		splitPane_5.setLeftComponent(reputationlabel);

		reputationPoints = new JLabel(reputation);
		reputationPoints.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		splitPane_5.setRightComponent(reputationPoints);

		JLabel lblNewLabel_11 = new JLabel("                                                                   ");
		splitPane_4.setLeftComponent(lblNewLabel_11);

		JSplitPane splitPane_9 = new JSplitPane();
		splitPane_9.setToolTipText("cannotEnter");
		getContentPane().add(splitPane_9, "name_cannotEnter");

		JSplitPane splitPane_10 = new JSplitPane();
		splitPane_10.setResizeWeight(1.0);
		splitPane_10.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_9.setRightComponent(splitPane_10);

		firstTimeMessage = new JLabel("");
		firstTimeMessage.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		splitPane_10.setLeftComponent(firstTimeMessage);

		JButton backButton = new JButton("Go Back");
		splitPane_10.setRightComponent(backButton);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getMapLabel().setIcon(new ImageIcon(UI.class.getResource("/resources/intoRothenburg.jpg")));
				c1.previous(getContentPane());

			}
		});
		JLabel cannotEnterGuar = new JLabel("");
		cannotEnterGuar.setIcon(new ImageIcon(UI.class.getResource("/resources/guard.png")));
		splitPane_9.setLeftComponent(cannotEnterGuar);

		JSplitPane splitPane_11 = new JSplitPane();
		splitPane_11.setToolTipText("cannotEnter");
		getContentPane().add(splitPane_11, "11");

		JLabel midLandPicture = new JLabel("");
		midLandPicture.setIcon(new ImageIcon(UI.class.getResource("/resources/MapLast.jpg")));
		splitPane_11.setLeftComponent(midLandPicture);

		JSplitPane splitPane_12 = new JSplitPane();
		splitPane_12.setResizeWeight(1.0);
		splitPane_12.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_11.setRightComponent(splitPane_12);

		welcomeToMidland = new JLabel("");
		welcomeToMidland.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		splitPane_12.setLeftComponent(welcomeToMidland);

		JButton btnNewButton1 = new JButton("Proceed");
		splitPane_12.setRightComponent(btnNewButton1);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
	
		
		if (e.getX() >= 360 && e.getX() <= 457 && e.getY() >= 173 && e.getY() <= 216) {

			int myReputation = Integer.parseInt(reputation);
			System.out.println(myReputation);
			if (myReputation < 40) {
				String message = "<html> Sorry! Our City accepts only reputable poeple <br/> Your reputation point is less than 40<br/> Go back and increase your reputation "
						+ " <br/> Look at my task and you will see what you must do to earn reputation points</html>";
				firstTimeMessage.setText(message);
				if (myEvents.size() < 1) {
					TheMidlands midLandsTask = new TheMidlands(sendToEvent);
					myEvents.add(midLandsTask);
					String task1 = "<html> Sorry! Our City accepts only reputable poeple <br/> Your reputation point is less than 40<br/> Go back and increase your reputation "
							+ " <br/> Look at my task and you will see what you must do to earn reputation points</html>";
					c1.next(getContentPane());
				} else {
					eventNumber = 0;
					myEvents.get(0).eventConstructor();
					c1.show(contentPane, "9");
				}

			} else {
				c1.show(getContentPane(), "8");
				String message = "<html> Welcome! You are indeed brave! You are free to explore the midlands<br/> If you want to meet with the king"
						+ " <br/> You must win fights in the Arena</html>";
				welcomeToMidland.setText(message);
			}

		} else if (e.getX() >= 163 && e.getX() <= 265 && e.getY() >= 124 && e.getY() <= 150) {
			eventNumber = 1;
			if (myEvents.size() < 2) {
				Rothenburg rothenburgTask = new Rothenburg(sendToEvent);
				myEvents.add(rothenburgTask);
			}
			if (myEvents.get(1).taskIsCompleted) {
				myEvents.get(2).addReputation();
			} else {
				myEvents.get(1).eventConstructor();
				eventNumber = 1;
			}
		} else if (e.getX() >= 525 && e.getX() <= 625 && e.getY() >= 33 && e.getY() <= 63) {
			eventNumber = 2;
			if (myEvents.size() < 3) {
				Totherang TotherangTask = new Totherang(sendToEvent);
				myEvents.add(TotherangTask);
			}
			if (myEvents.get(2).taskIsCompleted) {
				myEvents.get(2).addReputation();
			} else {
				myEvents.get(2).eventConstructor();
				eventNumber = 2;
			}
		} else if (e.getX() >= 554 && e.getX() <= 629 && e.getY() >= 420 && e.getY() <= 451) {
			eventNumber = 3;
			if (myEvents.size() < 4) {
				TheOldWorld TheOldWorldTask = new TheOldWorld(sendToEvent);
				myEvents.add(TheOldWorldTask);
			}
			if (myEvents.get(3).taskIsCompleted) {
				myEvents.get(3).addReputation();
			} else {
				myEvents.get(3).eventConstructor();
				eventNumber = 3;
			}
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	


		
		///////////////////////////////////////////////
		//guardPanel
		///////////////////////////////////////////////
		
		//JPanel guardPanel = new JPanel();
		//contentPane.add(guardPanel, "7");
		
		
		///////////////////////////////////////////////
		//Midlands
		///////////////////////////////////////////////
		
		JPanel midLands = new JPanel();
		midLands.setBackground(Color.BLACK);
		contentPane.add(midLands, "8");
		
		JLabel MapMidlands = new JLabel("");
		MapMidlands.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
			System.out.println("X " + e.getX() + " Y " + e.getY());
			
			//Clicked Arena
			if(e.getX()<153 && e.getX()>85&& e.getY()>300&&e.getY()<342 )
				c1.show(contentPane, "9");
			else if(e.getX()<440 && e.getX()>261&& e.getY()>273&&e.getY()<315)
				c1.show(contentPane,"10");
			else if(e.getX()<834 && e.getX()>735&& e.getY()>130&&e.getY()<197)
				c1.show(contentPane, "11");
			}
			
		});
		MapMidlands.setIcon(new ImageIcon(UI.class.getResource("/resources/MapLast.jpg")));
		MapMidlands.setBackground(Color.BLACK);
		MapMidlands.setOpaque(true);
		
		JLabel hpMidland = new JLabel("New label");
		hpMidland.setOpaque(true);
		
		JLabel goldMidland = new JLabel("New label");
		goldMidland.setOpaque(true);
		
		JLabel rep = new JLabel("New label");
		rep.setOpaque(true);
		GroupLayout gl_midLands = new GroupLayout(midLands);
		gl_midLands.setHorizontalGroup(
			gl_midLands.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_midLands.createSequentialGroup()
					.addGroup(gl_midLands.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_midLands.createSequentialGroup()
							.addGap(92)
							.addComponent(hpMidland, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
							.addGap(64)
							.addComponent(goldMidland, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
							.addGap(105)
							.addComponent(rep, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_midLands.createSequentialGroup()
							.addGap(30)
							.addComponent(MapMidlands)))
					.addContainerGap(54, Short.MAX_VALUE))
		);
		gl_midLands.setVerticalGroup(
			gl_midLands.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_midLands.createSequentialGroup()
					.addGroup(gl_midLands.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_midLands.createSequentialGroup()
							.addGap(2)
							.addComponent(rep, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_midLands.createSequentialGroup()
							.addGap(2)
							.addComponent(goldMidland, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_midLands.createSequentialGroup()
							.addGap(3)
							.addComponent(hpMidland, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(MapMidlands, GroupLayout.PREFERRED_SIZE, 515, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		midLands.setLayout(gl_midLands);
		
		///////////////////////////////////////////////
		//Arena
		///////////////////////////////////////////////
		
		JPanel arenaPanel = new JPanel();
		arenaPanel.setBackground(Color.BLACK);
		contentPane.add(arenaPanel, "9");
		JLabel arenaImage = new JLabel("");
		arenaImage.setIcon(new ImageIcon(UI.class.getResource("/resources/arenaInsideLast.jpg")));
		arenaImage.setOpaque(true);
		
		JButton yesFightButton = new JButton("Let's Fight!");
		yesFightButton.setForeground(Color.WHITE);
		yesFightButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		yesFightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.show(contentPane, "fight");
				
			}
		});
		yesFightButton.setBackground(Color.BLACK);
		
		NoFightButton = new JButton("No! I am afraid");
		NoFightButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		NoFightButton.setForeground(Color.WHITE);
		NoFightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.show(contentPane, "8");
			}
		});
		NoFightButton.setBackground(Color.BLACK);
		GroupLayout gl_arenaPanel = new GroupLayout(arenaPanel);
		gl_arenaPanel.setHorizontalGroup(
			gl_arenaPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_arenaPanel.createSequentialGroup()
					.addGap(92)
					.addComponent(arenaImage)
					.addContainerGap(92, Short.MAX_VALUE))
				.addGroup(gl_arenaPanel.createSequentialGroup()
					.addGap(229)
					.addComponent(NoFightButton)
					.addPreferredGap(ComponentPlacement.RELATED, 387, Short.MAX_VALUE)
					.addComponent(yesFightButton)
					.addGap(174))
		);
		gl_arenaPanel.setVerticalGroup(
			gl_arenaPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_arenaPanel.createSequentialGroup()
					.addGap(5)
					.addComponent(arenaImage, GroupLayout.PREFERRED_SIZE, 468, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_arenaPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(NoFightButton)
						.addComponent(yesFightButton))
					.addContainerGap(47, Short.MAX_VALUE))
		);
		arenaPanel.setLayout(gl_arenaPanel);
		
		
		///////////////////////////////////////////////
		//Fight Panel
		///////////////////////////////////////////////
		
		
		Player player = new Player(ourPlayer.getHP(),ourPlayer.getRP());
		Enemy enemy = new Enemy(100,0);
		fight = new Fight();
		
		fight.createPlayer(player);	
		fight.createEnemy(enemy);
		
		/*if(isFightOver==true) {
			Fight fight = new Fight();
			fight.createPlayer(player);	
			fight.createEnemy(enemy);
			//btnNewButton_2.setVisible(true);
			runAwayButton.setText("Run Away!");
		}
		*/
		JPanel fightPanel = new JPanel();
		fightPanel.setBackground(Color.BLACK);
		contentPane.add(fightPanel, "fight");
		
		fightLabel = new JLabel("What do you want to do?");
		fightLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fightLabel.setForeground(Color.WHITE);
		fightLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fightLabel.setBackground(Color.BLACK);
		fightLabel.setOpaque(true);
		
		btnNewButton_2 = new JButton("attack!");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fight.playerAttack();
				if(fight.characters.get(1).getHP()<1||fight.characters.get(0).getHP()<0) {
					fight.arenafightOver();
					isFightOver=true;
					btnNewButton_2.setVisible(false);
					endTheGameB.setVisible(true);
					runAwayButton.setText("Go Back");
					NoFightButton.setText("Go back to the Town");
					
				}
			fightLabel.setText(fight.getFightMessage());
			enemyHP.setText(""+fight.characters.get(1).getHP());
			fightHP.setText(""+fight.characters.get(0).getHP());
			}
		});
		
		enemyImg = new JLabel("");
		enemyImg.setIcon(new ImageIcon(UI.class.getResource("/resources/enemy1.jpg")));
		enemyImg.setOpaque(true);
		
		runAwayButton = new JButton("Run Away");
		runAwayButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		runAwayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.show(contentPane, "9");
			}
		});
		runAwayButton.setForeground(Color.WHITE);
		runAwayButton.setBackground(Color.BLACK);
		
		fightHP = new JLabel(""+fight.characters.get(0).getHP());
		fightHP.setHorizontalAlignment(SwingConstants.CENTER);
		fightHP.setAlignmentY(Component.TOP_ALIGNMENT);
		fightHP.setDisabledIcon(new ImageIcon(UI.class.getResource("/resources/frame.jpg")));
		fightHP.setOpaque(true);
		fightHP.setForeground(Color.WHITE);
		fightHP.setBackground(Color.BLACK);
		
		enemyHP = new JLabel(""+enemy.getHP());
		enemyHP.setForeground(Color.WHITE);
		enemyHP.setHorizontalAlignment(SwingConstants.CENTER);
		enemyHP.setBackground(Color.BLACK);
		enemyHP.setOpaque(true);
		
		JLabel hptext = new JLabel("Your HP");
		hptext.setForeground(Color.WHITE);
		hptext.setBackground(Color.BLACK);
		hptext.setOpaque(true);
		
		JLabel enemyHPText = new JLabel("Enemy HP");
		enemyHPText.setForeground(Color.WHITE);
		enemyHPText.setOpaque(true);
		enemyHPText.setBackground(Color.BLACK);
		
		endTheGameB = new JButton("");
		endTheGameB.setContentAreaFilled(false);
		endTheGameB.setFocusPainted(false);
		endTheGameB.setBorderPainted(false);
		endTheGameB.setVisible(false);
		endTheGameB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameOverMessage.setText("You killed the King and Take Your Revenge! You are a Hero...");
				c1.show(contentPane, "GameOver");
			}
		});
		endTheGameB.setForeground(Color.BLACK);
		endTheGameB.setBackground(Color.BLACK);
		GroupLayout gl_fightPanel = new GroupLayout(fightPanel);
		gl_fightPanel.setHorizontalGroup(
			gl_fightPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_fightPanel.createSequentialGroup()
					.addGap(11)
					.addComponent(enemyImg)
					.addGroup(gl_fightPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_fightPanel.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_fightPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_fightPanel.createSequentialGroup()
									.addGroup(gl_fightPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(hptext)
										.addComponent(fightHP, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
									.addGap(265)
									.addGroup(gl_fightPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(enemyHP, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
										.addComponent(enemyHPText))
									.addGap(153))
								.addGroup(gl_fightPanel.createSequentialGroup()
									.addGroup(gl_fightPanel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(runAwayButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnNewButton_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
									.addGap(184))
								.addGroup(gl_fightPanel.createSequentialGroup()
									.addComponent(fightLabel, GroupLayout.PREFERRED_SIZE, 645, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED))))
						.addGroup(gl_fightPanel.createSequentialGroup()
							.addGap(302)
							.addComponent(endTheGameB, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(10, Short.MAX_VALUE))
		);
		gl_fightPanel.setVerticalGroup(
			gl_fightPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_fightPanel.createSequentialGroup()
					.addGroup(gl_fightPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_fightPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_fightPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(hptext)
								.addComponent(enemyHPText))
							.addGap(18)
							.addGroup(gl_fightPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(fightHP, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(enemyHP, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(fightLabel, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
							.addGap(62)
							.addComponent(btnNewButton_2)
							.addGap(49)
							.addComponent(runAwayButton))
						.addGroup(gl_fightPanel.createSequentialGroup()
							.addGap(15)
							.addComponent(enemyImg, GroupLayout.PREFERRED_SIZE, 514, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(32, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_fightPanel.createSequentialGroup()
					.addContainerGap(498, Short.MAX_VALUE)
					.addComponent(endTheGameB, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
		);
		fightPanel.setLayout(gl_fightPanel);
	
		
		///////////////////////////////////////////////
		//KingsPalaceEnterance
		///////////////////////////////////////////////
		
		JPanel kingPanel = new JPanel();
		kingPanel.setBackground(Color.BLACK);
		contentPane.add(kingPanel, "10");
		
		JLabel KingEnteranceImage = new JLabel("");
		KingEnteranceImage.setIcon(new ImageIcon(UI.class.getResource("/resources/King_s Enterance Image.jpg")));
		KingEnteranceImage.setOpaque(true);
		KingEnteranceImage.setBackground(Color.BLACK);
		
		KingsEnteranceText = new JLabel("Here is the moment you were waiting for.\r\n Now you have enough reputation to enter this room and take the revenge of your people.");
		KingsEnteranceText.setForeground(Color.WHITE);
		KingsEnteranceText.setHorizontalAlignment(SwingConstants.CENTER);
		KingsEnteranceText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		KingsEnteranceText.setBackground(Color.BLACK);
		KingsEnteranceText.setSize(new Dimension(200, 100));
		KingsEnteranceText.setOpaque(true);
		
		nextButtonEnterence1 = new JButton("");
		nextButtonEnterence1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				KingsEnteranceText.setText("But you have to be careful. The guards can come up at any point. Go and kill the king as soon as possible... ");
				kingFightButton.setVisible(true);
				nextButtonEnterence1.setVisible(false);
				
			}
		});
		nextButtonEnterence1.setIcon(new ImageIcon(UI.class.getResource("/resources/nextImg.jpg")));
		
		kingFightButton = new JButton("Go and Kill Him!");
		kingFightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.show(contentPane, "KingFight");
			}
		});
		kingFightButton.setVisible(false);
		kingFightButton.setForeground(Color.WHITE);
		kingFightButton.setBackground(Color.BLACK);
		kingFightButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		kingFightButton.setName("kingFightButton");
		GroupLayout gl_kingPanel = new GroupLayout(kingPanel);
		gl_kingPanel.setHorizontalGroup(
			gl_kingPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_kingPanel.createSequentialGroup()
					.addGroup(gl_kingPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_kingPanel.createSequentialGroup()
							.addGap(69)
							.addComponent(KingEnteranceImage, GroupLayout.PREFERRED_SIZE, 846, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_kingPanel.createSequentialGroup()
							.addGap(57)
							.addComponent(KingsEnteranceText, GroupLayout.PREFERRED_SIZE, 848, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(69, Short.MAX_VALUE))
				.addGroup(gl_kingPanel.createSequentialGroup()
					.addContainerGap(435, Short.MAX_VALUE)
					.addComponent(kingFightButton)
					.addGap(402)
					.addComponent(nextButtonEnterence1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_kingPanel.setVerticalGroup(
			gl_kingPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_kingPanel.createSequentialGroup()
					.addGap(2)
					.addComponent(KingEnteranceImage, GroupLayout.PREFERRED_SIZE, 367, GroupLayout.PREFERRED_SIZE)
					.addGap(48)
					.addComponent(KingsEnteranceText, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
					.addGroup(gl_kingPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(kingFightButton)
						.addComponent(nextButtonEnterence1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		kingPanel.setLayout(gl_kingPanel);
		
		///////////////////////////////////////////////
		//KingFightPanel
		//////////////////////////////////////////////
		JPanel kingFightPanel = new JPanel();
		kingFightPanel.setBackground(Color.BLACK);
		contentPane.add(kingFightPanel, "KingFight");
		
		JLabel KingImg = new JLabel("");
		KingImg.setIcon(new ImageIcon(UI.class.getResource("/resources/KingImage.jpg")));
		KingImg.setOpaque(true);
		
		KingFightDialoge = new JLabel("King: Welcome my brave soldier. What is the reason you are here?");
		KingFightDialoge.setHorizontalAlignment(SwingConstants.CENTER);
		KingFightDialoge.setForeground(Color.WHITE);
		KingFightDialoge.setBackground(Color.BLACK);
		KingFightDialoge.setFont(new Font("Tahoma", Font.PLAIN, 14));
		KingFightDialoge.setOpaque(true);
		
		KillButton = new JButton("I will kill you!");
		KillButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				KingFightDialoge.setText("You: Yes I am brave, but not your soldier! I came here from Douala");
				KillButton.setVisible(false);
				DonotKillButton.setVisible(false);
				KF_nextB1.setVisible(true);
				fight.isKing=true;
			}
		});
		KillButton.setForeground(Color.WHITE);
		KillButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		KillButton.setBackground(Color.BLACK);
		
		DonotKillButton = new JButton("Just passing by");
		DonotKillButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KingFightDialoge.setText("King: How dare you! Guard's come and take this stupid pleb from here!");
				KillButton.setVisible(false);
				DonotKillButton.setVisible(false);
				KF_nextB2.setVisible(true);
				
			}
		});
		DonotKillButton.setForeground(new Color(255, 255, 255));
		DonotKillButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		DonotKillButton.setBackground(Color.BLACK);
		
		KF_nextB1 = new JButton("");
		KF_nextB1.setVisible(false);
		KF_nextB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KingFightDialoge.setText("You: You killed my family and destroyed my town. Now I will kill you and take my revenge!");
				KF_nextB1.setVisible(false);
				KF_nextB3.setVisible(true);
			}
		});
		KF_nextB1.setIcon(new ImageIcon(UI.class.getResource("/resources/nextImg.jpg")));
		KF_nextB1.setBackground(Color.BLACK);
		
		KF_nextB2 = new JButton("New button");
		KF_nextB2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameOverMessage.setText("Not a brave move brother. Guard's got you out of there and killed you.");
				c1.show(contentPane, "GameOver");
			}
		});
		KF_nextB2.setVisible(false);
		KF_nextB2.setIcon(new ImageIcon(UI.class.getResource("/resources/nextImg.jpg")));
		
		KF_nextB3 = new JButton("Fight!");
		KF_nextB3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enemyImg.setIcon(new ImageIcon(UI.class.getResource("/resources/KingImage.jpg")));
				c1.show(contentPane,"fight");
			}
		});
		KF_nextB3.setVisible(false);
		KF_nextB3.setForeground(Color.WHITE);
		KF_nextB3.setFont(new Font("Tahoma", Font.BOLD, 15));
		KF_nextB3.setBackground(Color.BLACK);
		GroupLayout gl_kingFightPanel = new GroupLayout(kingFightPanel);
		gl_kingFightPanel.setHorizontalGroup(
			gl_kingFightPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_kingFightPanel.createSequentialGroup()
					.addGroup(gl_kingFightPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_kingFightPanel.createSequentialGroup()
							.addGap(2)
							.addComponent(KingImg, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_kingFightPanel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_kingFightPanel.createSequentialGroup()
									.addGap(36)
									.addComponent(KingFightDialoge, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_kingFightPanel.createSequentialGroup()
									.addGap(283)
									.addGroup(gl_kingFightPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(KillButton, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
										.addComponent(DonotKillButton)))
								.addGroup(Alignment.TRAILING, gl_kingFightPanel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(KF_nextB3)
									.addGap(241))))
						.addGroup(gl_kingFightPanel.createSequentialGroup()
							.addGap(668)
							.addComponent(KF_nextB2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
							.addComponent(KF_nextB1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_kingFightPanel.setVerticalGroup(
			gl_kingFightPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_kingFightPanel.createSequentialGroup()
					.addGroup(gl_kingFightPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_kingFightPanel.createSequentialGroup()
							.addGap(37)
							.addComponent(KingImg, GroupLayout.PREFERRED_SIZE, 487, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_kingFightPanel.createSequentialGroup()
							.addGap(98)
							.addComponent(KingFightDialoge, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(KillButton)
							.addGap(52)
							.addComponent(DonotKillButton)
							.addGap(52)
							.addComponent(KF_nextB3)))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_kingFightPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(KF_nextB1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(KF_nextB2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		kingFightPanel.setLayout(gl_kingFightPanel);
		
		
		///////////////////////////////////////////////
		//Market
		///////////////////////////////////////////////
		
		JPanel marketPanel = new JPanel();
		marketPanel.setBackground(Color.BLACK);
		contentPane.add(marketPanel, "11");
		
		JPanel marketMessagePanel = new JPanel();
		
		JLabel MarketImg = new JLabel("");
		MarketImg.setIcon(new ImageIcon(UI.class.getResource("/resources/MarketInside1.jpg")));
		MarketImg.setBackground(Color.BLACK);
		MarketImg.setOpaque(true);
		
		JButton MarketNoButton = new JButton("No!");
		MarketNoButton.setBackground(Color.BLACK);
		
		JButton marketYesButton = new JButton("Yes!");
		marketYesButton.setBackground(Color.BLACK);
		
		GroupLayout gl_marketPanel = new GroupLayout(marketPanel);
		gl_marketPanel.setHorizontalGroup(
			gl_marketPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_marketPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_marketPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(marketMessagePanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(MarketImg, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 959, Short.MAX_VALUE))
					.addContainerGap(15, Short.MAX_VALUE))
				.addGroup(gl_marketPanel.createSequentialGroup()
					.addGap(126)
					.addComponent(MarketNoButton)
					.addPreferredGap(ComponentPlacement.RELATED, 486, Short.MAX_VALUE)
					.addComponent(marketYesButton)
					.addGap(241))
		);
		gl_marketPanel.setVerticalGroup(
			gl_marketPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_marketPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(MarketImg, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(marketMessagePanel, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addGroup(gl_marketPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(MarketNoButton)
						.addComponent(marketYesButton))
					.addContainerGap())
		);
		marketMessagePanel.setLayout(marketC1);
		
		JLabel Marketmessage1 = new JLabel("");
		Marketmessage1.setBackground(Color.BLACK);
		Marketmessage1.setIcon(new ImageIcon(UI.class.getResource("/resources/marketMessage1.jpg")));
		Marketmessage1.setOpaque(true);
		marketMessagePanel.add(Marketmessage1, "m1");
		marketPanel.setLayout(gl_marketPanel);
		
		JLabel MarketMessage2 = new JLabel("");
		MarketMessage2.setIcon(new ImageIcon(UI.class.getResource("/resources/MarketMessage2.jpg")));
		MarketMessage2.setOpaque(true);
		MarketMessage2.setBackground(Color.BLACK);
		marketMessagePanel.add(MarketMessage2, "m2");
		
		
		if(shop==false) {
			marketYesButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					marketC1.show(marketMessagePanel, "m2");
					shop=true;
				}
			});
			
			MarketNoButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					c1.show(contentPane,"8");
				}
			});
		}
		if(shop==true) {
			marketYesButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					marketC1.show(marketMessagePanel, "m1");
				}
			});
			marketYesButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					marketC1.show(marketMessagePanel, "m1");
				}
			});
		}
		
		
		///////////////////////////////////////////////
		//CreditsPanel
		///////////////////////////////////////////////
		JPanel creditsPanel = new JPanel();
		creditsPanel.setBackground(Color.BLACK);
		contentPane.add(creditsPanel, "12");
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(UI.class.getResource("/resources/Credit.jpg")));
		lblNewLabel.setSize(new Dimension(800, 500));
		lblNewLabel.setPreferredSize(new Dimension(800, 500));
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(UI.class.getResource("/resources/nextImg.jpg")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.first(contentPane);
			}
		});
		button.setBackground(Color.DARK_GRAY);
		
		JButton EmergencyB = new JButton("");
		EmergencyB.setBorderPainted(false);
		EmergencyB.setContentAreaFilled(false);
		EmergencyB.setFocusPainted(false);
		EmergencyB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				c1.show(contentPane,"KingFight");
			}
		});
		EmergencyB.setBackground(Color.BLACK);
		GroupLayout gl_creditsPanel = new GroupLayout(creditsPanel);
		gl_creditsPanel.setHorizontalGroup(
			gl_creditsPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_creditsPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(EmergencyB, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addGroup(gl_creditsPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_creditsPanel.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(38))
						.addGroup(gl_creditsPanel.createSequentialGroup()
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_creditsPanel.setVerticalGroup(
			gl_creditsPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_creditsPanel.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_creditsPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(EmergencyB, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGap(11))
		);
		creditsPanel.setLayout(gl_creditsPanel);
		
		///////////////////////////////////////////////
		//GameOver
		///////////////////////////////////////////////
		JPanel GameOver = new JPanel();
		GameOver.setBackground(Color.BLACK);
		contentPane.add(GameOver, "GameOver");
		
		JLabel GameOverImage = new JLabel("");
		GameOverImage.setIcon(new ImageIcon(UI.class.getResource("/resources/GameOver.jpg")));
		GameOverImage.setBackground(Color.BLACK);
		GameOverImage.setOpaque(true);
		
		GameOverMessage = new JLabel("New label");
		GameOverMessage.setHorizontalAlignment(SwingConstants.CENTER);
		GameOverMessage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GameOverMessage.setBackground(Color.BLACK);
		GameOverMessage.setForeground(Color.WHITE);
		GameOverMessage.setOpaque(true);
		GroupLayout gl_GameOverLose = new GroupLayout(GameOver);
		gl_GameOverLose.setHorizontalGroup(
			gl_GameOverLose.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_GameOverLose.createSequentialGroup()
					.addGroup(gl_GameOverLose.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_GameOverLose.createSequentialGroup()
							.addGap(145)
							.addComponent(GameOverImage, GroupLayout.PREFERRED_SIZE, 695, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_GameOverLose.createSequentialGroup()
							.addGap(5)
							.addComponent(GameOverMessage, GroupLayout.PREFERRED_SIZE, 964, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		gl_GameOverLose.setVerticalGroup(
			gl_GameOverLose.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_GameOverLose.createSequentialGroup()
					.addGap(5)
					.addComponent(GameOverImage, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(GameOverMessage, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(33, Short.MAX_VALUE))
		);
		GameOver.setLayout(gl_GameOverLose);
	}
	public void createEvents(){
			
		c1.show(contentPane, "1");
		
		
	}
}
