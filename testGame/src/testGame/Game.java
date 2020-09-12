package testGame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import testGame.Game.TitleScreenHandler;

public class Game {
	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
	JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 70);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
	JButton startButton;
	JButton choiceButton[] = new JButton[4];
	String[] buttons = {"Choice 1.", "Choice 2.", "Choice 3.", "Choice 4."};
	JTextArea mainTextArea;
	int playerHP, monsterHP, silverRing;
	String weapon, position;	
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();
	
	public Game() {
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.setVisible(true);
		con = window.getContentPane();
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("NEW FRONTIER");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.black);
		
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFocusPainted(false);
		startButton.setFont(normalFont);
		startButton.addActionListener(tsHandler);		
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		
		con.add(titleNamePanel);
		con.add(startButtonPanel); 
	}
	
	public void createGameScreen() {
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);
		
		mainTextArea = new JTextArea("This is the main text area. This game is going to be great; i am sure of it!!!!");
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);	
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 150);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4, 1));
		con.add(choiceButtonPanel);
		for(int i = 0; i < choiceButton.length; i++) {
			choiceButton[i] = new JButton(buttons[i]);
			choiceButton[i].setBackground(Color.black);
			choiceButton[i].setForeground(Color.white);
			choiceButton[i].setFont(normalFont);
			choiceButton[i].setFocusPainted(false);
			choiceButton[i].addActionListener(choiceHandler);
			choiceButton[i].setActionCommand("c" + i);
			choiceButtonPanel.add(choiceButton[i]);
		}	
		playerPanel = new JPanel();
		playerPanel.setBounds(100, 15, 600, 50);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1, 4));
		con.add(playerPanel);
		hpLabel = new JLabel("HP:");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		playerPanel.add(hpLabel);
		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.white);
		playerPanel.add(hpLabelNumber);
		weaponLabel = new JLabel("Weapon:");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);
		playerPanel.add(weaponLabel);
		weaponLabelName = new JLabel();
		weaponLabelName.setFont(normalFont);
		weaponLabelName.setForeground(Color.white);
		playerPanel.add(weaponLabelName);
		playerSetup();
	}
	
	public void playerSetup() {
		playerHP = 15;
		monsterHP = 20;
		weapon = "Knife";
		weaponLabelName.setText(weapon);
		hpLabelNumber.setText("" + playerHP);
		townGate();
	}
	
	public void townGate() {
		position = "townGate";
		mainTextArea.setText("You are at the gate of the town. \nA guard is standing in front of you. \n\nWhat do you do?");
		choiceButton[0].setText("Talk to the guard");
		choiceButton[1].setText("Attack the guard");
		choiceButton[2].setText("Leave");
		choiceButton[3].setText("");
	}
	
	public void talkGuard() {
		position = "talkGuard";
		mainTextArea.setText("Guard: Hello stranger. I have never seen your face. \nI'm sorry but we cannot let a stranger enter our town.");
		choiceButton[0].setText(">");
		choiceButton[1].setText("");
		choiceButton[2].setText("");
		choiceButton[3].setText("");
	}
	
	public void attackGuard() {
		position = "attackGuard";
		mainTextArea.setText("Guard: Hey don't be stupid!\n\nThe guard fought back and hit you hard.\n(You receive 3 damage)");
		playerHP = playerHP - 3;
		hpLabelNumber.setText("" + playerHP);
		choiceButton[0].setText(">");
		choiceButton[1].setText("");
		choiceButton[2].setText("");
		choiceButton[3].setText("");
	}
	
	public void crossRoad() {
		position = "crossRoad";
		mainTextArea.setText("You are at a crossroad.\nIf you go south, you will go back to the town.");
		choiceButton[0].setText("Go North");
		choiceButton[1].setText("Go East");
		choiceButton[2].setText("Go South");
		choiceButton[3].setText("Go West");
	}
	
	public void north() {
		position = "north";
		mainTextArea.setText("There is a river. \nYou drink the water and rest at the riverside. \n\n(Your HP is recovered by 2)");
		playerHP = playerHP + 2;
		hpLabelNumber.setText("" + playerHP);
		choiceButton[0].setText("Go South");
		choiceButton[1].setText("");
		choiceButton[2].setText("");
		choiceButton[3].setText("");
	}
	
	public void east() {
		position = "east";
		mainTextArea.setText("You walked into a forest and found a powerful sword!\n\n(You obtained a sword.)");
		weapon = "Sword";
		weaponLabelName.setText(weapon);
		choiceButton[0].setText("Go West");
		choiceButton[1].setText("");
		choiceButton[2].setText("");
		choiceButton[3].setText("");
	}
	
	public void west() {
		position = "west";
		mainTextArea.setText("You encountered a goblin!");
		choiceButton[0].setText("Fight");
		choiceButton[1].setText("Run");
		choiceButton[2].setText("");
		choiceButton[3].setText("");
	}
	
	public void fight() {
		position = "fight";
		mainTextArea.setText("Monster HP: " + monsterHP + "\n\nWhat do you do?");
		choiceButton[0].setText("Attack");
		choiceButton[1].setText("Run");
		choiceButton[2].setText("");
		choiceButton[3].setText("");
	}
	
	public void playerAttack() {
		position = "playerAttack";
		int playerDamage = 0;
		if(weapon.equals("Knife"))
			playerDamage = new java.util.Random().nextInt(5);
		else if(weapon.equals("Sword"))
			playerDamage = new java.util.Random().nextInt(8);
		if(monsterHP <= playerDamage)
			monsterHP = 0;
		else {
			if(playerDamage == 0)
				mainTextArea.setText("The monster dodged you and received " + playerDamage + " damage!");
			else
				mainTextArea.setText("You attacked the monster and gave it " + playerDamage + " damage!");
			monsterHP = monsterHP - playerDamage;
		}
		choiceButton[0].setText(">");
		choiceButton[1].setText("");
		choiceButton[2].setText("");
		choiceButton[3].setText("");
	}
	
	public void monsterAttack() {
		position = "monsterAttack";
		int monsterDamage = 0;
		monsterDamage = new java.util.Random().nextInt(6);
		if(playerHP <= monsterDamage)
			playerHP = 0;
		else {
			if(monsterDamage == 0)
				mainTextArea.setText("You dodged the monster and received " + monsterDamage + " damage!");
			else
				mainTextArea.setText("The monster attacked you and gave you " + monsterDamage + " damage!");
			playerHP = playerHP - monsterDamage;
		}
		hpLabelNumber.setText("" + playerHP);
		choiceButton[0].setText(">");
		choiceButton[1].setText("");
		choiceButton[2].setText("");
		choiceButton[3].setText("");
	}
	
	public void win() {
		position = "win";
		mainTextArea.setText("You defeated the monster!\nThe monster dropped a ring!\n\n(You obtained a Silver Ring)");
		silverRing = 1;
//		weaponLabelName.setText(weapon  + " Silver Ring");
		choiceButton[0].setText("Go East");
		choiceButton[1].setText("");
		choiceButton[2].setText("");
		choiceButton[3].setText("");
	}
	
	public void lose() {
		position = "lose";
		mainTextArea.setText("You are dead!\nGAME OVER");
		choiceButton[0].setText("");
		choiceButton[1].setText("");
		choiceButton[2].setText("");
		choiceButton[3].setText("");
		choiceButton[0].setVisible(false);
		choiceButton[1].setVisible(false);
		choiceButton[2].setVisible(false);
		choiceButton[3].setVisible(false);
	}
	
	public void ending() {
		position = "ending";
		mainTextArea.setText("Guard: Oh you killed the goblin!\nThank you so much. You are a true hero!\nWelcome to our town!\n\nTHE END");
		choiceButton[0].setText("");
		choiceButton[1].setText("");
		choiceButton[2].setText("");
		choiceButton[3].setText("");
		choiceButton[0].setVisible(false);
		choiceButton[1].setVisible(false);
		choiceButton[2].setVisible(false);
		choiceButton[3].setVisible(false);
		
	}
	
	public class TitleScreenHandler implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			createGameScreen();
		}
	}
	
	public class ChoiceHandler implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			String yourChoice = event.getActionCommand();
			switch(position) {
			case "townGate":
				switch(yourChoice) {
				case "c0": 
					if(silverRing == 1)
						ending();
					else
						talkGuard(); break;
				case "c1": attackGuard(); break;
				case "c2": crossRoad(); break;
				case "c3": break;
				}
				break;
			case "talkGuard":
				switch(yourChoice) {
				case "c0": townGate(); break;
				}
				break;
			case "attackGuard":
				switch(yourChoice) {
				case "c0": townGate(); break;
				}
				break;
			case "crossRoad":
				switch(yourChoice) {
				case "c0": north(); break;
				case "c1": east(); break;
				case "c2": townGate(); break;
				case "c3": west(); break;
				}
				break;
			case "north":
				switch(yourChoice) {
				case "c0": crossRoad(); break;
				}
				break;
			case "east":
				switch(yourChoice) {
				case "c0": crossRoad(); break;
				}
				break;
			case "west":
				switch(yourChoice) {
				case "c0": fight(); break;
				case "c1": crossRoad(); break;
				}
				break;
			case "fight":
				switch(yourChoice) {
				case "c0": playerAttack(); break;
				case "c1": crossRoad(); break;
				}
				break;
			case "playerAttack":
				switch(yourChoice) {
				case "c0": 
					if(monsterHP < 1)
						win();
					else
						monsterAttack(); 
				break;
				}
				break;
			case "monsterAttack":
				switch(yourChoice) {
				case "c0": 
					if(playerHP < 1)
						lose();
					else
						fight(); 
				break;
				}
				break;
			case "win":
				switch(yourChoice) {
				case "c0": crossRoad(); break;
				}
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		new Game();
		
	}
}