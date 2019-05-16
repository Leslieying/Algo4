package Chapter3;
import java.util.Iterator;
import java.util.Objects;

public class ResizingArrayStack<Item> implements Iterable<Item>{
    private Item[] a = (Item[]) new Object[1];
    private int N = 0;
    public boolean isEmpty() {return N==0;}
    public int size() {return N;}

    private void resize(int max)
    {
        Item[] temp = (Item[]) new Object[max]; //新建一个新数组
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];   //逐个将元素移动到新数组中
        }
        a = temp; //将数组管理者交给a
    }

    //push()函数也要随之改变，主要是要检测数组是否太小
    public void push(Item item)
    {
        if (N == a.length) resize(2*a.length); //先检查数组容量是否够，如果不够，加倍。N是栈里的元素数量
        a[N++] = item;
    }
    //pop()函数首先要删除栈顶元素，然后判断数组是否太大
    public Item pop()
    {
        Item item = a[--N];
        a[N] = null;  //避免对象游离，游离就是指：保存一个不需要引用的对象，或者是一个孤儿
        if (N>0 && N ==a.length/4) {
            resize(a.length/2);
        }
        return item;
    }
    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    //内部类
    private class ReverseArrayIterator implements Iterator<Item>
    {
        private int i = N;
        public boolean hasNext() { return i>0; }
        public Item next()       { return a[--i]; }
        public void remove() {}
    }
}
