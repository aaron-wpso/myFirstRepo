package jdbc;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Screen1 extends JFrame{
	
	JLabel Title, subTitle;
	JPanel panel;
	JButton gamestart, exit;
	
	public Screen1() {
		
		
		gamestart = new JButton("Start Game");
		gamestart.setBounds(190, 500, 150, 50);
		gamestart.setBackground(Color.GREEN);
		Font f = new Font("Arial", Font.BOLD,18);
		gamestart.setFont(f);
		
		exit = new JButton("Exit");
		exit.setBounds(460, 500, 150, 50);
		exit.setBackground(Color.LIGHT_GRAY);
		exit.setFont(f);
		
		Title = new JLabel();
		Title.setText("Let's be a Millionaire!!!!!");
		Title.setBounds(170,200, 600, 100);
		Font f1 = new Font("Arial", Font.BOLD,40);
		Title.setFont(f1);
		
		subTitle = new JLabel();
		subTitle.setText("Ready to play?");
		subTitle.setBounds(250,250, 600, 100);
		Font f2 = new Font("Arial", Font.BOLD,40);
		subTitle.setFont(f2);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.PINK);
		panel.setSize(790, 790);
		
		panel.add(Title);
		panel.add(subTitle);
		panel.add(gamestart);
		panel.add(exit);
		
		
		this.add(panel);
	
		this.setSize(800, 800);
		this.setVisible(true);								//Make JFrame visible
		this.setLayout(null);
		this.setTitle("Do you wan to be a Millionaire?");
		
	}
	
	public void start() {
		
	gamestart.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ButtonActionPerformed(e);	
		}
		
		protected void ButtonActionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Screen2 s2 = new Screen2();
			s2.start();
			dispose();		
			}		
		});
	
	exit.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(ABORT);
		}
		
		
	});
	}
}
