package com.kot;

enum Actions {
    NORTH,
    NORTHEAST,
    EAST,
    SOUTHEAST,
    SOUTH,
    SOUTHWEST,
    WEST,
    NORTHWEST,
    NOTHING
}

class GameActions {

    private Map map;

    GameActions(Map map) {
        this.map = map;
    }

    void processAction(Actions action, int x, int y) {
        switch (action) {
            case NORTH:
                moveDisk(-1, 0, x, y);
                break;
            case NORTHEAST:
                moveDisk(-1, 1, x, y);
                break;
            case EAST:
                moveDisk(0, 1, x, y);
                break;
            case SOUTHEAST:
                moveDisk(1, 1, x, y);
                break;
            case SOUTH:
                moveDisk(1, 0, x, y);
                break;
            case SOUTHWEST:
                moveDisk(1, -1, x, y);
                break;
            case WEST:
                moveDisk(0, -1, x, y);
                break;
            case NORTHWEST:
                moveDisk(-1, -1, x, y);
                break;
        }
    }

    private void moveDisk(int x, int y, int newX, int newY) {

        int player = BoardActioner.player;

        for (int i = 1; i < map.getHeight(); i++) {
            Boolean notAvailableSquare = map.map[newY][newX] != player;
            Boolean newSquareIsTaken = map.map[newY + x][newX + (1 + y)] == player;
            Boolean newSquareIsNotEmpty = map.map[newY + x][newX + y] == 0;

            if (canMove(notAvailableSquare, newSquareIsTaken, newSquareIsNotEmpty)) break;
            if (doMove(x, y, newX, newY, player, i)) break;
        }
    }

    private boolean doMove(int x, int y, int newX, int newY, int player, int i) {
        if (map.map[newY + (i * x)][newX + (i * y)] != player) {
            return checkX(x, y, newX, newY, player, i);
        }
        return false;
    }

    private boolean canMove(Boolean notAvailableSquare, Boolean newSquareIsTaken, Boolean newSquareIsNotEmpty) {
        if (notAvailableSquare | newSquareIsTaken | newSquareIsNotEmpty) {
            System.out.println("Wrong move");
            return true;
        }
        return false;
    }

    private boolean checkX(int x, int y, int newX, int newY, int player, int i) {
        if (map.map[newY + (i * x) + x][newX + (i * y) + y] == 0) {
            map.map[newY + (i * x) + x][newX + (i * y) + y] = player;

            checkY(x, y, newX, newY, player, i);
            choosePlayer(player);

            return true;
        }
        return false;
    }

    private void checkY(int x, int y, int newX, int newY, int player, int i) {
        for (int j = 1; j <= i; j++) {
            map.map[newY + (j * x)][newX + (j * y)] = player;
        }
    }

    private void choosePlayer(int player) {
        if (player == 1) {
            BoardActioner.player = 2;
        } else if (player == 2) {
            BoardActioner.player = 1;
        }
    }
}
