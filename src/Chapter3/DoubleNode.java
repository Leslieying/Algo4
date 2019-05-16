package Chapter3;

public class DoubleNode<Item> {
    private Node first;
    private Node last;

    private class Node{
        Item item;
        Node prev;
        Node next;
    }

    private void InsertAtHead(Node x)
    {
        Node oldfirst = first;
        first = x;
        first.next = oldfirst;
    }

    private void InsertAtNail(Node x)
    {
        Node current = new Node();
        current = first;
        while (current.next != null)
        {
            current = current.next;
        }
        current.next = x;
        x.prev = current;
    }

    private void DeleteHead()
    {
        Node second = new Node();
        second = first.next;
        first.next = null;
        second.prev = null;
        first = second;
    }

    private void DeleteTail()
    {
        Node current = new Node();
        current = first;
        while (current.next != null)
        {
            current = current.next;
        }
        current.prev.next = null;
        current.prev = null;
    }

    private void InsertBefore(Node current, Node newNode)
    {
        current.prev.next = newNode;
        newNode.next = current;
        current.prev = newNode;
    }

    private void InsertAfter(Node current, Node newNode)
    {
        newNode.next = current.next;
        current.next = newNode;
        newNode.prev = current;
    }

    private void delete(Node deleteNode)
    {
        if(deleteNode.prev==null && deleteNode.next!=null)
        {
            deleteNode.next.prev=null;
            deleteNode.next=null;
        }
        else if(deleteNode.prev!=null && deleteNode.next==null)
        {
            deleteNode.prev.next=null;
            deleteNode.prev=null;
        }
        else if(deleteNode.prev==null && deleteNode.next==null)
        {
            deleteNode.prev=null;
            deleteNode.next=null;
        }
        else
        {
            deleteNode.prev.next=deleteNode.next;
            deleteNode.next.prev=deleteNode.prev;
            deleteNode.prev=null;
            deleteNode.next=null;
        }
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }
}


