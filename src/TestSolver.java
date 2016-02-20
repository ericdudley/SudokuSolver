/**
 * Created by ericd on 2/19/16.
 */
public class TestSolver {
    public static void main(String[] args)
    {
        Board board = new Board("..3.2.6..9..3.5..1..18.64....81.29..7.......8..67.82....26.95..8..2.3..9..5.1.3..");
        System.out.println(board.toString());
        System.out.println("Distance from solved: "+board.distanceFromSolved());
        BasicSolver solver = new BasicSolver();
        Board solved_board = solver.solve(board);
        System.out.println(solved_board.toString());
        System.out.println("Distance from solved: "+solved_board.distanceFromSolved());
    }
}
