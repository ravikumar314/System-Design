import java.util.concurrent.ThreadLocalRandom;

public class Board {

    Cell[][] cells;

    public Board(int boardSize, int numberOfSnakes, int numberOfLadder ){

        initializeBoard(boardSize);
        addSnakesLadder(numberOfLadder, numberOfSnakes);
    }

    void initializeBoard(int boardSize){

        cells = new Cell[boardSize][boardSize];


        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                Cell cellObj = new Cell();
                cells[i][j] = cellObj;
            }
        }
    }

    void addSnakesLadder(int numberOfLadder, int numberOfSnakes){

        // add snakes
        while(numberOfSnakes > 0){
            int snakeHead = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length -1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);

            if(snakeHead < snakeTail)
                  continue;

            //set jump
            Jump snakeObj = new Jump();
            snakeObj.start = snakeHead;
            snakeObj.end = snakeTail;

            Cell cell = getCell(snakeHead);
            cell.jump = snakeObj;

            //System.out.println("Add snakes");

            // snake added
            numberOfSnakes--;
        }

        while(numberOfLadder > 0){

            int ladderHead = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            int ladderTail = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);

            if(ladderTail < ladderHead)
                  continue;

            //set jump
            Jump ladderObj = new Jump();
            ladderObj.start = ladderHead;
            ladderObj.end = ladderTail;

            // add to cell
            Cell cell = getCell(ladderTail);
            cell.jump = ladderObj;

            // ladder added
            numberOfLadder--;
        }


    }

    Cell getCell(int playerPosition){
        int row = playerPosition / cells.length;
        int col = playerPosition % cells.length;

        return cells[row][col];
    }


}
