package Chapter3;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.ListIterator;

public class RandomBag<Item> implements Iterable<Item> {
    private int N;
    private Item[] a;

    public RandomBag()
    {
        N = 0;
    }

    private boolean isEmpty() {
        return N==0;
    }

    private int size(){
        return N;
    }

    private void add(Item item)
    {
        if (a.length == N)
            resize(2*N);
        a[N++] = item;
    }

    private void resize(int max)
    {
        Item[] temp = (Item[]) new Object[max];
        for (int i=0;i<N;i++)
            temp[i] = a[i];
        a = temp;
    }


    @Override
    public Iterator<Item> iterator() {
        return new RandomBagIterator();
    }

    private class RandomBagIterator implements Iterator<Item>
    {
        private int current;
        public RandomBagIterator(){
            //洗牌,交换i和r的值
            for (int i =0;i<N;i++)
            {
                int r = i+ StdRandom.uniform(N-i);
                Item temp = (Item) a[i];
                a[i] = a[r];
                a[r] = temp;
            }
        }

        @Override
        public boolean hasNext() {
            return current!=N;
        }

        @Override
        public Item next() {
            return (Item)a[current++];
        }

        @Override
        public void remove() {

        }
    }
}
