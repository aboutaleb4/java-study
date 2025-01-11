package katas.tennis_game;

public class Player {
    public final String name;
    public Scores Score = Scores.love;

    public Player(String name) {
        this.name = name;
    }

    public void updateScore(Player otherPlayer) {
        if (this.Score.equals(Scores.love)) {
            this.Score = Scores.fifteen;
        } else if (this.Score.equals(Scores.fifteen)) {
            this.Score = Scores.thirty;
        } else if (this.Score.equals(Scores.thirty) && !otherPlayer.Score.equals(Scores.forty)) {
            this.Score = Scores.forty;
        } else if (this.Score.equals(Scores.thirty) && otherPlayer.Score.equals(Scores.forty)) {
            this.Score = Scores.deuce;
            otherPlayer.Score = Scores.deuce;
        } else if (this.Score.equals(Scores.deuce) && otherPlayer.Score.equals(Scores.advantage)) {
            otherPlayer.Score = Scores.deuce;
        } else if (this.Score.equals(Scores.deuce) && !otherPlayer.Score.equals(Scores.advantage)) {
            this.Score = Scores.advantage;
        } else if (this.Score.equals(Scores.forty) || this.Score.equals(Scores.advantage)) {
            this.Score = Scores.game;
        }
    }
}
