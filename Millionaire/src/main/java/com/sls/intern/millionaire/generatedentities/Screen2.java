package com.sls.intern.millionaire.generatedentities;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import jdbc.DBConnection;
import jdbc.Question;

public class Screen2 extends JFrame {

	JButton starttimer, logo, lifeline, button1, button2, button3, button4;
	JLabel message, display, prize, Title;
	JTextField entry;
	private JPanel panel2;
	private JLabel counttime;
	private JTextArea QArea = new JTextArea();
	
	final Timer t = new Timer();
	Random randomQ = new Random();
	Random randomA = new Random();
	
	static DBConnection dbC = new DBConnection();
	
	ArrayList<Question> QList = new ArrayList<Question>();
	ArrayList<String> currentWrongAns;
	ArrayList<Integer> QuestionDone = new ArrayList<Integer>();
	ArrayList<Integer> AnswerDone;
	
	int qCount;
	int prizeN;
	boolean end;
	boolean canProceed;
	int currentQ;
	

	public Screen2() 
	{

		JFrame frame2 = new JFrame();
		// JButton starttimer = new JButton("Time to start: ");
		// JLabel display = new JLabel();
		// JLabel message = new JLabel();
		// JTextField entry = new JTextField();

		// this.add(starttimer);
		// this.add(display);
		// this.add(message);

		QArea.setLocation(200, 350);
		QArea.setSize(400, 100);
		QArea.setEditable(false);

		// Answer A
		button1 = new JButton("Answer1");
		button1.setBounds(110, 500, 250, 35);

		// Answer B
		button2 = new JButton("Answer2");
		button2.setBounds(450, 500, 250, 35);

		// Answer C
		button3 = new JButton("Answer3");
		button3.setBounds(110, 600, 250, 35);

		// Answer D
		button4 = new JButton("Answer4");
		button4.setBounds(450, 600, 250, 35);

		// Life line Button
		lifeline = new JButton("50-50");
		lifeline.setBounds(50, 200, 200, 50);

		// Next Question Button
		logo = new JButton("Welcome");
		logo.setBounds(350, 200, 100, 100);

		// Count the time
		counttime = new JLabel();
		counttime.setText("Time Left: ");
		counttime.setBounds(550, 100, 100, 100);

		// Count the prize
		prize = new JLabel();
		prize.setText("Total prize: $");
		prize.setBounds(550, 150, 200, 100);
		

		// Game title
		Title = new JLabel();
		Title.setText("Welcome to the Millionaires Games!");
		Title.setBounds(10, 10, 600, 100);
		Font f = new Font("Arial", Font.BOLD, 30);
		Title.setFont(f);

		// Panel design
		panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBackground(Color.PINK);
		panel2.setSize(790, 790);
		// message.setBounds(100, 100, 200, 30);
		// starttimer.setBounds(200, 100, 100, 30);
		// display.setBounds(200, 400, 50, 50);

		panel2.add(logo);
		panel2.add(button1);
		panel2.add(button2);
		panel2.add(button3);
		panel2.add(button4);
		panel2.add(lifeline);
		panel2.add(QArea);
		panel2.add(counttime);
		panel2.add(prize);
		panel2.add(Title);

		frame2.add(panel2);

		frame2.setSize(800, 800);
		frame2.setVisible(true); // Make JFrame visible
		frame2.setLayout(null);
		frame2.setTitle("Do you wan to be a Millionaire?");
		
		QList = dbC.run();
		qCount= 0;
		
		end = false;
		canProceed = true;
		
	}
	
	public int getQCount()
	{
		return qCount;
	}
	
	public void increaseQCount()
	{
		qCount = qCount + 1;
	}
	
	public void determinePrize()
	{
		switch(getQCount())
		{
			case 1:
				prizeN = 500;				
				break;
				
			case 2:
				prizeN = 1000;
				break;
				
			case 3:
				prizeN = 5000;
				break;
				
			case 4:
				prizeN = 10000;
				break;
				
			case 5: 
				prizeN = 20000;
				break;
				
			case 6:
				prizeN = 50000;
				break;
				
			case 7:
				prizeN = 100000;
				break;
				
			case 8: 
				prizeN = 200000;
				break;
			
			case 9:
				prizeN = 500000;
				break;
				
			case 10:
				prizeN = 1000000;
				end = true;
				break;
				
			default:
				prizeN = 0;
				break;
		}
		
		prize.setText("Total prize: $" + prizeN);
	}

	public void fetchQuestion()
	{
		currentQ = randomQ.nextInt(QList.size());
		
		for(int i = 0; i < QuestionDone.size(); i++)
		{
			if(currentQ == QuestionDone.get(i).intValue())
			{
				fetchQuestion();
				break;
			}
		}
		
		QuestionDone.add(currentQ);
		
	}
	
	public void setAnswer()
	{
		ArrayList<Integer> done = new ArrayList<Integer>();
		String current;
		
		for(int i = 1; i < 5; i++)
		{
			System.out.println(i);
			int position;
			do
			{
				position = randomA.nextInt(4) + 1;
				
			}while(done.contains(position));
			done.add(position);
			
			switch(i)
			{
				case 1:
					current = QList.get(currentQ).getCaContent();
					break;
					
				case 2:
					current = QList.get(currentQ).getWa1Content();
					break;
					
				case 3:
					current = QList.get(currentQ).getWa2Content();
					break;
					
				case 4:
					current = QList.get(currentQ).getWa3Content();
					break;
					
				default:
					current = "";
					break;
			}
			
			switch(position)
			{
				case 1:
					button1.setText(current);
					break;
					
				case 2:
					button2.setText(current);
					break;
					
				case 3:
					button3.setText(current);
					break;
				
				case 4:
					button4.setText(current);
					break;
				
				default:
					break;
					
			}
		}
	}
	
	public void getWrongAnswers()
	{
		currentWrongAns = QList.get(currentQ).getWrongAnswers();
	}
	
	public void start() {
		
			logo.addActionListener(new ActionListener() 
			{

				public void actionPerformed(ActionEvent e) 
				{
					// TODO Auto-generated method stub
					increaseQCount();
					determinePrize();
					ButtonActionPerformed(e);
					
				}

				protected void ButtonActionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

					// Retrieve Question and answer from database and put inside text area and 4
					// buttons
					if(canProceed == false)
					{
						JOptionPane.showMessageDialog(null, "Sorry, please choose an answer first!");
						
					}
					
					else
					{
						canProceed = false;
						fetchQuestion();
						getWrongAnswers();
						
						QArea.setText(QList.get(currentQ).getqContent());  
						setAnswer();
						/*button1.setText(QList.get(currentQ).getCaContent());
						button2.setText(QList.get(currentQ).getWa1Content());
						button3.setText(QList.get(currentQ).getWa2Content());
						button4.setText(QList.get(currentQ).getWa3Content());*/
					
					// Timer Start
					
						t.scheduleAtFixedRate(new TimerTask() 
						{
							int i = 30;

							@Override
							public void run() 
							{

								counttime.setText("Time Left: " + (i--));
								if (i < 0) 
								{
									Title.setText("Sorry, Times Up...");
									t.cancel();

								}
							}
						}, 0, 1000);
					
					}
				}
			});
			
	
			//

			// answer button function, correct answer/ wrong.
			button1.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
					ButtonActionPerformed(e);
				}
				
				protected void ButtonActionPerformed(ActionEvent e) 
				{
					if(currentWrongAns.contains(button1.getText()))
					{
						button1.setBackground(Color.RED);
					}
				}
				
			});
					
			// 50-50 life line button

		
	}

}
