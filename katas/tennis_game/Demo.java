package katas.tennis_game;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Hello Tennis World!");
        TennisGame game = new TennisGame();
        String player1 = "Ahmed";
        String player2 = "Ibrahim";
        game.start();
        game.registerPlayer1(player1);
        game.wonPoint(player1);
        game.start();
        game.registerPlayer2(player2);
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

