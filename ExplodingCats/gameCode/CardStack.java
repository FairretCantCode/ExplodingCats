package gameCode;
import java.util.ArrayList;



public class CardStack{

  private Game game;
  private ArrayList<Card> stack;
  
  public CardStack(Game g){
    stack = new ArrayList<Card>();
    game = g;
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
  public boolean evaluateStack(){
    boolean playerDies = false;
    if (this.hasCard("Exploding Cat")) {
    	playerDies = true;
    }
    
    readStack: for (int i = stack.size() - 1; i > 0; i--){
      //Super Inefficient way
      switch (stack.get(i).getName()){
        case "Nope":
          stack.remove(i-1);
          break;
        case "Attack":
          //Somehow get the player
          String target = game.getRandomPlayer().getName();
          game.setCurrentPlayer(target);
          break;

        case "Shuffle":
          game.shuffle();
          break;

        case "Skip":
          game.skip();
          break readStack;

        case "See the Future":
          for (Card c: game.seeFuture()) {
        	  game.getCurrentPlayer().showCard(c);
          }
          break;
          
        case "Defuse":
          playerDies = false;
          break;
      }
    }
    return playerDies;
  }
  
}