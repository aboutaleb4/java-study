package katas.tennis_game;

class TennisGame {
    public Player player1;
    public Player player2;
    public GameState gameState = GameState.notStarted;

    public void start() {
        if(player1 == null || player2 == null) {
            System.out.println("Not enough players to start the game!");
            return;
        }
        System.out.println("Game Started!");
        gameState = GameState.started;
        displayScore();
    }
    
    public void wonPoint(Player player) {
        if(!gameState.equals(GameState.started)) {
            System.out.println("The game is not ongoing!");
            return;
        }
        if (player == player1) {
            player1.updateScore(player2);
        }
        else {
            player2.updateScore(player1);
        }
        displayScore();
    }
    
    public void displayScore() {
        if(player1.Score.equals(Scores.game)) {System.out.println(player1.name + " won!"); return;}
        if(player2.Score.equals(Scores.game)) {System.out.println(player2.name + " won!"); return;}
        if(player1.Score.equals(Scores.deuce) && player2.Score.equals(Scores.deuce)) {System.out.println("Deuce!"); return;}
        if(player1.Score.equals(Scores.advantage)) {System.out.println(player1.name + " Advantage!"); return;}
        if(player2.Score.equals(Scores.advantage)) {System.out.println(player2.name + " Advantage!"); return;}
        if(player1.Score.equals(player2.Score)) {System.out.println(player1.Score + " all"); return;}
        System.out.println(player1.Score + " - " + player2.Score);
    }

    public void registerPlayer(Player player) {
        if(player1 == null) player1 = player;
        else if(player2 == null) player2 = player;
        else {
            System.out.println("Game is full");
        } 
    }
}
