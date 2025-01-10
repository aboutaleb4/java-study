public class BowlingGame {
    private Player[] players;
    private int count;

    public void addPlayer(String name) {
        players[count - 1] = new Player(name);
    }
}
