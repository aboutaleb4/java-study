package katas.tennis_game;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Hello Tennis World!");
        TennisGame game = new TennisGame();
        Player player1 = new Player("Ahmed");
        Player player2 = new Player("Ibrahim");
        game.start();
        game.registerPlayer(player1);
        game.wonPoint(player1);
        game.start();
        game.registerPlayer(player2);
        game.start();
        game.wonPoint(player1);
        game.wonPoint(player1);
        game.wonPoint(player2);
        game.wonPoint(player2);
        game.wonPoint(player2);
        game.wonPoint(player1);
        game.wonPoint(player1);
        game.wonPoint(player1);
    }
}

