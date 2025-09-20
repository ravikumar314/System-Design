import java.util.ArrayList;
import java.util.List;

public class Board {
    int size;
    PlayingPiece[][] board;

    public Board(int size){
        this.size = size;
        this.board = new PlayingPiece[size][size];

    }

    public boolean addPiece(int row, int column, PlayingPiece playingPiece){
        if(board[row][column] != null)
               return false;
        board[row][column] = playingPiece;

        return true;
    }

      List<List<Integer>> checkFreeSpace(){

        List<List<Integer>> freeCells = new ArrayList<>();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                List<Integer> rowColumn = new ArrayList<>();
                if(board[i][j] == null){
                    rowColumn.add(i);
                    rowColumn.add(j);
                    freeCells.add(rowColumn);
                }
            }
        }

        return freeCells;

      }

    void printBoard(){

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(board[i][j] != null){
                    System.out.print(board[i][j].pieceType.name()+ " ");
                }
                else{
                    System.out.print("  ");
                }
                System.out.print("|");
            }

            System.out.println();
        }
    }

}
