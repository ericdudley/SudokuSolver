import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ericd on 2/19/16.
 */
public class Board {
    public static final String EMPTY_CELL_CHAR = ".";
    public static int next_id = 0;

    public Cell[][] getBoard() {
        return board;
    }

    private Cell[][] board;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public int getId() {
        return id;
    }

    private int id;

    private Cell[][] parseBoardStr(String board_str)
    {
        if(board_str.equals(""))
        {
            return null;
        }
        Cell[][] board = new Cell[9][9];
        for(int row=0; row<9; row++)
        {
            for(int col=0; col<9; col++)
            {
                String elem = Character.toString(board_str.charAt((row*9)+col));
                if(elem.equals(Board.EMPTY_CELL_CHAR))
                {
                    board[row][col] = new Cell(row, col);
                }
                else
                {
                    board[row][col] = new Cell(row, col, elem);
                }
            }
        }
        return board;
    }

    private Cell[][] genRandomBoard()
    {
        return null;
    }

    public Board(String name, String board_str)
    {
        this.board = this.parseBoardStr(board_str);
        this.name = name;
        this.id = Board.next_id;
        Board.next_id++;
    }

    public Board(String board_str)
    {
        this("Default Name", board_str);
    }

    public Board()
    {
        this("");
        this.board = this.genRandomBoard();
    }

    @Override
    public String toString()
    {
        String rstr = "";
        for(int row=0; row<9; row++)
        {
            for(int col=0; col<9; col++)
            {
                rstr += this.board[row][col].toString();
            }
            rstr += "\n";
        }
        return rstr;
    }

}
