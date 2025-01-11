package katas.tennis_game;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Hello Tennis World!");
        TennisGame game = new TennisGame();
        game.start();
        game.wonPoint("player1");
        game.wonPoint("player1");
        game.wonPoint("player2");
        game.wonPoint("player2");
        game.wonPoint("player2");
        game.wonPoint("player1");
        game.wonPoint("player1");
        game.wonPoint("player1");
    }
}

