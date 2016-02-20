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

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public ArrayList<Cell> getAll_ns() {
        return all_ns;
    }

    public ArrayList<Cell> getSqr_ns() {
        return sqr_ns;
    }

    public ArrayList<Cell> getCol_ns() {
        return col_ns;
    }

    public ArrayList<Cell> getRow_ns() {
        return row_ns;
    }

    public String getPoss() {
        return poss;
    }

    public boolean isFinished() {
        return finished;
    }
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
        this.finished = false;
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

    public void remPoss(String elem)
    {
        this.poss = this.poss.replace(elem,"");
        if(this.poss.length() == 1)
        {
            this.finished = true;
        }
    }

    public void addToN(Cell neighbour, String cat)
    {
        if(cat.equals("row"))
        {
            this.row_ns.add(neighbour);
        }
        else if(cat.equals("col"))
        {
            this.col_ns.add(neighbour);
        }
        else if(cat.equals("sqr"))
        {
            this.sqr_ns.add(neighbour);
        }
        this.all_ns.add(neighbour);
    }

    @Override
    public String toString()
    {
        if(this.poss.length() == 0)
        {
            return " ?";
        }
        if(this.finished)
        {
            return " "+this.poss.charAt(0)+"";
        }
        else
        {
            return " .";
            //return "|"+this.poss.length();
        }
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof Cell)
        {
            Cell other = (Cell)obj;
            return this.row == other.row && this.col == other.col;
        }
        else
        {
            return false;
        }
    }

}
