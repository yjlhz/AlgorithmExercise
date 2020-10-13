package linear;

import java.util.Iterator;

public class Stack<T> implements Iterable<T>{

    //记录首结点
    private Node head;
    //栈中元素个数
    private int N;

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    public class Node<T> {

        T item;

        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public Stack(){
        this.head = new Node(null,null);
        this.N = 0;
    }

    //判断栈中元素是否为空
    public boolean isEmpty(){
        return N==0;
    }

    //获取栈中元素的个数
    public int size(){
        return N;
    }

    //压栈
    public void push(T t){
        //找到首结点指向的第一个结点
        Node oldFirst = head.next;
        //创建新结点
        Node newNode = new Node(t,oldFirst);
        //让首结点指向新结点
        head.next = newNode;
        //元素个数+1
        N++;
    }

    //弹栈
    public T pop(){
        //找到首结点指向的第一个结点
        Node oldFirst = head.next;
        if (oldFirst==null){
            return null;
        }
        //让首结点指向原来第一个结点的下一个结点
        head.next=oldFirst.next;
        //元素个数-1
        N--;
        return (T) oldFirst.item;
    }

    private class SIterator implements Iterator{

        private Node n = head;

        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public Object next() {
            Node node = n.next;
            n=n.next;
            return node.item;
        }
    }

}
