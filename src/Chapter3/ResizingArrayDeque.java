package Chapter3;

import java.util.Iterator;

public class ResizingArrayDeque<Item> implements Iterable<Item>{
    private Item[] q;
    private int N;     //data size
    private int first; //index of first element of queue
    private int last;  //index of next available element

    private void resize(int max)
    {
        Item[] temp = (Item[]) new Object[max];
        for (int i=0;i<N;i++)
            temp[i] = q[i];
        q = temp;
    }

    public boolean isEmpty() {
        return N==0;
    }

    public int size() {
        return N;
    }

    public void pushLeft(Item item)
    {
        Item[] temp = (Item[]) new Object[N];
        temp[0] = item;
        for (int i=0;i<N;i++)
            temp[i+1] = q[i];
        q = temp;
        N++;
    }

    public void pushRight(Item item)
    {
        if (N == q.length)
            resize(2*q.length);
        q[N++] = item;
    }

    public Item popLeft()
    {
        Item item = q[0];
        q[0] = null;
        Item[] temp = (Item[]) new Object[N];
        for (int i=0;i<N;i++)
            temp[i] = q[i+1];
        q = temp;
        N--;
        return item;
    }

    public Item popRight()
    {
        Item item = q[--N];
        q[N] = null;
        if (N>0 && N ==q.length/4)
            resize(q.length/2);
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
