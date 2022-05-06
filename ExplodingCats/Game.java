import java.util.ArrayList;

public class Game{

  private int currentPlayerIndex;
  private ArrayList<Player> players;
  private Deck deck;
  private CardStack stack;
  
  public Game(ArrayList<Player> p, int s, Deck d){
    players = p;
    currentPlayerIndex = s;
    deck = d;
    stack = new CardStack(this);
  }
  
  public void startGame(){
	deck.shuffle();
	//Starts the game by giving everybody a Defuse first
    for (Player p : players){
      p.addCard(new Card("Defuse"));
      
    }
    //Next it will deal 4 cards to each players
    for (Player p : players) {
    	deck.deal(p, 7);
    }
    //Chooses the first player
    currentPlayerIndex = (int) (Math.random() * players.length);
    deck.shuffle();
  }

  
  public void turn(){
    Player current = getCurrentPlayer();

    //GUI Time
    play();

    current.addCard(deck.draw());
  }

  public Player getRandomPlayer(){
    int ran = (int) (Math.random() * players.size());
    return players.get(ran);
  }
  
  public Player getCurrentPlayer(){
    return players.get(currentPlayerIndex);
  }
  
  public void setCurrentPlayer(Player p){
    if (players.indexOf(p) >= 0) {
    	currentPlayerIndex = players.indexOf(p);
    }
  }
  
  public void shuffle(){
    deck.shuffle();
  }
  
  public void skip(){
    //Dumb way of skipping someone. Instead of drawing a card, we make the top row a null.
    deck.addCard(null);
}
  
  public Card[] seeFuture(){
    //Have something in the GUI part to show the cards returned here.
    Card[] top3 = {deck.getTopInt(1), deck.getTopInt(2), deck.getTopInt(3)};
    return top3;
  }
  
  public void play(Card c){
    stack.addCard(c);
  }
  
  
  public void GameLoop(){
    while (players.size() > 1){
      

      

      
    }
  }
  
  public void main(String[] args) {
	  startGame();
	  GameLoop();
  }
}