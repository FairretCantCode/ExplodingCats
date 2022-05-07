package gameCode;
public class Game{

  private int currentPlayerIndex;
  private Player[] players;
  private Deck deck;
  private CardStack stack;
  
  public Game(Player[] p, int s, Deck d){
    players = p;
    currentPlayerIndex = s;
    deck = d;
    stack = new CardStack(this);
  }
  
  public void startGame(){
    deck.shuffle();
    for (Player p : players){
      p.addCard(new Card("Defuse"));
      
    }
    GameLoop();
  }

  
  public void turn(){
    Player current = getCurrentPlayer();

    //GUI Time
    play();

    getCurrentPlayer().addCard(deck.draw());
  }

  public Player getRandomPlayer(){
    int ran = (int) (Math.random() * players.length);
    return players[ran];
  }
  public Player getCurrentPlayer(){
    return players[currentPlayerIndex];
  }
  public void setCurrentPlayer(Player p){
    for (int i = 0; i < players.length; i++){
      if (players[i] == p){
        currentPlayerIndex = i;
      }
    }
  }
  public void shuffle(){
    deck.shuffle();
  }
  public void skip(){
    //Dumb way of skippig someone. Instead of drawing a card, we make the top row a null.
    deck.addCard(null);
}
  public Card[] seeFuture(){
    //Have something in the GUI part to show the cards returned here.
    Card[] top3 = {deck.getTopInt(1), deck.getTopInt(2), deck.getTopInt(3)};
    return top3;
  }
  public void play(){
    
  }
  public void GameLoop(){
    startGame();
    while (players.length > 1){
      

      

      
    }
  }
}