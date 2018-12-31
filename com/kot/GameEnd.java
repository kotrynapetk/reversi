package com.kot;

class GameEnd extends EndController {

    GameEnd(Map map) {
        super(map);
    }

    private int whiteDisks = getWhite();
    private int blackDisks = getBlack();

    void printWinner() {
        if (whiteDisks > blackDisks) {
            System.out.println("Player 1 has won: " + whiteDisks + " - " + blackDisks);
        } else {
            System.out.println("Player 2 has won: " + blackDisks + " - " + whiteDisks);
        }
    }
}
