package gameCode;
	
import java.util.ArrayList;

import serverHandler.ClientHandler;
import serverHandler.PlayHandler;
import serverHandler.UpdateHandler;
	
public class Player{
	
	  private ArrayList<Card> hand;
	  private String name;
	  private ClientHandler clientHandler;
	  private PlayHandler playHandler;
	  private UpdateHandler updateHandler;
	  
	  public Player(String n, ClientHandler c, PlayHandler p, UpdateHandler u){
	    name = n;
	    clientHandler = c;
	    hand = new ArrayList<Card>();
	    playHandler = p;
	    updateHandler = u;
	  }
	  
	  //Getters
	
	  public String getName(){
	    return name;
	  }
	  
	  public ArrayList<Card> getHand(){
		  return this.hand;
	  }
	  
	  public ClientHandler getClient() {
		  return clientHandler;
	  }
	  
	  //Game Method
	  
	  public void addCard(Card c){
	    //Method gives the player a card
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
	  
	  
	  
	  //Client Handler Method
	  
	  public Card playCard() {
		  String cardName = playHandler.askForCard();
		  for (Card c:this.hand) {
			  if (c.getName().equals(cardName)) {
				  return c;
			  }
		  }
		  return null;
	  }
	  
	  public void showCard(Card c) {
		  playHandler.sendShownCard(c.getName());
	  }
	  
	  public boolean hasCard(String name) {
		  for(Card card : hand) {
			  if(card.getName() == name) {
				  return true;
			  }
		  }
		  return false;
	  }
	}