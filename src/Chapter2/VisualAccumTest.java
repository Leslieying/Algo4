package Chapter2;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class VisualAccumTest {
    private double total;
    private int N;

    public VisualAccumTest(int trials, double max) {
        StdDraw.setXscale(0, trials);
        StdDraw.setYscale(0, max);
        StdDraw.setPenRadius(.005);
    }

    public void addDataValue(double val) {
        N++;
        total += val;
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.point(N, val);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(N, total / N);
    }

    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        VisualAccumTest a = new VisualAccumTest(T, 1.0);
        for (int t = 0; t<T; t++)
        {
            a.addDataValue(Math.random());
            StdOut.println(a);
        }
    }
}