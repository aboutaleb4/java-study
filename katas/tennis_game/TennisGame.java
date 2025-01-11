package katas.tennis_game;

class TennisGame {
    public Player player1 = new Player();
    public Player player2 = new Player();
    public boolean gameEnded = false;

    public void start() {
        System.out.println("Game Started!");
        checkScore();
    }
    
    public void wonPoint(String player) {
        if (player == "player1") {
            if (player1.Score.equals(Scores.love)) {
                player1.Score = Scores.fifteen;
            } else if (player1.Score.equals(Scores.fifteen)) {
                player1.Score = Scores.thirty;
            } else if (player1.Score.equals(Scores.thirty) && !player2.Score.equals(Scores.forty)) {
                player1.Score = Scores.forty;
            } else if (player1.Score.equals(Scores.thirty) && player2.Score.equals(Scores.forty)) {
                player1.Score = Scores.deuce;
                player2.Score = Scores.deuce;
            } else if (player1.Score.equals(Scores.deuce) && player2.Score.equals(Scores.advantage)) {
                player2.Score = Scores.deuce;
            } else if (player1.Score.equals(Scores.deuce) && !player2.Score.equals(Scores.advantage)) {
                player1.Score = Scores.advantage;
            } else if (player1.Score.equals(Scores.forty) || player1.Score.equals(Scores.advantage)) {
                player1.Score = Scores.game;
            }
        }
        else {
            if (player2.Score.equals(Scores.love)) {
                player2.Score = Scores.fifteen;
            } else if (player2.Score.equals(Scores.fifteen)) {
                player2.Score = Scores.thirty;
            } else if (player2.Score.equals(Scores.thirty) && !player1.Score.equals(Scores.forty)) {
                player2.Score = Scores.forty;
            } else if (player2.Score.equals(Scores.thirty) && player1.Score.equals(Scores.forty)) {
                player2.Score = Scores.deuce;
                player1.Score = Scores.deuce;
            } else if (player2.Score.equals(Scores.deuce) && player1.Score.equals(Scores.advantage)) {
                player1.Score = Scores.deuce;
            } else if (player2.Score.equals(Scores.deuce) && !player1.Score.equals(Scores.advantage)) {
                player2.Score = Scores.advantage;
            } else if (player2.Score.equals(Scores.forty) || player2.Score.equals("Advantage")) {
                player2.Score = Scores.game;
            }
        }
        checkScore();
    }
    
    public void checkScore() {
        if(player1.Score.equals(Scores.game)) {System.out.println("Player 1 won!"); return;}
        if(player2.Score.equals(Scores.game)) {System.out.println("Player 2 won!"); return;}
        if(player1.Score.equals(Scores.deuce) && player2.Score.equals(Scores.deuce)) {System.out.println("Deuce!"); return;}
        if(player1.Score.equals(Scores.advantage)) {System.out.println("Player 1 Advantage!"); return;}
        if(player2.Score.equals(Scores.advantage)) {System.out.println("Player 2 Advantage!"); return;}
        if(player1.Score.equals(player2.Score)) {System.out.println(player1.Score + " all"); return;}
        System.out.println(player1.Score + " - " + player2.Score);
    }
}
