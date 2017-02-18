package texas;

import java.util.ArrayList;

public class Game {
	private ArrayList<Card> board;
	private ArrayList<Player> players; 
	
	public Game() {
		board = new ArrayList<Card>();
		players = new ArrayList<Player>();
	}
	
	public void addPlayer(Player player) {
		players.add(player);		
	}
	
	public void setBoard(ArrayList<Card> board) {
		this.board = new ArrayList<Card>(board);
	}
	
	public void readSettings(String filename) {
		// First line contains five cards
		try
		{
			File file = new File(filename); 
			BufferedReader reader = new BufferedReader(new FileReader (file));
			String inputText = null;
			while((inputText = reader.readLine()) != null)
			{
				System.out.println(inputText);
			} 
			reader.close();
		} 
		catch(IOException except)
		{ 
			System.err.println("Error: " + except.getMessage()); 
			System.exit(1);
		}
		// Second line contains an integer -- the number of players
		
		// Each following line contains name of the player and two cards
	}

	public ArrayList<Hand> generateCandidates(ArrayList<Card> board, Player player) {
		ArrayList<Hand> candidates = new ArrayList<Hand>();
		return candidates;
	}
	
	public String announceWinner() {
		return "";
	}	
	
	public static void main(String[] Args) {
		// NOTE: Please do not change the main function; Needed for AutoGrading
		// In Eclipse, you can create settings.conf file under the project
		Game game = new Game();
		game.readSettings("settings.conf");
		System.out.println(game.announceWinner());
	}
}
