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
  
  //Returns if the player blows up
  public boolean evaluateStack(){
    boolean defused = false;
    readStack: for (int i = stack.size() - 1; i > 0; i--){
      //Super Ineffient way
      switch (stack.get(i).getName()){
        case "Nope":
          stack.remove(i-1);
          break;
        case "Attack":
          //Somehow get the player
          Player target = game.getRandomPlayer();
          game.setCurrentPlayer(target);
          break;

        case "Shuffle":
          game.shuffle();
          break;

        case "Skip":
          game.skip();
          break readStack;

        case "See the Future":
          game.seeFuture();
          break;
          
        case "Exploding Cat":
          if (defused){
            defused = false;
          }else{
            return true;
          }
          break;
          
        case "Defuse":
          defused = true;
          break;
        
      }
    }
    return false;
  }
  
}