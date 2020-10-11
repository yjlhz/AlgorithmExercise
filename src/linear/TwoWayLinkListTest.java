package linear;

public class TwoWayLinkListTest {
    public static void main(String[] args) {
        //创建顺序表对象
        TwoWayLinkList<String> s1 = new TwoWayLinkList<>();
        //测试插入
        s1.insert("111");
        s1.insert("222");
        s1.insert("333");
        s1.insert("444");
        s1.insert(1,"555");

        for(String s : s1){
            System.out.println(s);
        }

        //测试获取
        String result = s1.get(1);
        System.out.println("测试获取"+result);
        //测试删除
        Object removeTest = s1.remove(0);
        System.out.println("删除的元素"+removeTest);

        System.out.println(s1.length());
        System.out.println("-----------------------");
        System.out.println("第一个元素是"+s1.getFirst());
        System.out.println("最后一个元素"+s1.getLast());
        //测试清空
        s1.clear();
        System.out.println(s1.length());
    }
}
