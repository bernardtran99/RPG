import java.awt.Color;	// Imports the needed Java extensions
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class Battle extends Map {	// Creates the Battle Class/ extends Map
	JFrame frame1;	// Creates the JFrame for map
	JPanel panel1, panel2, panel3, panel4, panel5;	// Creates the JPanels needed for the program
	JButton attack, runAway;	// Creates the JButtons needed for the programs
	ImageIcon image1, image2;	// Creates the ImageIcons needed for the program
	JLabel label1, label2, label3, label4, label5, label6, label7, label8;	// Create the JLabels needed for the program

	public Battle(String a, String b, int c, int d, int e, int f, int g, int h) {	// Creates the Battle Constructor, and gives the parameters
		super(a, b, c, d, e, f, g, h);	// Gives the parameters a value which is extended by the map class
		SpringLayout layout1 = new SpringLayout();	// Creates the SpringLayout needed for the organization and placement of the JObjects
		SpringLayout layout2 = new SpringLayout();	// Creates the SpringLayout needed for the organization and placement of the JObjects
		image1 = new ImageIcon(getClass().getResource("PlayerImage.png"));	// Imports the Player image
		image2 = new ImageIcon(getClass().getResource("Wolf.jpg"));	// Imports the Wolf image

		frame1 = new JFrame("Battle");	// Creates the JFrame used in the battle class
		panel1 = new JPanel();	// Creates the JPanel
		panel2 = new JPanel();	// Creates the JPanel
		panel3 = new JPanel();	// Creates the JPanel
		panel4 = new JPanel();	// Creates the JPanel
		panel5 = new JPanel();	// Creates the JPanel
		frame1.getContentPane().setBackground(new Color(76, 178, 42));	// Sets the background color
		frame1.setPreferredSize(new Dimension(607, 629));	// Sets the size of the JFrame
		frame1.pack();	// Packs the window so that it is the size of the JFrame
		frame1.setVisible(true);	// Makes the JFrame visible
		frame1.setResizable(false);	// Does not allow the JFrame to be resized

		label1 = new JLabel(image1);	// Adds the image to the JLabel
		label2 = new JLabel(Name);	// Adds the name to the JLabel
		label3 = new JLabel("LVL " + Level);	// Adds the level to the JLabel

		label4 = new JLabel(image2);	// Adds the image to the JLabel
		label5 = new JLabel(EnemyName);	// Adds the enemy name to the JLabel
		label6 = new JLabel("LVL 1");	// Adds the enemy level to the JLabel

		label7 = new JLabel("Health: " + Health);	// Adds the health to JLabel 

		label8 = new JLabel("Health: " + EnemyHealth);	// Adds the enemy health to the JLabel

		panel1.setPreferredSize(new Dimension(162, 26));	// Sets the dimensions of the JPanel
		panel1.setBackground(new Color(76, 178, 42));	// Sets the color of the JPanel

		panel2.setPreferredSize(new Dimension(160, 220));	// Sets the dimensions of the JPanel
		panel2.setBackground(Color.cyan);	// Sets the color of the JPanel

		panel3.setPreferredSize(new Dimension(160, 220));	// Sets the dimensions of the JPanel
		panel3.setBackground(Color.cyan);	// Sets the color of the JPanel

		panel4.setPreferredSize(new Dimension(160, 30));	// Sets the dimensions of the JPanel
		panel4.setBackground(Color.cyan);	// Sets the color of the JPanel

		panel5.setPreferredSize(new Dimension(160, 30));	// Sets the dimensions of the JPanel
		panel5.setBackground(Color.cyan);	// Sets the color of the JPanel

		attack = new JButton("Attack");	// Creates the Attack JButton
		runAway = new JButton("Run Away");	// Creates the Run JButton

		attack.addActionListener(new AttackListener());	// Adds the action listener to the JButton
		runAway.addActionListener(new RunListener());	// Adds the action listener to the JButton

		panel1.add(attack);	// Adds the JButton to the JPanel
		panel1.add(runAway);	// Adds the JButton to the JPanel

		panel2.add(label1);	// Adds the label to the panel
		panel2.add(label2);	// Adds the label to the panel
		panel2.add(label3);	// Adds the label to the panel

		panel3.add(label4);	// Adds the label to the panel
		panel3.add(label5);	// Adds the label to the panel
		panel3.add(label6);	// Adds the label to the panel

		panel4.add(label7);	// Adds the label to the panel

		panel5.add(label8);	// Adds the label to the panel

		panel1.setLayout(layout1);	// Sets the layout of the panel
		layout1.putConstraint(SpringLayout.SOUTH, attack, 0, SpringLayout.SOUTH, panel1);	// Sets the position of the button within the panel
		layout1.putConstraint(SpringLayout.SOUTH, runAway, 0, SpringLayout.SOUTH, panel1);	// Sets the position of the button within the panel
		layout1.putConstraint(SpringLayout.WEST, runAway, 71, SpringLayout.WEST, panel1);	// Sets the position of the button within the panel

		frame1.setLayout(layout2);	// Sets the layout of the frame
		layout2.putConstraint(SpringLayout.SOUTH, panel1, -30, SpringLayout.SOUTH, frame1);	// Sets the position of the panel within the frame
		layout2.putConstraint(SpringLayout.WEST, panel1, 220, SpringLayout.WEST, frame1);	// Sets the position of the panel within the frame
		layout2.putConstraint(SpringLayout.NORTH, panel2, 20, SpringLayout.NORTH, frame1);	// Sets the position of the panel within the frame
		layout2.putConstraint(SpringLayout.WEST, panel2, 40, SpringLayout.WEST, frame1);	// Sets the position of the panel within the frame
		layout2.putConstraint(SpringLayout.NORTH, panel3, 20, SpringLayout.NORTH, frame1);	// Sets the position of the panel within the frame
		layout2.putConstraint(SpringLayout.EAST, panel3, -40, SpringLayout.EAST, frame1);	// Sets the position of the panel within the frame
		layout2.putConstraint(SpringLayout.NORTH, panel4, 260, SpringLayout.NORTH, frame1);	// Sets the position of the panel within the frame
		layout2.putConstraint(SpringLayout.WEST, panel4, 40, SpringLayout.WEST, frame1);	// Sets the position of the panel within the frame
		layout2.putConstraint(SpringLayout.NORTH, panel5, 260, SpringLayout.NORTH, frame1);	// Sets the position of the panel within the frame
		layout2.putConstraint(SpringLayout.EAST, panel5, -40, SpringLayout.EAST, frame1);	// Sets the position of the panel within the frame

		frame1.add(panel1);	// Adds the panel to the frame
		frame1.add(panel2);	// Adds the panel to the frame
		frame1.add(panel3);	// Adds the panel to the frame
		frame1.add(panel4);	// Adds the panel to the frame
		frame1.add(panel5);	// Adds the panel to the frame
	}

	private class AttackListener implements ActionListener {	// Creates the Attack Listener Class/ implements ActionListener
		public void actionPerformed(ActionEvent e) {	// Creates the action performed method for the action listener
			Health -= 1;	// Player's health is subtracted by 1
			EnemyHealth -= Attack;	// Enemy's health is subtracted by 1
			if (Health <= 0) {	// Checks to see if the players health is 0
				JOptionPane.showMessageDialog(null, "You are Dead.", "", JOptionPane.INFORMATION_MESSAGE);	// Displays the dead player window
				frame1.dispose();	// Deletes the battle window
			}
			if (EnemyHealth <= 0) {	// Checks to see if the enemy health is 0
				JOptionPane.showMessageDialog(null, "You have killed the " + EnemyName + ".", "", JOptionPane.INFORMATION_MESSAGE);	// Displays the kill window
				JOptionPane.showMessageDialog(null, "You have gained " + ExpGain + " Exp.", "", JOptionPane.INFORMATION_MESSAGE);	// Displays players exp gain
				Exp += ExpGain;	// Adds the exp gain to the players total exp
				if (Exp == Level * 5) {	// Checks to see if the player's exp is equal to 5 times the level
					Level++;	// If it is, then the player has leveled up
					Attack++;	// Player's attack also levels up with the player level
					Exp = 0;	// Resets the players exp back to 0
					JOptionPane.showMessageDialog(null, "You have leveled up to LVL " + Level, "", JOptionPane.INFORMATION_MESSAGE);	// Displays the level up window
				}
				EnemyHealth = 5;	// Resets the enemy health back to 5
				frame1.dispose();	// Removes the battle window
			}
			label7.setText("Health: " + Health);	// Changes the health of the player
			label8.setText("Health: " + EnemyHealth);	// Changes the enemy health
		}
	}

	private class RunListener implements ActionListener {	// Creates the Run Listener Class/ implements  Action Listener
		public void actionPerformed(ActionEvent e) {	// Creates the action performed method for the action listener
			frame1.dispose();	// Removes the battle window
			EnemyHealth = 5;	// Resets the enemy health back to normal
		}
	}
}