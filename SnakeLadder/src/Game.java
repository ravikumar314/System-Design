import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    Dice dice;
    Deque<Player> playerList = new LinkedList<>();
    Player winner;

    public Game(){
        initialize();
    }

    void initialize(){

        board = new Board(5, 3,2);
        dice = new Dice(1);
        addPlayer();
    }

    void addPlayer(){
        // intialize player
        Player player1 = new Player("Ravi", 0);
        Player player2 = new Player("Deepti", 0);

        // add player to list
        playerList.add(player1);
        playerList.add(player2);

        System.out.println("Player 1 :  " + player1.playerId);
        System.out.println("Player 2 :  " + player2.playerId);
    }

    //play game here
    void startGame(){

        System.out.println("Game starts here");

        while (winner == null){
            Player playerTurn = findPlayerTurn();

            System.out.println(playerTurn.playerId + " is playing");
            System.out.println("Start position " + playerTurn.currentPosition);

            int diceNumber = dice.rollDice();

            int playerNewPosition = playerTurn.currentPosition + diceNumber;
            // check if it meets ladder or snake
            playerNewPosition = checkJump(playerNewPosition);
            playerTurn.currentPosition = playerNewPosition;

            System.out.println("New position after rolling dice " + playerTurn.currentPosition);

            if(playerNewPosition >= board.cells.length * board.cells.length - 1){
                winner = playerTurn;
            }
        }

        System.out.println(winner.playerId + " is Winner");
    }

    int checkJump(int playerNewPosition){

        if(playerNewPosition >= board.cells.length * board.cells.length - 1)
              return playerNewPosition;
        Cell cell = board.getCell(playerNewPosition);

        if(cell.jump != null && cell.jump.start == playerNewPosition){

            String message = cell.jump.start > cell.jump.end ? "snake" : "ladder";
            System.out.println("jump is by " + message);
               return  cell.jump.end;
        }

        return playerNewPosition;
    }


    Player findPlayerTurn(){

        Player player = playerList.removeFirst();
        playerList.addLast(player);
        return player;
    }


}
