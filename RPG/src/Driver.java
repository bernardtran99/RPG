import java.awt.Dimension;	// Import the needed java extensions
import java.awt.event.WindowEvent;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Driver {	// Create the Driver Class
	public static void main(String[] args) throws InterruptedException {	// Creates the main method
		String a = JOptionPane.showInputDialog("What is your name?");	// Prompts the user for his/her name
		Map map = new Map(a, "Wolf", 10, 5, 0, 1, 1, 1);	// Creates the Map object
		JFrame frame = new JFrame("RPG");	// Creates the RPG JFrame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// Sets the JFrame to close when X button is clicked
		frame.setPreferredSize(new Dimension(710, 640));	// Sets the size of the JFrame (607)
		frame.add(map);	// Adds the map object to the JFrame
		frame.pack();	// Sets the Window to the size of the JFrame
		frame.setVisible(true);	// Makes the JFrame visible
		frame.setResizable(false);	// Prevents the JFrame from being resized

		while (map.Health >= 0) {	// Creates the while loop that will remove the JFrame if the player is killed
			if (map.Health <= 0) {	// If statement to check if the players health is 0
				frame.dispatchEvent(new WindowEvent(frame,WindowEvent.WINDOW_CLOSING));	// Closes the JFrame
			}
			TimeUnit.SECONDS.sleep(3); // Creates a delay that will allow the while loop enough time to check if the player is dead
		}
	}
}