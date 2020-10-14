package symbol;

public class OrderSymbolTable<Key extends Comparable<Key>,Value> {
    //记录首结点
    private Node head;
    //记录符号表的元素
    private int N;

    private class Node{
        //键
        public Key key;
        //值
        public Value value;
        //下一个结点
        public Node next;

        public Node(Key key,Value value,Node next){
            this.key=key;
            this.value=value;
            this.next=next;
        }
    }

    public OrderSymbolTable(){
        this.head = new Node(null,null,null);
        this.N = 0;
    }

    //获取符号表中键值对的个数
    public int size(){
        return N;
    }

    //插入键值对
    public void put(Key key,Value value){
        Node curr = head.next;
        Node pre = head;
        while (curr!=null && key.compareTo(curr.key)>0){
            pre = curr;
            curr = curr.next;
        }
        if (curr!=null && key.compareTo(curr.key)==0){
            curr.value=value;
            return;
        }
        Node newNode = new Node(key, value, curr);
        pre.next = newNode;
        N++;
    }

    public void delete(Key key){
        //找到为key的结点，将其删除
        Node n = head;
        while (n.next!=null){
            if (n.next.key.equals(key)){
                n.next=n.next.next;
                N--;
                return;
            }
            n=n.next;
        }
    }

    public Value get(Key key){
        Node n = head;
        while(n.next!=null){
            n=n.next;
            if (n.key.equals(key)){
                return n.value;
            }
        }
        return null;
    }

}
