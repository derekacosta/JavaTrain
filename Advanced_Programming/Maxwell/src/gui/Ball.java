package gui;
import java.awt.*;



public class Ball{
	
	// Box height and width
	int width = 700, height = 430;

	// Ball Size
	float radius, diameter;

	// Center of Call
	float X, Y;
	
	public float getX(){
		return X;
	}

	public float getY(){
		return Y;
	}
	public float getdx(){
		return dx;
	}

	public float getdy(){
		return dy;
	}
	// Direction (Speed)
	float dx, dy;
	
	//Color of ball 
	String color = "";
	
	boolean doorClosed = true; 
	
	public Ball(){
		
		// Ball Size
		radius = 15;
		diameter = radius * 2;
		
		// Center of Call
		X = width/2;
		Y = radius + (int) (Math.random() * height);
		

	}
	
	public void setColor(String color){
		this.color = color;
		
		if(color == "red") {
			dx = 5; 
			dy = 5;
		}
		else {
			dx = 3; 
			dx = 3;
		}
	}
	
	public String getColor(){
		return color;
	}
	
	public void move(){
		
		X += dx;
		Y += dy;
		
		if (doorClosed)
		{

			if (X - radius < 0)
			{
				dx = -dx;
				X = radius;
			}
			else if (X + radius > (width / 2) && X < (width / 2) )
			{
				dx = -dx;
				X = (width/2) - radius;
			}
			else if (X - radius < (width / 2) && X > (width / 2) )
			{
				dx = -dx;
				X = (width/2) + radius;
			}
		}
		else
		{
	
			
			if (X - radius < 0)
			{
				dx = -dx;
				X = radius;
			}
			else if (X + radius > (width / 2) && X < (width / 2) && (Y - radius < 150 || Y + radius > 350) )
			{
				dx = -dx;
				X = (width / 2) - radius;
			}
			else if (X - radius < (width / 2) && X > (width / 2) && (Y - radius < 150 || Y + radius > 350) )
			{
				dx = -dx;
				X = (width / 2) + radius;
			}
			
		}
		X += dx;
		Y += dy;
		if (X - radius < 0) {
			dx = -dx; 
			X = radius; 
		} else if (X + radius > width) {
			dx = -dx;
			X = width - radius;
		}

		if (Y - radius < 0) {
			dy = -dy;
			Y = radius;
		} else if (Y + radius > height) {
			dy = -dy;
			Y = height - radius;
		}
	}
	
	public void pushLeft()
	{
		X = (int)(Math.random() * (width / 2) ) - radius;
	}
	
	public void pushRight()
	{
		X = (int)(Math.random() * (width / 2) ) + radius + (width / 2) ;
	}
	
	public void paintComponent(Graphics g) {
		
		if(getColor() == "red"){
			g.setColor(Color.RED);
		    g.fillOval((int)(X-radius), (int)(Y-radius), (int)diameter, (int)diameter);

		}
		else{
			g.setColor(Color.BLUE);
		    g.fillOval((int)(X-radius), (int)(Y-radius), (int)diameter, (int)diameter);

		}

	}

	
	
	
}
