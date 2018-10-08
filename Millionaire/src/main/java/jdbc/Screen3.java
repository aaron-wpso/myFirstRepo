package jdbc;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Screen3 extends JFrame {

	JFrame frame3;
	JLabel Title, totalPrize;
	JPanel panel3;
	JButton restart, exit;

	public Screen3(int prize) {

		frame3 = new JFrame();

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
		Title.setText("Too bad, You lose the game :(");
		Title.setBounds(150, 200, 600, 100);
		Font f1 = new Font("Arial", Font.BOLD, 40);
		Title.setFont(f1);

		totalPrize = new JLabel();
		totalPrize.setText("This is your total prize: $" + prize);
		totalPrize.setBounds(150, 330, 600, 100);
		Font f2 = new Font("Arial", Font.BOLD, 30);
		totalPrize.setFont(f2);

		panel3 = new JPanel();
		panel3.setLayout(null);
		panel3.setBackground(Color.PINK);
		panel3.setSize(790, 790);

		panel3.add(Title);
		panel3.add(totalPrize);
		panel3.add(restart);
		panel3.add(exit);

		frame3.add(panel3);

		frame3.setSize(800, 800);
		frame3.setVisible(true); // Make JFrame visible
		frame3.setLayout(null);
		frame3.setTitle("Do you wan to be a Millionaire?");

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
				s1.start();
				frame3.dispose();
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
