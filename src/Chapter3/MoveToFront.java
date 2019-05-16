package Chapter3;


import edu.princeton.cs.algs4.StdIn;

public class MoveToFront<Item> {
    private Node first;
    private Node last;
    private int N;

    private class Node
    {
        Item item;
        Node prev;
        Node next;
    }

    private void InsertFirst(Item item)
    {
        Node newfirst = new Node();
        newfirst.item = item;
        newfirst.next = first;
        first = newfirst;
    }

    private boolean ifRepeat(Item item)
    {
        Node current = new Node();
        while ( current.next != null) {
            current = current.next;
            if (current.item == item) {
                current.prev.next = current.next;
                current.item = null;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MoveToFront<String> list = new MoveToFront<String>();
        while (StdIn.isEmpty())
        {
            String item = StdIn.readString();
            list.ifRepeat(item);
            list.InsertFirst(item);
        }

    }
}
