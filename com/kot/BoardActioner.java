package com.kot;
class BoardActioner {
    
    private final Map map;
    static int player = 1;
    
    BoardActioner(Map map){
        this.map = map;
    }

    void printBoard(){
        System.out.format("     ---------------------%n");
        System.out.format("     |1|2|3|4|5|6|7|8|9|10|%n");
        System.out.format("     ---------------------%n");
        
        for(int i = 0; i < map.getHeight(); i++){
            if(i == 9) System.out.format("|" + (i + 1) + "| ");
                else System.out.format("|" + (i + 1) + "|  ");
            for (int j = 0; j < map.getWidth(); j++){
                System.out.print("|");
                printDisks(map.map[i][j]);
            }
            System.out.print("|");
            System.out.println();
        }
        printControls();
    }

    private void printDisks(int i) {
        switch (i) {
            case 1:
                System.out.print("W");
                break;
            case 2:
                System.out.print("B");
                break;
            default:
                System.out.print(" ");
                break;
        }
    }

    private void printControls() {
        System.out.println("Player 1 is white, player 2 is black. Choose starting disk [y x direction]:\n" +
                                "Action directions:\n" +
                                "'n'  // north\n" +
                                "'ne' // north-east\n" +
                                "'e'  // east\n" +
                                "'se' // south-east\n" +
                                "'s'  // south\n" +
                                "'sw' // south-west\n" +
                                "'w'  // west\n" +
                                "'nw' // north-west\n" +
                                player + " player\n");
    }
}
