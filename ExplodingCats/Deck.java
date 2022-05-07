import java.util.*;

public class Deck{
  private ArrayList<Card> deck;
  
  public Deck(){
    deck = new ArrayList<Card>();
    
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
  
  public void addCard(Card c, int i){
	if (i > deck.size()-1) {
		deck.add(c);
	}
		deck.add(i, c);
  }
  
  public void shuffle(){
    Collections.shuffle(deck);
  }
  
  public void deal(Player p, int i) {
	  for (int j = 0; j < i; j++) {
		  p.addCard(draw());
	  }
  }
  
}