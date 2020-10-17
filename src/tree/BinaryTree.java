package tree;


import linear.Queue;

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

    //获取整个树中的健
    public Queue<Key> preErgodic(){
        Queue<Key> keys = new Queue<>();
        preErgodic(root,keys);
        return keys;
    }

    //获取指定树x的所有健，并放进keys中
    private void preErgodic(Node x,Queue<Key> keys){
        //判空
        if (x==null){
            return;
        }
        //把x结点的key放入keys中
        keys.enqueue(x.key);
        //递归遍历x结点的左子树
        if (x.left!=null){
            preErgodic(x.left,keys);
        }
        //递归遍历x结点的右子树
        if (x.right!=null){
            preErgodic(x.right,keys);
        }
    }

    //中序遍历
    public Queue<Key> midErgodic(){
        Queue<Key> keys = new Queue<>();
        midErgodic(root,keys);
        return keys;
    }

    private void midErgodic(Node x,Queue<Key> keys){
        if (x==null){
            return;
        }
        if (x.left!=null){
            midErgodic(x.left,keys);
        }
        keys.enqueue(x.key);
        if (x.right!=null){
            midErgodic(x.right,keys);
        }
    }

    //后序遍历
    public Queue<Key> afterErgodic(){
        Queue<Key> keys = new Queue<>();
        afterErgodic(root,keys);
        return keys;
    }

    private void afterErgodic(Node x,Queue<Key> keys){
        if (x==null){
            return;
        }
        if (x.left!=null){
            afterErgodic(x.left,keys);
        }
        if (x.right!=null){
            afterErgodic(x.right,keys);
        }
        keys.enqueue(x.key);
    }

    //层序遍历
    public Queue<Key> layerErgodic(){
        //定义两个队列，分别存储树中的健和树中的结点
        Queue<Key> keys = new Queue<Key>();
        Queue<Node> nodes = new Queue<Node>();
        //往队列中放入跟结点
        nodes.enqueue(root);
        while (!nodes.isEmpty()){
            //从队列中弹出一个结点,把key放入keys中
            Node n = nodes.dequeue();
            keys.enqueue(n.key);
            //判断当前结点有无左子结点，有则放入nodes中
            if (n.left!=null){
                nodes.enqueue(n.left);
            }
            //判断当前结点有无右子结点，有则放入nodes中
            if (n.right!=null){
                nodes.enqueue(n.right);
            }
        }
        return keys;
    }

    //获取整个树最大深度
    public int maxDepth(){
        return maxDepth(root);
    }

    //获取指定树最大深度
    private int maxDepth(Node x){
        if (x==null){
            return 0;
        }
        //x的最大深度
        int max = 0;
        //左子树最大深度
        int maxL = 0;
        //右子树最大深度
        int maxR = 0;
        //计算x结点左子树深度
        if (x.left!=null){
            maxL = maxDepth(x.left);
        }
        //计算x结点右子树深度
        if (x.right!=null){
            maxR = maxDepth(x.right);
        }
        //比较左右子树最大深度，取较大者+1
        max = maxL>maxR?maxL+1:maxR+1;
        return max;
    }


}
