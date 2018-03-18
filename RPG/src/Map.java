import java.awt.Color;	// Imports the needed Java extensions
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Map extends JPanel implements KeyListener {	// Creates the map class/ extends JPanel/ implements KeyListener 
	static String Name, EnemyName;	// Creates the instance data needed for the program
	static int Health, EnemyHealth, Exp, Level, Attack, ExpGain;
	int x = 240, y = 240; // Sets initial position of the player
	private BufferedImage image, image1, image2; // Creates the images used in the program

	public Map(String a, String b, int c, int d, int e, int f, int g, int h) { // Create the Map constructor
		Name = a;	// Assigns the instance data to the parameters
		EnemyName = b;
		Health = c;
		EnemyHealth = d;
		Exp = e;
		Level = f;
		Attack = g;
		ExpGain = h;
		addKeyListener(this);	// Adds the KeyListener to the Constructor, which is in the JFrame
		setFocusable(true);	// Sets the JFrame to Focus which allows the key press to work on the JFrame
		setFocusTraversalKeysEnabled(false); // Does not allow the Tab key to shift the focus of the keys
		URL resource1 = getClass().getResource("Castle.png");	// Imports the Castle image
		try {	// The try statement executes the statement below which can throw exceptions (errors)
			image = ImageIO.read(resource1);	// Tries to read the Castle image
		} catch (IOException x) {	// Catch statement is used when ever an exception is thrown in the try statement (whenever there is an error)
			x.printStackTrace();	// The printStackTrace() method prints where there is an exception (error)
		}
		URL resource2 = getClass().getResource("Grass.png");	// Imports the grass image
		try {	// The try statement executes the statement below which can throw exceptions (errors)
			image1 = ImageIO.read(resource2);	// Tries to read the Castle image
		} catch (IOException y) {	// Catch statement is used when ever an exception is thrown in the try statement (whenever there is an error)
			y.printStackTrace();	// The printStackTrace() method prints where there is an exception (error)
		}
		URL resource3 = getClass().getResource("Adventurer.png");	// Imports the Adventurer image
		try {	// The try statement executes the statement below which can throw exceptions (errors)
			image2 = ImageIO.read(resource3);	// Tries to read the Castle image
		} catch (IOException z) {	// Catch statement is used when ever an exception is thrown in the try statement (whenever there is an error)
			z.printStackTrace();	// The printStackTrace() method prints where there is an exception (error)
		}
	}

	public void paint(Graphics g) {	// Creates the paint method
		g.setColor(new Color(76, 178, 42));	// Sets the color green for the background
		g.fillRect(0, 0, 600, 600);	// Creates the green rectangle background
		for (int i = 0; i <= 540; i += 60) {	// Draws the grass images for the background
			g.drawImage(image1, 0, i, this);
		}
		for (int i = 0; i <= 540; i += 60) {	// Draws the grass images for the background
			g.drawImage(image1, 60, i, this);
		}
		for (int i = 0; i <= 540; i += 60) {	// Draws the grass images for the background
			g.drawImage(image1, 120, i, this);
		}
		for (int i = 0; i <= 540; i += 60) {	// Draws the grass images for the background
			g.drawImage(image1, 180, i, this);
		}
		for (int i = 0; i <= 540; i += 60) {	// Draws the grass images for the background
			g.drawImage(image1, 240, i, this);
		}
		for (int i = 0; i <= 540; i += 60) {	// Draws the grass images for the background
			g.drawImage(image1, 300, i, this);
		}
		for (int i = 0; i <= 540; i += 60) {	// Draws the grass images for the background
			g.drawImage(image1, 360, i, this);
		}
		for (int i = 0; i <= 540; i += 60) {	// Draws the grass images for the background
			g.drawImage(image1, 420, i, this);
		}
		for (int i = 0; i <= 540; i += 60) {	// Draws the grass images for the background
			g.drawImage(image1, 480, i, this);
		}
		for (int i = 0; i <= 540; i += 60) {	// Draws the grass images for the background
			g.drawImage(image1, 540, i, this);
		}
		g.drawImage(image, 240, 240, this);	// Draws the Castle image in the center
		g.drawImage(image, 300, 300, this);	// Draws the Castle image in the center
		g.drawImage(image, 240, 300, this);	// Draws the Castle image in the center
		g.drawImage(image, 300, 240, this);	// Draws the Castle image in the center
		g.setColor(Color.orange); // Sets the color to orange
		for (int i = 0; i <= 600; i += 60) {	// Draws the orange guide lines
			g.drawLine(0, i, 600, i);
		}
		for (int i = 0; i <= 600; i += 60) {	// Draws the orange guide lines
			g.drawLine(i, 0, i, 600);
		}
		g.setColor(Color.red);	// Sets the color to red
		g.drawImage(image2, x, y, this);	// Draws the player icon
		g.setColor(Color.white);	// Sets the color to white
		g.fillRect(600, 0, 94, 600);	// Draws the rectangle that the stats panel goes on
		g.setColor(Color.black);	// Sets the Color to black
		g.drawString(Name, x + 5, y + 11);	// Draws the name of the player above the player icon
		g.drawString("Level: " + Level, 610, 17);	// Prints the Level in the top right corner
		g.drawString("Exp: " + Exp + "/" + (Level * 5), 610, 27); // Prints the experience points in the top right corner
		g.drawString("Health: " + Health + "/10", 610, 37);	// Prints the Health in the top right corner

	}

	public void keyReleased(KeyEvent e) {	// Creates the keyReleased method which will run when the specific key is released 
		Random rand = new Random();	// Creates the random object
		int percent = rand.nextInt(10);	// Creates an integer which will determine whether the player will encounter an enemy
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {	// If this arrow key is pressed this if statement will run
			x += 60;	// Moves the player icon 60 pixels or 1 grid
			if (x > 540) {	// Makes sure that the player does not go beyond the bounds of the map
				x -= 60;	// If the player tries to move out of the map, It will prevent the player from moving outside the map
			} else if (x < 0) {	// Makes sure that the player does not go beyond the bounds of the map
				x += 60;	// If the player tries to move out of the map, It will prevent the player from moving outside the map
			}
			repaint();	// Repaints so that the player moves
			if (x < 240 || y < 240) {	// Checks the position of the player to see if it will battle or not
				if (percent == 0) {	// Checks the random number to see if the player will encounter a battle
					Battle battle = new Battle(Name, EnemyName, Health, EnemyHealth, Exp, Level, Attack, ExpGain); // Creates a new battle object and JFrame
				}
			} else if (x > 300 || y > 300) {	// Checks the position of the player to see if it will battle or not
				if (percent == 0) {	// Checks the random number to see if the player will encounter a battle
					Battle battle = new Battle(Name, EnemyName, Health, EnemyHealth, Exp, Level, Attack, ExpGain);	// Creates a new battle object and JFrame
				}
			} else {
				Health = 10;	// If the player is in the city, then the player will restore health
			}
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {	// If this arrow key is pressed this if statement will run
			x -= 60;	// Moves the player icon 60 pixels or 1 grid
			if (x > 600) {	// Makes sure that the player does not go beyond the bounds of the map
				x -= 60;	// If the player tries to move out of the map, It will prevent the player from moving outside the map
			} else if (x < 0) {	// Makes sure that the player does not go beyond the bounds of the map
				x += 60;	// If the player tries to move out of the map, It will prevent the player from moving outside the map
			}
			repaint();	// Repaints so that the player moves
			if (x < 240 || y < 240) {	// Checks the position of the player to see if it will battle or not
				if (percent == 0) {	// Checks the random number to see if the player will encounter a battle
					Battle battle = new Battle(Name, EnemyName, Health, EnemyHealth, Exp, Level, Attack, ExpGain);	// Creates a new battle object and JFrame
				}
			} else if (x > 300 || y > 300) {	// Checks the position of the player to see if it will battle or not
				if (percent == 0) {	// Checks the random number to see if the player will encounter a battle
					Battle battle = new Battle(Name, EnemyName, Health,	EnemyHealth, Exp, Level, Attack, ExpGain);	// Creates a new battle object and JFrame
				}
			} else {	
				Health = 10;	// If the player is in the city, then the player will restore health
			}
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {	// If this arrow key is pressed this if statement will run
			y -= 60;	// Moves the player icon 60 pixels or 1 grid
			if (y > 600) {	// Makes sure that the player does not go beyond the bounds of the map
				y -= 60;	// If the player tries to move out of the map, It will prevent the player from moving outside the map
			} else if (y < 0) {	// Makes sure that the player does not go beyond the bounds of the map
				y += 60;	// If the player tries to move out of the map, It will prevent the player from moving outside the map
			}
			repaint();	// Repaints so that the player moves
			if (x < 240 || y < 240) {	// Checks the position of the player to see if it will battle or not
				if (percent == 0) {	// Checks the random number to see if the player will encounter a battle
					Battle battle = new Battle(Name, EnemyName, Health, EnemyHealth, Exp, Level, Attack, ExpGain);	// Creates a new battle object and JFrame
				}
			} else if (x > 300 || y > 300) {	// Checks the position of the player to see if it will battle or not
				if (percent == 0) {	// Checks the random number to see if the player will encounter a battle
					Battle battle = new Battle(Name, EnemyName, Health, EnemyHealth, Exp, Level, Attack, ExpGain);	// Creates a new battle object and JFrame
				}
			} else {
				Health = 10;	// If the player is in the city, then the player will restore health
			}
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {	// If this arrow key is pressed this if statement will run
			y += 60;	// Moves the player icon 60 pixels or 1 grid
			if (y > 540) {	// Makes sure that the player does not go beyond the bounds of the map
				y -= 60;	// If the player tries to move out of the map, It will prevent the player from moving outside the map
			} else if (y < 0) {	// Makes sure that the player does not go beyond the bounds of the map
				y += 60;	// If the player tries to move out of the map, It will prevent the player from moving outside the map
			}
			repaint();	// Repaints so that the player moves
			if (x < 240 || y < 240) {	// Checks the position of the player to see if it will battle or not
				if (percent == 0) {	// Checks the random number to see if the player will encounter a battle
					Battle battle = new Battle(Name, EnemyName, Health, EnemyHealth, Exp, Level, Attack, ExpGain);	// Creates a new battle object and JFrame
				}
			} else if (x > 300 || y > 300) {	// Checks the position of the player to see if it will battle or not
				if (percent == 0) {	// Checks the random number to see if the player will encounter a battle
					Battle battle = new Battle(Name, EnemyName, Health, EnemyHealth, Exp, Level, Attack, ExpGain);	// Creates a new battle object and JFrame
				}
			} else {
				Health = 10;	// If the player is in the city, then the player will restore health
			}
		}
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}
}