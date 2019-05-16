package Chapter2;

import java.util.Random;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;

public class EX1 {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Point2D[] points = new Point2D[N];
        for (int i = 0;i<N;i++)
        {
            points[i] = new Point2D(Math.random(),Math.random());
            points[i].draw();
        }
        if (N > 1){
            double min = points[0].distanceTo(points[1]);
            for (int i = 0;i<N-1;i++)
            {
                for (int j = 0;j<N-1;j++)
                {
                    if (points[i].distanceTo(points[j]) < min)
                    {
                        min = points[i].distanceTo(points[j]);
                    }
                }
            }
            System.out.println("the minimum distance is"+min);
        }
    }
}
