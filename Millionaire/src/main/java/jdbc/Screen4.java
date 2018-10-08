package jdbc;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Screen4 extends JFrame {

	JFrame frame4;
	JLabel Title, totalPrize, restartStatement;
	JPanel panel4;
	JButton restart, exit;

	public Screen4(int prize) {

		frame4 = new JFrame();

		restart = new JButton("Start Game");
		restart.setBounds(190, 500, 150, 50);
		restart.setBackground(Color.GREEN);
		Font f = new Font("Arial", Font.BOLD,18);
		restart.setFont(f);

		exit = new JButton("Exit");
		exit.setBounds(460, 500, 150, 50);
		exit.setBackground(Color.LIGHT_GRAY);
		exit.setFont(f);

		Title = new JLabel();
		Title.setText("Congratulation!!! Millionaire :^)");
		Title.setBounds(150, 200, 600, 100);
		Font f1 = new Font("Arial", Font.BOLD, 40);
		Title.setFont(f1);

		totalPrize = new JLabel();
		totalPrize.setText("Here is your million: $" + prize);
		totalPrize.setBounds(150, 330, 600, 100);
		Font f2 = new Font("Arial", Font.BOLD, 30);
		totalPrize.setFont(f2);
		
		restartStatement = new JLabel();
		restartStatement.setText("Green to Restart and Grey to Exit!");
		restartStatement.setBounds(150,450,600,100);
		Font f3 = new Font("Arial", Font.BOLD, 20);
		restartStatement.setFont(f3);		

		panel4 = new JPanel();
		panel4.setLayout(null);
		panel4.setBackground(Color.CYAN);
		panel4.setSize(790, 790);

		panel4.add(Title);
		panel4.add(totalPrize);
		panel4.add(restartStatement);
		panel4.add(restart);
		panel4.add(exit);

		frame4.add(panel4);

		frame4.setSize(800, 800);
		frame4.setVisible(true); // Make JFrame visible
		frame4.setLayout(null);
		frame4.setTitle("Do you want to be a Millionaire?");

	}

	public void start() {

		restart.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ButtonActionPerformed(e);
			}

			protected void ButtonActionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Screen1 s1 = new Screen1();
				frame4.dispose();
				s1.start();
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

