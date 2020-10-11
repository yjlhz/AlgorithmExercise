package linear;

public class LinkListTest2 {
    public static void main(String[] args) {
        //创建顺序表对象
        LinkList<String> s1 = new LinkList<>();
        //测试插入
        s1.insert("111");
        s1.insert("222");
        s1.insert("333");
        s1.insert("444");

        for(String s : s1){
            System.out.println(s);
        }

        System.out.println("-----------------------------");
        s1.reverse();


        for(String s : s1){
            System.out.println(s);
        }

    }
}
