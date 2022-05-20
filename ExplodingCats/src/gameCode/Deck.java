package gameCode;
import java.util.*;
	
public class Deck{
	  private ArrayList<Card> deck;
	  private int numBombs;
	  private String[] cards = {"Exploding Cat", "Attack", "See the Future",
			  					"Shuffle", "Nope", "Bearded Cat", "Rainbow Cat"};
	  
	  public Deck(){
		  deck = new ArrayList<Card>();
	  }
	  
	  //Getters
	  
	  public int getLength() {
		  return deck.size();
	  }
	  
	  //Setters
	  
	  
	  //Game methods
	  public void populate(int numPlayers) {
		  
		  for (int j =0; j < numPlayers-1; j++) {
			  deck.add(new Card(cards[0]));
		  }
		  for (int i = 1; i < cards.length-1; i++) {
			  for (int j = 0; j < 4; j++) {
				  deck.add(new Card(cards[i]));
			  }
		  }
	  }
	  
	  public Card draw(){
	    return deck.remove(deck.size()-1);
	  }
	
	  public Card getTopInt(int i){
	    return deck.get(deck.size() - i);
	  }
	  public void addCard(Card c){
	    deck.add(c);
	  }
	  
	  public void shuffle(){
	    Collections.shuffle(deck);
	  }
	
	}