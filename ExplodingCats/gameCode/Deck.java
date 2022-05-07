package gameCode;
import java.util.*;

public class Deck{
  private ArrayList<Card> deck;
  
  public Deck(ArrayList<Card> c){
    deck = c;
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