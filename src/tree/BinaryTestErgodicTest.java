package tree;

import linear.Queue;

public class BinaryTestErgodicTest {

//    public static void main(String[] args) throws Exception {
//        BinaryTree<String, String> bt = new BinaryTree<>();
//        bt.put("E", "5");
//        bt.put("B", "2");
//        bt.put("G", "7");
//        bt.put("A", "1");
//        bt.put("D", "4");
//        bt.put("F", "6");
//        bt.put("H", "8");
//        bt.put("C", "3");
//        Queue<String> queue = bt.preErgodic();
//        for (String key : queue) {
//            System.out.println(key+"="+bt.get(key));
//        }
//    }

//    public static void main(String[] args) throws Exception {
//        BinaryTree<String, String> bt = new BinaryTree<>();
//        bt.put("E", "5");
//        bt.put("B", "2");
//        bt.put("G", "7");
//        bt.put("A", "1");
//        bt.put("D", "4");
//        bt.put("F", "6");
//        bt.put("H", "8");
//        bt.put("C", "3");
//        Queue<String> queue = bt.midErgodic();
//        for (String key : queue) {
//            System.out.println(key+"="+bt.get(key));
//        }
//    }

//    public static void main(String[] args) throws Exception {
//        BinaryTree<String, String> bt = new BinaryTree<>();
//        bt.put("E", "5");
//        bt.put("B", "2");
//        bt.put("G", "7");
//        bt.put("A", "1");
//        bt.put("D", "4");
//        bt.put("F", "6");
//        bt.put("H", "8");
//        bt.put("C", "3");
//        Queue<String> queue = bt.afterErgodic();
//        for (String key : queue) {
//            System.out.println(key+"="+bt.get(key));
//        }
//    }

    public static void main(String[] args) throws Exception {
        BinaryTree<String, String> bt = new BinaryTree<>();
        bt.put("E", "5");
        bt.put("B", "2");
        bt.put("G", "7");
        bt.put("A", "1");
        bt.put("D", "4");
        bt.put("F", "6");
        bt.put("H", "8");
        bt.put("C", "3");
        Queue<String> queue = bt.layerErgodic();
        for (String key : queue) {
            System.out.println(key+"="+bt.get(key));
        }
    }

}
