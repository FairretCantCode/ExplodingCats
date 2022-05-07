package gameCode;
import java.util.*;
public class Player{

  private ArrayList<Card> hand;
  private String name;
  
  public Player(String n){
    name = n;
  }

  public String getName(){
    return name;
  }

  public void addCard(Card c){
    //Mehtod gives the player a card
    if (c != null){
      hand.add(c);  
    }
  }

  public void removeCard(Card c){
    try{
      hand.remove(hand.indexOf(c));
    }catch (ArrayIndexOutOfBoundsException e){
      System.out.println("Player does not have the card");
    }
  }
}