package serverCode;

public class Message {
	
	//Constants used by the user to server. User asks for information about the game
	public static final String GETHAND = "give cards in hand";
	public static final String GETPLAYERS = "give list of players";
	public static final String GETSTACK = "give cards in stack";
	
	//Constants used by the server to user. Used to ask the user for an action.
	public static final String PLAYCARD = "play a card";
	public static final String STARTTURN = "your turn";
	public static final String QUITCONNECTION = "quit";
}
