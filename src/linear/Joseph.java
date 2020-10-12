package linear;

public class Joseph {
    public static void main(String[] args) {

        //构建循环列表
        Node<Integer> first = null;//记录首结点
        Node<Integer> pre = null;//记录前一个结点
        for (int i = 1; i<=41;i++ ){
            //如果是第一个结点
            if (i==1){
                first=new Node<>(i,null);
                pre = first;
                continue;
            }
            //如果不是第一个结点
            Node<Integer> newNode = new Node<>(i,null);
            pre.next=newNode;
            pre=newNode;
            //如果是最后一个结点，那么需要让最后一个结点的下一个成为first
            if (i==41){
                pre.next=first;
            }

        }
        //计算器，模仿报数
        int count = 0;
        Node<Integer> n = first;
        Node<Integer> before = null;
        while (n!=n.next){
            count++;
            if (count==3){
                before.next=n.next;
                System.out.print(n.item+",");
                count=0;
                n=n.next;
            }else {
                before=n;
                n=n.next;
            }

        }

        System.out.println(n.item);

    }

    private static class Node<T> {

        T item;

        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }


}
