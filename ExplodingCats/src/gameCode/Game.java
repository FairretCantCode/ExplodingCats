package gameCode;
	
import java.util.ArrayList;

import clientCode.GameScreen;
	
public class Game{
	
	  private int currentPlayerIndex;
	  private ArrayList<Player> players;
	  private Deck deck;
	  private CardStack stack;
	  private GameScreen gui2;
	  
	  public ArrayList<TimeDaub> allTimeDaubs = new ArrayList<TimeDaub>();
	  
	  public boolean playerDies = false;


	  public Game(ArrayList<Player> p){
	    players = p;
	    currentPlayerIndex = 0;
	    deck = new Deck(p.size()-1);
	    stack = new CardStack();
	  }
	  
	  
	  //Getters
	  public Player getCurrentPlayer(){
		    return players.get(currentPlayerIndex);
	  }
	  
	  public Player getRandomPlayer(){
		    int ran = (int) (Math.random() * players.size());
		    return players.get(ran);
	  }
	  
	  public ArrayList<Player> getPlayers(){
		  return this.players;
	  }
	  
	  public CardStack getCardStack(){
		  return this.stack;
	  }
	  
	  //Setters
	  
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
	  
	  public void setCurrentPlayer(int n) {
		  int index = players.indexOf(n);
		  if (index >= 0) {
			  currentPlayerIndex = index;
		  }
	  }
	  
	  //Card Effects 
	  
	  public void shuffle(){
	    deck.shuffle();
	  }
	  
	  public void skip(){
	    //Dumb way of skipping someone. Instead of drawing a card, we make the top row a null.
	    deck.addCard(null);
	  }
	  
	  public void seeFuture(){
	    //Have something in the GUI part to show the cards returned here.
	    Card[] top3 = {deck.getTopInt(1), deck.getTopInt(2), deck.getTopInt(3)};
	    String msg = "future ";
	    for (Card c: top3) {
	    	msg += c.getName() + " "; 
	    }
	    getCurrentPlayer().getClient().send(msg);
	  }
	  public void attack() {
		  deck.addCard(null);
		  
	  }
	  
	  //Game Methods
	  
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
	    if (stack.evaluateStack(this)){
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
			  playerDies = false;
			  if(getCurrentPlayer().hasCard("Exploding Daub")) {
				  playerDies = true;
			  }
			  for(int i = 0; i < allTimeDaubs.size(); i++) {
				  if(allTimeDaubs.get(i).getCountdown() <= 0) {
					  playerDies = true;
					  allTimeDaubs.remove(i);
					  i--;
				  }
			  }
			  
			  this.turn();
			  for(int i = 0; i < getCurrentPlayer().getHand().size(); i ++) {
				  if(getCurrentPlayer().getHand().get(i).getName() == "Exploding Daub") {
					  getCurrentPlayer().getHand().remove(i);
					  i --;
				  }
			  }
			  currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
	    }
	  }
	  
	  
	}