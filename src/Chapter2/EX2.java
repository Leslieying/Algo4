package Chapter2;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;

public class EX2 {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Interval1D[] intervals = new Interval1D[N];
        for (int i =0; i<N;i++)
        {
            double lo = StdIn.readDouble();
            double hi = StdIn.readDouble();
            intervals[i] = new Interval1D(lo,hi);
        }
        if (N>1){
            for (int i=0;i<N;i++)
            {
                for(int j =0;j<i+1;j++)
                {
                    if (intervals[i].intersects(intervals[j]))
                        System.out.printf("interval[%d] intersect with interval[%d]",i,j);
                }
            }
        }
    }
}
