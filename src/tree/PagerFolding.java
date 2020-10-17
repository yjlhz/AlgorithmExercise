package tree;

import linear.Queue;

public class PagerFolding {
    public static void main(String[] args) {

        //模拟折纸过程，产生树
        Node<String> tree = createTree(3);
        //遍历树，打印每个结点
        printTree(tree);

    }

    /**
     * 模拟对折N次纸，产生树
     * @param N
     * @return
     */
    public static Node createTree(int N){
        Node<String> root = null;
        for (int i = 0; i < N; i++) {
            //当前是第一次对折
            if (i==0){
                root = new Node<>("down",null,null);
                continue;
            }
            //当前不是第一次对折
            //定义一个辅助队列，通过层序遍历，给叶子结点添加子结点
            Queue<Node> queue = new Queue<>();
            queue.enqueue(root);
            //循环遍历队列
            while (!queue.isEmpty()){
                //从队列中弹出结点
                Node<String> tmp = queue.dequeue();
                //如果有左子结点，则把左子结点放入队列中
                if (tmp.left!=null){
                    queue.enqueue(tmp.left);
                }
                //如果有右子结点，则把右子结点放入队列中
                if (tmp.right!=null){
                    queue.enqueue(tmp.right);
                }
                //如果同时没有左子结点和右子结点，则证明是叶子结点，则添加左右子树
                if (tmp.left==null && tmp.right==null){
                    tmp.left = new Node<String>("down",null,null);
                    tmp.right = new Node<String>("up",null,null);
                }

            }
        }
        return root;
    }

    //打印树
    public static void printTree(Node<String> root){
        //使用中序遍历
        if (root==null){
            return;
        }
        if (root.left!=null){
            printTree(root.left);
        }
        System.out.print(root.item+" ");
        if (root.right!=null){
            printTree(root.right);
        }

    }

    /**
     * 结点类
     * @param <T>
     */
    public static class Node<T>{
        public T item;
        public Node left;
        public Node right;

        public Node(T item, Node left, Node right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }

}
