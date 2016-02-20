/**
 * Created by ericd on 2/19/16.
 */
public class Pos {
    public int row;

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int col;
    public Pos(int row, int col)
    {
        this.row = row;
        this.col = col;
    }
}
