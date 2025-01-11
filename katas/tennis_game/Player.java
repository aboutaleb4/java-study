package katas.tennis_game;

public class Player {
    public final String name;
    public Scores Score = Scores.love;

    public Player(String name) {
        this.name = name;
    }

    public void updateScore(Player player2) {
        if (this.Score.equals(Scores.love)) {
            this.Score = Scores.fifteen;
        } else if (this.Score.equals(Scores.fifteen)) {
            this.Score = Scores.thirty;
        } else if (this.Score.equals(Scores.thirty) && !player2.Score.equals(Scores.forty)) {
            this.Score = Scores.forty;
        } else if (this.Score.equals(Scores.thirty) && player2.Score.equals(Scores.forty)) {
            this.Score = Scores.deuce;
            player2.Score = Scores.deuce;
        } else if (this.Score.equals(Scores.deuce) && player2.Score.equals(Scores.advantage)) {
            player2.Score = Scores.deuce;
        } else if (this.Score.equals(Scores.deuce) && !player2.Score.equals(Scores.advantage)) {
            this.Score = Scores.advantage;
        } else if (this.Score.equals(Scores.forty) || this.Score.equals(Scores.advantage)) {
            this.Score = Scores.game;
        }
    }
}
