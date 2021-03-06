package main.model;

public class Game {

    private int maxScore = 5;

    private Player player;
    private Computer computer;

    public Game(Player player, Computer computer) {
        this.player = player;
        this.computer = computer;
    }

    public Player getPlayer() {
        return player;
    }

    public Computer getComputer() {
        return computer;
    }

    public int getMaxScore() {
        return maxScore;
    }

    // EFFECTS: Checks if player beats the computer
    public boolean beatsOther(RPSEnum p, RPSEnum c) {
        if (p == RPSEnum.ROCK && c == RPSEnum.SCISSORS) {
            return true;
        } else if (p == RPSEnum.PAPER && c == RPSEnum.ROCK) {
            return true;
        } else if (p == RPSEnum.SCISSORS && c == RPSEnum.PAPER) {
            return true;
        } else {
            return false;
        }
    }

    // hasWon checks if player wins (when player has the max score)
    public boolean hasWon(Player player) {
        return player.getScore() >= maxScore;
    }

    public boolean isTie(RPSEnum p1, RPSEnum p2) {
        return p1 == p2;
    }

    // MODIFIES: this
    // EFFECTS: computer makes a move, increment score of winner, return winner or null if no one won yet
    public Player play(RPSEnum move) {
        RPSEnum computerMove = computer.makeChoice();
        if (isTie(move, computerMove)) {
            System.out.println("TIE: " + move + " " + computerMove);
            return null;
        } else if (beatsOther(move, computerMove)) {
            System.out.println("PLAYER WON: " + move + " " + computerMove);
            player.increaseScore();
            if (hasWon(player)) {
                return player;
            } else {
                return null;
            }
        } else {
            System.out.println("COMPUTER WON: " + move + " " + computerMove);
            computer.increaseScore();
            if (hasWon(computer)) {
                return computer;
            } else {
                return null;
            }
        }
    }

    @Override
    public String toString() {
        return "Game{" +
                "maxScore=" + maxScore +
                ", player=" + player +
                ", computer=" + computer +
                '}';
    }
}