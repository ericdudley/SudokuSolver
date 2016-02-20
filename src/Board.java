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

    public String getBoardStr() {
        return boardStr;
    }

    private String boardStr;
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

    private void buildSqrNeighbours(Cell curr, int row, int col)
    {
        if(row<3 && col<3)
        {
            for(int i=0; i<3; i++)
            {
                for(int j=0; j<3; j++)
                {
                    if(!this.board[i][j].equals(curr))
                    {
                        curr.addToN(this.board[i][j],"sqr");
                    }
                }
            }
        }
        if(row>2 && row<6 && col<3)
        {
            for(int i=3; i<6; i++)
            {
                for(int j=0; j<3; j++)
                {
                    if(!this.board[i][j].equals(curr))
                    {
                        curr.addToN(this.board[i][j],"sqr");
                    }
                }
            }
        }
        if(row>5 && col<3)
        {
            for(int i=6; i<9; i++)
            {
                for(int j=0; j<3; j++)
                {
                    if(!this.board[i][j].equals(curr))
                    {
                        curr.addToN(this.board[i][j],"sqr");
                    }
                }
            }
        }
        if(row<3  && col>2 && col<6)
        {
            for(int i=0; i<3; i++)
            {
                for(int j=3; j<6; j++)
                {
                    if(!this.board[i][j].equals(curr))
                    {
                        curr.addToN(this.board[i][j],"sqr");
                    }
                }
            }
        }
        if(row>2  && row<6 && col>2 && col<6)
        {
            for(int i=3; i<6; i++)
            {
                for(int j=3; j<6; j++)
                {
                    if(!this.board[i][j].equals(curr))
                    {
                        curr.addToN(this.board[i][j],"sqr");
                    }
                }
            }
        }
        if(row>5 && col>2 && col<6)
        {
            for(int i=6; i<9; i++)
            {
                for(int j=3; j<6; j++)
                {
                    if(!this.board[i][j].equals(curr))
                    {
                        curr.addToN(this.board[i][j],"sqr");
                    }
                }
            }
        }
        if(row<3  && col>5)
        {
            for(int i=0; i<3; i++)
            {
                for(int j=6; j<9; j++)
                {
                    if(!this.board[i][j].equals(curr))
                    {
                        curr.addToN(this.board[i][j],"sqr");
                    }
                }
            }
        }
        if(row>2  && row<6 && col>5)
        {
            for(int i=3; i<6; i++)
            {
                for(int j=6; j<9; j++)
                {
                    if(!this.board[i][j].equals(curr))
                    {
                        curr.addToN(this.board[i][j],"sqr");
                    }
                }
            }
        }
        if(row>5 && col>5)
        {
            for(int i=6; i<9; i++)
            {
                for(int j=6; j<9; j++)
                {
                    if(!this.board[i][j].equals(curr))
                    {
                        curr.addToN(this.board[i][j],"sqr");
                    }
                }
            }
        }
    }

    private void buildNeighbours()
    {
        for(int row=0; row<9; row++)
        {
            for(int col=0; col<9; col++)
            {
                Cell curr = this.board[row][col];
                this.buildSqrNeighbours(curr,row,col);
                for(int row2=0; row2<9; row2++)
                {
                    if(!this.board[row2][col].equals(curr) && !curr.getAll_ns().contains(this.board[row2][col]))
                    {
                        curr.addToN(this.board[row2][col],"col");
                    }
                }
                for(int col2=0; col2<9; col2++)
                {
                    if(!this.board[row][col2].equals(curr) && !curr.getAll_ns().contains(this.board[row][col2]))
                    {
                        curr.addToN(this.board[row][col2],"row");
                    }
                }
            }
        }
    }
    private Cell[][] genRandomBoard()
    {
        return null;
    }

    public Board(String name, String board_str)
    {
        this.board = this.parseBoardStr(board_str);
        this.buildNeighbours();
        this.name = name;
        this.id = Board.next_id;
        this.boardStr = board_str;
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

    public boolean solved()
    {
        boolean solved = true;
        for(int row=0; row<9; row++)
        {
            for(int col=0; col<9; col++)
            {
                if(!this.board[row][col].isFinished())
                {
                    solved = false;
                }
            }
        }
        return solved;
    }

    public long distanceFromSolved()
    {
        long product = 0;
        for(int row=0; row<9; row++)
        {
            for(int col=0; col<9; col++)
            {
                product += this.board[row][col].getPoss().length();
            }
        }
        return product-81;
    }

    @Override
    public String toString()
    {
        String rstr = this.name+"\n";
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
