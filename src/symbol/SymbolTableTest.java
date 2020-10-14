package symbol;

public class SymbolTableTest {
    public static void main(String[] args) {
        SymbolTable<Integer, String> st = new SymbolTable<>();
        st.put(1, "张三");
        st.put(3, "李四");
        st.put(5, "王五");
        System.out.println("插入后元素个数:"+st.size());
        st.put(1,"老三");
        System.out.println("替换完后的个数:"+st.size());
        System.out.println("key为3："+st.get(3));
        st.delete(1);
        System.out.println("删除后的个数:"+st.size());

    }
}
