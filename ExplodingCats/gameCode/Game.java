package gameCode;

import java.util.ArrayList;

public class Game{

  private int currentPlayerIndex;
  private ArrayList<Player> players;
  private Deck deck;
  private CardStack stack;
  
  public Game(ArrayList<Player> p){
    players = p;
    currentPlayerIndex = 0;
    deck = new Deck(p.size()-1);
    stack = new CardStack(this);
  }
  
  public void startGame(){
	  deck.populate();
	  deck.shuffle();
	  for (Player p : players){
		  p.addCard(new Card("Defuse"));
      
	  }
	  GameLoop();
	  System.out.println(players.get(0).getName() + " is the winner!");
  }

  
  public void turn(){
    Player current = getCurrentPlayer();
    //GUI Time
    play();
    if (stack.evaluateStack()){
    	System.out.println(current.getName() + " blew up!");
    	players.remove(currentPlayerIndex);
    }else {
    	current.addCard(deck.draw());
    	if (deck.getLength() == 0) {
    		deck.populate();
    		deck.shuffle();
    	}
    }
  }

  public Player getRandomPlayer(){
    int ran = (int) (Math.random() * players.size());
    return players.get(ran);
  }
  
  public Player getCurrentPlayer(){
    return players.get(currentPlayerIndex);
  }
  
  public void setCurrentPlayer(String n){
    int index = -1;
    for (Player p: players) {
    	if (p.getName().equals(n)) {
    		index = players.indexOf(p);
    	}
    }
    if (index >= 0) {
    	currentPlayerIndex = index;
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
  
  public void play(){
    Player currentPlayer = this.getCurrentPlayer();
    boolean playing = true;
    while (playing) {
    	Card cardPlayed = currentPlayer.playCard();
    	if (cardPlayed == null) {
    		playing = false;
    	}else {
    		stack.addCard(cardPlayed);
    		for (Player p:players) {
    			if (p != currentPlayer) {
    				p.showCard(cardPlayed);
    			}
    		}
    	}
    }
    
  }
  public void GameLoop(){
	  while (players.size() > 1){
		  this.turn();
		  currentPlayerIndex++;      
    }
  }
}