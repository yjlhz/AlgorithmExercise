package linear;

import java.security.PublicKey;
import java.util.Iterator;

public class TwoWayLinkList<T> implements Iterable<T>{

    //首结点
    private Node head;

    //尾结点
    private Node last;

    //链表长度
    private int N;

    @Override
    public Iterator<T> iterator() {

        return new TIterator();
    }

    private class TIterator implements Iterator<T>{

        private Node n;

        public TIterator(){
            this.n=head;
        }

        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public T next() {
            n=n.next;
            return n.item;
        }
    }


    private class Node{
        public Node(T item,Node pre,Node next){
            this.item=item;
            this.next=next;
            this.pre=pre;
        }

        //存储数据
        public T item;
        //指向上一个结点
        public Node pre;
        //指向下一个结点
        public Node next;

    }

    public TwoWayLinkList(){
        //初始化头结点和尾结点
        this.head=new Node(null,null,null);
        this.last=null;
        this.N=0;
    }

    //清空链表
    public void clear(){
        this.head.next=null;
        this.last=null;
        this.N=0;
    }

    //判断链表是否为空
    public boolean isEmpty(){
        return N==0;
    }

    //返回链表长度
    public int length(){
        return N;
    }

    //获取第一个元素
    public T getFirst(){
        if(isEmpty()){
            return null;
        }
        return head.next.item;
    }

    //获取最后一个元素
    public T getLast(){
        if (isEmpty()){
            return null;
        }
        return last.item;
    }

    //插入元素
    public void insert(T t){

        if (isEmpty()){
            //如果链表为空
            //创建新节点
            Node newNode = new Node(t, head, null);
            //让新节点成为尾结点
            last=newNode;
            //让头结点指向尾结点
            head.next=last;
        }else {
            //如果链表不为空
            Node oldLast=last;
            Node newNode = new Node(t, oldLast, null);
            //创建新结点
            //让当前尾结点指向尾结点
            oldLast.next=newNode;
            //让新结点成为尾结点
            last=newNode;
        }

        //元素个数+1
        N++;

    }

    //在指定位置插入元素
    public void insert(int i,T t){
        Node pre = head;
        //找到i位置的前一个结点
        for (int index = 0;index<i;index++){
            pre=pre.next;
        }
        //找到i位置的结点
        Node curr = pre.next;
        //创建新结点
        Node newNode = new Node(t, pre, curr);
        pre.next=newNode;
        curr.pre=newNode;
        N++;

    }

    //获取i位置的元素
    public T get(int i){
        Node n = head.next;
        for (int index=0;index<i;index++){
            n=n.next;
        }
        return n.item;
    }

    //找到元素t在链表第一次出现的位置
    public int indexOf(T t){
        Node n = head;
        for (int index=0;head.next!=null;index++){
            n=n.next;
            if (n.item.equals(t)){
                return index;
            }
        }
        return -1;
    }

    //删除i位置的元素
    public T remove(int i){
        Node pre = head;
        //寻找i前一个结点
        for (int index=0;index<i;index++){
            pre=pre.next;
        }
        Node curr = pre.next;
        Node nextNode = curr.next;
        pre.next=nextNode;
        nextNode.pre=pre;
        N--;
        return curr.item;
    }

}
