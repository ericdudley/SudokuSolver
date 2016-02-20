/**
 * Created by ericd on 2/19/16.
 */
public class BasicSolver implements SudokuSolvability {
    public Board solve(Board board)
    {
        Board rboard = new Board(board.getName()+" Solved",board.getBoardStr());
        int counter = 0;
        int row = 0;
        while(counter < 10000 && !rboard.solved())
        {
            for (int col = 0; col < 9; col++)
            {
                if(!rboard.getBoard()[row][col].isFinished())
                {
                    this.eliminate(rboard, row, col);
                }
                else
                {
                    for(Cell $: rboard.getBoard()[row][col].getAll_ns())
                    {
                        $.remPoss(rboard.getBoard()[row][col].getPoss());
                    }
                }
            }
            row++;
            if (row == 9)
            {
                row = 0;
            }
            counter++;
        }
        System.out.println(counter);
        return rboard;
    }

    private  void eliminate(Board board, int row, int col)
    {
        Cell cell = board.getBoard()[row][col];
        for(Cell $:cell.getAll_ns())
        {
            if (cell.getSqr_ns().size() != 8 || cell.getSqr_ns().size() != 8 || cell.getSqr_ns().size() != 8) {
                System.out.println("Weird neighbours");
            }
            if($.isFinished())
            {
                //System.out.println("removing: "+$.getPoss()+" from "+row+", "+col);
                //System.out.println(cell.getPoss());
                if(cell.getPoss().equals($.getPoss()))
                {
                    //System.out.println("Impossibility occured!");
                    return;
                }
                cell.remPoss($.getPoss());
                //System.out.println(cell.getPoss());
            }
        }
    }
}
