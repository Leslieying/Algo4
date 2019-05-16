package Chapter1;
import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class EX23 {
    public static  int rank (int key, int[] a)
    {
        int lo = 0;
        int hi = a.length -1;
        while (lo < hi)
        {
            int mid = lo + (hi-lo)/2;
            if (key < a[mid]) hi = mid -1;
            else if (key > a[mid]) hi = mid + 1;
            else return mid;
        }
        return -1;
    }

    /*书中原例子
    public static void main(String []args)
    {
        int[] whitelist = In.readInts(args[0]);  //获取命令行输入到白名单中
        Arrays.sort(whitelist);                  //白名单排序
        while (!StdIn.isEmpty())
        {
            int key = StdIn.readInt();
            if (rank(key,whitelist) < 0)         //如果key不在白名单中，即return -1
                StdOut.println(key);
        }
    }
     */
    public static  void main(String[] args)
    {
        int a[] = {1,3,4,6,7,8,0};
        StdOut.println("Enter + or -?");
        char arg = StdIn.readChar();
        StdIn.readLine();
        StdOut.println("Enter Keys Please");
        String[] keys = StdIn.readLine().split(" ");  //获取输入的keys
        for (int i =0;i < keys.length; i++)
        {//如果在白名单中且arg为-,输出
            if (rank(Integer.parseInt(keys[i]), a) != -1 && arg == '-') {
                System.out.println("以下为白名单中的数值");
                System.out.printf("%s", keys[i]);
            }
            else if (rank(Integer.parseInt(keys[i]), a) == -1 && arg == '+')
            {
                System.out.println("以下为不在白名单中的数值");
                System.out.printf("%s", keys[i]);
            }
            else
                System.out.println("");
        }
    }
}
