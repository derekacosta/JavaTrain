class Marker 
{ 
    public void printGrade(int mark) 
    { 
        if (mark >= 85) 
            System.out.println("High Distinction"); 
        if (mark >= 75) 
            System.out.println("Distinction"); 
        if (mark >= 65) 
            System.out.println("Credit"); 
        if (mark >= 50) 
            System.out.println("Pass"); 
        if (mark >= 45) 
            System.out.println("Concessional Pass"); 
        else
            System.out.println("Fail"); 
    } 
    
    public static void main(String[] args) 
    { 
    	Marker myMarker = new Marker();
    	myMarker.printGrade(90);
    }
}
