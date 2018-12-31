package com.kot;

class EndController {

    private Map map;
    private int diskCount = 0;
    private int white = 0;
    private int black = 0;

    EndController(Map map) {
        this.map = map;

    }

    boolean isGameOver() {
        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                if (map.map[i][j] > 0) diskCount++;
                if (map.map[i][j] == 1) white++;
                if (map.map[i][j] == 2) black++;
            }
        }
        if (diskCount < 100) {
            diskCount = 0;
            white = 0;
            black = 0;
        }
        return diskCount == 100;
    }

    boolean exit() {
        return false;
    }

    int getWhite() {
        return white;
    }

    int getBlack() {
        return black;
    }

}
