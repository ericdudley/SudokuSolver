import java.util.ArrayList;

/**
 * Created by ericd on 2/19/16.
 */
public class Cell {
    private String poss;
    private ArrayList<Cell> row_ns;
    private ArrayList<Cell> col_ns;
    private ArrayList<Cell> sqr_ns;
    private ArrayList<Cell> all_ns;
    private int row;
    private int col;
    private boolean finished;

    public Cell(int row, int col)
    {
        this.row = row;
        this.col = col;
        this.poss = "123456789";
        this.row_ns = new ArrayList<Cell>();
        this.col_ns = new ArrayList<Cell>();
        this.sqr_ns = new ArrayList<Cell>();
        this.all_ns = new ArrayList<Cell>();
    }

    public Cell(int row, int col, String poss)
    {
        this(row, col);
        if(poss.length() == 1)
        {
            this.finished = true;
        }
        this.poss = poss;
    }

    @Override
    public String toString()
    {
        if(this.finished)
        {
            return this.poss.charAt(0)+"";
        }
        else
        {
            return "?";
        }
    }

}
