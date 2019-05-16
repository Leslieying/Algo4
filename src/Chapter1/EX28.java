package Chapter1;

import java.util.ArrayList;
import java.util.Arrays;

public class EX28 {
    public static Integer[] main(String[]args)
    {
        //基本思路就是先排序，在删除和前一个重复的元素
        int[] whitelist = {7,2,4,5,6,8,9};
        Arrays.sort(whitelist);
        ArrayList <Integer> list = new ArrayList<>();
        for (int i=0; i<whitelist.length-1;i++)
        {
            if (whitelist[i] != whitelist[i+1])
            {
                list.add(whitelist[i]);
            }
        }
        list.add(whitelist[whitelist.length-1]); //最后一个元素

        Integer[] new_whitelist = list.toArray(new Integer[list.size()]);
        return new_whitelist;
    }
}
