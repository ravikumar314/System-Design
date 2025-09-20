import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Game {
    Deque<Player> player;
    Board board;

    Game(){
        initialize();
    }

    private void initialize() {

        player = new LinkedList<>();
        PlayingPiece cross = new PieceX();
        Player player1 = new Player("Ravi", cross);

        PlayingPiece not = new PieceO();
        Player player2 = new Player("Deepti", not);

        player.add(player1);
        player.add(player2);
        board = new Board(3);
        board.printBoard();
    }


    public String startGame(){

        boolean isWinner = true;
        while(isWinner){
            // get the current player
            Player currPlayer = player.removeFirst();

            // print the board
            board.printBoard();

            // check free space
            List<List<Integer>> freeSpace = board.checkFreeSpace();

            if(freeSpace.isEmpty()){
                isWinner = false;
                continue;
            }

            System.out.println("Player " + currPlayer.name +" enter the row, column");

            // take the orw column input
            Scanner scan = new Scanner(System.in);

            String s = scan.nextLine();
            String[] arr = s.split(",");
            int row = Integer.parseInt(arr[0]);
            int column = Integer.parseInt(arr[1]);

            boolean isCorrect = board.addPiece(row, column, currPlayer.playingPiece);

            if(!isCorrect){
                System.out.println("Invalid position: Please enter correct move");
                player.addFirst(currPlayer);
                continue;
            }

            player.addLast(currPlayer);

            boolean winner = checkWinner(row, column, currPlayer.playingPiece.pieceType);
            if(winner)
                return currPlayer.name + " is Winner";

        }
       return "tie";
    }

    public  boolean checkWinner(int row, int column, PieceType pieceType){

        boolean winnerRow = true;
        boolean winnerColumn = true;
        boolean winnerDiag = true;
        boolean winnerAntiDiag = true;

        // check row
        for(int i = 0; i < board.size; i++){
            if(board.board[row][i] == null || board.board[row][i].pieceType != pieceType){
                winnerRow = false;
                break;
            }
        }

        //check column
        for(int i = 0; i < board.size; i++){
            if(board.board[i][column] == null || board.board[i][column].pieceType != pieceType){
                winnerColumn = false;
                break;
            }
        }

        // check diagonal
        for(int i = 0; i < board.size; i++){
            if(board.board[i][i] == null || board.board[i][i].pieceType != pieceType){
                winnerDiag = false;
                break;
            }
        }

        // check anti diagonal
        for(int i = 0, j = board.size - 1; i < board.size; i++, j--){
            if(board.board[i][j] == null || board.board[i][j].pieceType != pieceType){
                winnerAntiDiag = false;
                break;
            }
        }


        return winnerColumn || winnerDiag || winnerAntiDiag || winnerRow;
    }

}
