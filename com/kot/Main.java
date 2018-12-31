package com.kot;

public class Main {

    public static void main(String[] args) {

        Map map = new Map();

        BoardActioner renderer = new BoardActioner(map);
        GameActions gameActions = new GameActions(map);
        UserInput userInput = new UserInput();
        EndController endController = new EndController(map);
        GameEnd gameEnd = new GameEnd(map);
        boolean playing = true;

        do {
            renderer.printBoard();
            if (endController.isGameOver()) {
                gameEnd.printWinner();
                playing = endController.exit();
            }

            Actions command = userInput.getInput();
            int x = userInput.getX();
            int y = userInput.getY();

            gameActions.processAction(command, x, y);

        } while (playing);
    }

}
