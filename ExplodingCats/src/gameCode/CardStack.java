package gameCode;
import java.util.ArrayList;



public class CardStack{

  private Game game;
  private ArrayList<Card> stack;
  
  public CardStack(){
    stack = new ArrayList<Card>();
  }
  
  //Getters
  
  public ArrayList<Card> getCardsInStack() {
	  return this.stack;
  }
  
  public void addCard(Card c){
    stack.add(c);
  }
  
  private boolean hasCard(String name) {
	  for (Card c :stack) {
		  if (c.getName().equalsIgnoreCase(name)) {
			  return true;
		  }
	  }
	  return false;
  }
  
  //Returns if the player blows up
  public boolean evaluateStack(Game g){
    boolean playerDies = false;
    if (this.hasCard("Exploding Cat")) {
    	playerDies = true;
    }
    
    readStack: for (int i = stack.size() - 1; i > 0; i--){
      //Super Inefficient way
      switch (stack.get(i).getName()){
        case "Nope":
          stack.remove(i-1);
          stack.remove(i);
          i--;
          
          break;
        case "Attack":
          //Somehow get the player
          String target = game.getRandomPlayer().getName();
          game.setCurrentPlayer(target);
          stack.remove(i);
          break;

        case "Shuffle":
          game.shuffle();
          stack.remove(i);
          break;

        case "Skip":
          game.skip();
          stack.remove(i);
          break readStack;

        case "See the Future":
        	game.seeFuture();
        	stack.remove(i);
        	break;
          
        case "Defuse":
          playerDies = false;
          stack.remove(i);
          break;
      }
    }
    return playerDies;
  }
  
}