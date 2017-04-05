package gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import com.sun.glass.events.MouseEvent;

import gui.Box;



public class Box extends JPanel implements ActionListener, MouseListener{

	//	private static  JFrame frame; 
	//	private static JButton resetButton, addBallsButton; 
	//	private static JPanel panel, panel2;

	public static ArrayList<Ball> ballList = new ArrayList<Ball>();

	public boolean doorClosed = true; 

	Box() {

		Ball ball = new Ball();
		ball.setColor("red");
		ball.pushLeft();

		Ball ball2 = new Ball();
		ball2.setColor("blue");
		ball2.pushRight();

		Ball ball3 = new Ball();
		ball3.setColor("red");
		ball3.pushLeft();

		Ball ball4 = new Ball();
		ball4.setColor("blue");
		ball4.pushRight();

		ballList.add(ball);
		ballList.add(ball2);
		ballList.add(ball3);
		ballList.add(ball4);


		addMouseListener(this);

		doorClosed = true;

		start();

	}



	public void addButtons(JFrame frame)
	{
		JPanel panel = new JPanel();

		JButton addBallsButton = new JButton("add balls");
		JButton resetButton = new JButton("reset");

		panel.add(addBallsButton);
		panel.add(resetButton);
		
	
		
		frame.add(panel, BorderLayout.SOUTH);


		resetButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ballList.clear();
				Ball ball = new Ball();
				ball.setColor("red");
				ball.pushLeft();

				Ball ball2 = new Ball();
				ball2.setColor("blue");
				ball2.pushRight();

				Ball ball3 = new Ball();
				ball3.setColor("red");
				ball3.pushLeft();

				Ball ball4 = new Ball();
				ball4.setColor("blue");
				ball4.pushRight();

				ballList.add(ball);
				ballList.add(ball2);
				ballList.add(ball3);
				ballList.add(ball4);

				repaint();
			}
		});

		addBallsButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Ball newBall1 = new Ball();
				Ball newBall2 = new Ball();

				newBall1.setColor("red");
				newBall2.setColor("blue");
				newBall1.pushLeft();
				newBall2.pushRight();

				ballList.add(newBall1);
				ballList.add(newBall2);

				//				repaint();
			}
		});


	}



	public void start() {


		Thread thread = new Thread() {

			public void run() {

				while (true) {

					moveBalls();			
					repaint();

					try 
					{
						Thread.sleep(70);
					} 
					catch (InterruptedException ex) 
					{
					}

				}
			}
		};
		thread.start();

	}

	public void moveBalls() {
		for (Ball ball : ballList)
			ball.move();
	}



	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (Ball ball : ballList)
		{
			ball.paintComponent(g);
		}

		if(doorClosed)
		{
			g.setColor(Color.GREEN);
			g.drawLine(getWidth()/2, 0, getWidth()/2, getHeight());
		}
		else 
		{
			g.setColor(Color.GREEN);
			g.drawLine(getWidth()/2, 0, getWidth()/2, 150);
			g.drawLine(getWidth()/2, 350, getWidth()/2, getHeight());
		}
		
		g.setFont(new Font("Times Roman", 1, 20));
		g.drawString(calcTempLeft(), 175, 20);
		g.drawString(calcTempRight(), 525, 20);
	}


	public  String calcTempLeft(){

//		ArrayList <Integer> ballListLeft = new ArrayList <Integer> ();

		int count =0 ; 
		float cool = 0;

		for (int i = 0; i < ballList.size(); i++){
//			cool = ballList.get(i).getX();

			if (ballList.get(i).getX() < 350){
//				if (ballList.get(i).getColor() == "red"){
//
//					ballListLeft.add((int) Math.pow(5, 2));
//				}
//				else {ballListLeft.add((int) Math.pow(3, 2));}
				cool += Math.sqrt(Math.pow(ballList.get(i).getdx(), 2) + Math.pow(ballList.get(i).getdy(), 2));
				count ++; 
				} 
		}



		cool = cool/count;
		
		if(cool == )
			return "0";
		return Float.toString(cool) + "\u00b0";
	}



	public  String calcTempRight(){

//		ArrayList <Integer> ballListRight = new ArrayList <Integer> ();


		int count =0 ; 
		float cool = 0;

		for (int i = 0; i < ballList.size(); i++){
//			cool = ballList.get(i).getX();

			if (ballList.get(i).getX() > 350){
//				if (ballList.get(i).getColor() == "red"){
//
//					ballListLeft.add((int) Math.pow(5, 2));
//				}
//				else {ballListLeft.add((int) Math.pow(3, 2));}
				cool += Math.sqrt(Math.pow(ballList.get(i).getdx(), 2) + Math.pow(ballList.get(i).getdy(), 2));
				count ++; 
				} 
		}



		cool = cool/count;
		
		if(cool == 0)
			return "0";
		return Float.toString(cool) + "\u00b0";
	}	



	public static void main(String[] args) {

		Box box = new Box();

		JFrame frame = new JFrame("Maxwell's Demons");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame.setSize(700, 500);
		frame.setLayout(new BorderLayout());

		box.addButtons(frame);
		
		

		frame.add(box, BorderLayout.CENTER);
	
		frame.setVisible(true);


	}



	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}



	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		doorClosed = false;
		for (Ball ball: ballList)
		{
			ball.doorClosed = false;
		}
	}



	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		doorClosed = true;

		for (Ball ball: ballList)
		{
			ball.doorClosed = true;
		}

	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}



	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}




}





