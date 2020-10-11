package linear;

import java.util.Iterator;

public class LinkList<T> implements Iterable<T>{

    //头结点
    private Node head;

    //链表长度
    private int N;

    private class Node<T> {

        T item;

        Node next;

        public Node(T item,Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public LinkList(){
        //初始化
        this.head=new Node(null,null);
        this.N=0;
    }

    //清空链表
    public void clear(){
        head.next=null;
        this.N=0;
    }

    //判断链表是否为空
    public boolean isEmpty(){
        return N==0;
    }

    public int length(){
        return N;
    }

    //查找i处的数据
    public T get(int i){
        //从头节点开始往后找,找i次
        Node n = head.next;
        for(int index = 0;index<i;index++){
            n=n.next;
        }
        return (T) n.item;
    }

    //向链表插入元素
    public void insert(T t){
        //找到当前最后一个节点
        Node n = head;
        while (n.next != null){
            n=n.next;
        }
        //创建新节点保存元素
        Node newNode = new Node(t, null);
        //让当前最后一个节点指向新节点
        n.next=newNode;
        //元素个数+1
        N++;
    }

    //在指定位置插入元素
    public void insert(int i,T t){
        //找到i位置前一个节点
        Node pre= head;
        for (int index = 0;index<=i-1;index++){
            pre=pre.next;
        }
        //找i位置节点
        Node curr = pre.next;
        //创建新节点，指向i节点
        Node newNode = new Node(t,curr);
        //让i前一个位置的节点指向新节点
        pre.next = newNode;
        //元素+1
        N++;

    }

    //删除i位置的节点
    public T remove(int i){
        //寻找i前一位的节点
        Node node = head;
        for (int index = 0;index<=i-1;index++){
            node=node.next;
        }
        //找到i位置节点
        Node iNode = node.next;
        //找i的下一个节点
        Node nextNode = iNode.next;
        //前一个节点指向下一个节点
        node.next=nextNode;
        //元素-1
        N++;
        return (T) iNode;

    }

    //查找元素t在链表第一次出现的位置
    public int indexOf(T t){
        //从头结点开始，一次找出每个结点，取item去比较
        Node firstN = head;
        for (int i=0;firstN.next!=null;i++){
            firstN=firstN.next;
            if (firstN.item.equals(t)){
                return i;
            }
        }
        return -1;
    }


    @Override
    public Iterator<T> iterator() {
        return new LIterator();
    }

    private class LIterator implements Iterator{

        private Node n;
        public LIterator(){
            this.n=head;
        }

        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public Object next() {
            n=n.next;
            return n.item;
        }
    }

    //用来翻转整个链表
    public void reverse(){
      //判断是否为空链表,为空则返回，否则调用重载的reserve方法
      if (isEmpty()){
          return;
      } else {
          reverse(head.next);
      }
    }

    //翻转指定结点
    public Node reverse(Node curr){
        if (curr.next==null){
            head.next=curr;
            return curr;
        }
        //递归翻转当前结点的下一个结点,返回值就是链表翻转后当前结点的上一个结点
        Node pre = reverse(curr.next);
        //让返回的结点的下一个结点变成curr
        pre.next=curr;
        //把当前结点的下一个结点变为null
        curr.next=null;
        return curr;

    }

}
