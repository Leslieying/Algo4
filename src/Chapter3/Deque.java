package Chapter3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private int N;
    private Node<Item> first;
    private Node<Item> last;


    private class Node<Item> {
        Item item;
        Node prev;
        Node next;
    }

    private Deque(){
        first = null;
        last = null;
        N = 0;
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public void pushLeft(Item item)
    {
        if (item == null)
            throw new java.lang.NullPointerException();
        Node<Item> newfirst = new Node<Item>();
        newfirst.item = item;
        newfirst.next = first;
        newfirst.prev = null;
        if (isEmpty())
            last = newfirst;
        else
            first.prev = newfirst;
        first = newfirst;
        N++;
    }

    public void pushRight(Item item)
    {
        if (item == null)
            throw new java.lang.NullPointerException();
        Node<Item> newlast = new Node<Item>();
        newlast.prev = last;
        newlast.item = item;
        newlast.next = null;
        if (isEmpty())
            first = newlast;
        else
            last.next = newlast;
        last = newlast;
        N++;
    }

    public Item popLeft()
    {
        if (N==0)
            throw new NoSuchElementException();
        Item firstelement = first.item;
        first = first.next;
        N--;
        if(isEmpty())
            last = null;
        else
            first.prev = null;
        return firstelement;
    }

    public Item popRight()
    {
        if (N==0)
            throw new NoSuchElementException();
        Item lastelement = last.item;
        last = last.prev;
        N--;
        if (isEmpty())
            first = null;
        else
            last.next = null;
        return lastelement;
    }

    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator<>();
    }

    private class DequeIterator<Item> implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext()
        {  return current != null;  }

        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext())
                throw new java.util.NoSuchElementException();
            Item item = (Item) current.item;
            current = current.next;
            return item;
        }
    }
}
