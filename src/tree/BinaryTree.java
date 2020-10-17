package tree;

public class BinaryTree <Key extends Comparable<Key>,Value>{
    //记录根结点
    private Node root;
    //记录数中元素的个数
    private int N;

    private class Node{
        //存储健
        public Key key;
        //存储值
        private Value value;
        //记录左子结点
        public Node left;
        //记录右子结点
        public Node right;

        public Node(Key key,Value value,Node left,Node right){
            this.key=key;
            this.value=value;
            this.left=left;
            this.right=right;
        }
    }

    //获取数中元素的个数
    public int size(){
        return N;
    }

    //向树中添加元素key-value
    public void put(Key key,Value value){
        root = put(root,key,value);
    }

    //向指定树x中添加元素key-value,并返回添加元素后的树
    public Node put(Node x,Key key,Value value){
        //如果x子树为空
        if (x == null){
            N++;
            return new Node(key,value,null,null);
        }
        //如果不为空
        int cmp = key.compareTo(x.key);
        if (cmp>0){
            x.right = put(x.right, key, value);
        }else if (cmp<0){
            x.left = put(x.left,key,value);
        }else {
            x.value = value;
        }
        return x;
    }

    //查询树中指定key对应的value
    public Value get(Key key){
        return get(root,key);
    }

    //指定树中寻找为key的value
    public Value get(Node x,Key key){
        //如果key为空
        if (x == null){
            return null;
        }
        //如果不为空
        int cmp = key.compareTo(x.key);
        if (cmp>0){
            return get(x.right,key);
        }else if (cmp<0){
            return get(x.left,key);
        }else {
            return x.value;
        }
    }

    //删除树中key对应的value
    public void delete(Key key){
        delete(root,key);
    }

    //删除指定树中的key对应的value，并返回删除后的新树
    public Node delete(Node x,Key key){
        //x树为null
        if (x == null){
            return null;
        }
        //x树不为null
        int cmp = key.compareTo(x.key);
        if (cmp>0){
            x.right = delete(x.right,key);
        }else if (cmp<0){
            x.left = delete(x.left,key);
        }else {
            N--;
            if (x.right == null){
                return x.left;
            }
            if (x.left == null){
                return x.right;
            }
            Node minNode = x.right;
            while (minNode.left!=null){
                minNode = minNode.left;
            }
            //删除右子树中最小结点
            Node n = x.right;
            while (n.left!=null){
                if (n.left.left==null){
                    n.left=null;
                }else {
                    n = n.left;
                }
            }
            //让x结点的左子树成为minNode的左子树
            minNode.left = x.left;
            //让x结点的右子树成为minNode的右子树
            minNode.right = x.right;
            //让x的的父结点指向minNode
            x = minNode;

        }
        return x;
    }

    //找出整个树最小的健
    public Key min(){
        return min(root).key;
    }

    //找出指定树x的最小健所在的结点
    private Node min(Node x){
        if (x.left!=null){
            return min(x.left);
        }else {
            return x;
        }
    }

    //找出整个树最大的健
    public Key max(){
        return max(root).key;
    }

    //找出指定树x的最大健所在的结点
    private Node max(Node x){
        if (x.right!=null){
            return max(x.right);
        }else {
            return x;
        }
    }


}
