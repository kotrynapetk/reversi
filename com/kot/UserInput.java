package com.kot;

import java.util.Scanner;

class UserInput {
    
    private Scanner keyboard = new Scanner(System.in);

    private int x;
    private int y;

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    
    Actions getInput(){
        return getCommand(keyboard.nextLine());
    }
    
    private Actions getCommand(String input){
            String[] parts = input.split(" ");
            x = Integer.parseInt(parts[1])-1;
            y = Integer.parseInt(parts[0])-1;

            String command = parts[2];
            
            switch(command){
                case "n":
                    return Actions.NORTH;
                case "ne":
                    return Actions.NORTHEAST;
                case "e":
                    return Actions.EAST;
                case "se":
                   return Actions.SOUTHEAST;
                case "s":
                    return Actions.SOUTH;
                case "sw":
                    return Actions.SOUTHWEST;
                case "w":
                    return Actions.WEST;
                case "nw":
                    return Actions.NORTHWEST;
                default:
                    return Actions.NOTHING;
            }    
    }
}
