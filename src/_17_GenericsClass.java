/**
 * @Author: lenovo
 * @Date: 2021/11/2 11:05
 * @Desc: 泛型演示，泛型类
 */
public class _17_GenericsClass {
    private static <T extends Number>double add(T a, T b) {
        System.out.println(a + " + " + b + " = " + (a.doubleValue() + b.doubleValue()));
        return a.doubleValue() + b.doubleValue();
    }

    // 泛型类
    static class Point<T> {            // T 可随便更换为表示符号，是 Type 的简称
        private T var;          // var 的类型由T指定，即由外部传入的参数指定
        public T getVar() {     // 返回值的类型由外部决定
            return var;
        }
        public void setVar(T var) {     // 设置的类型也由外部得到
            this.var = var;
        }
    }

    // 多元泛型类
    static class Notepad<K, V> {        // 此处指定了两个泛型类型
        private K key;                  // 此变量的类型由外部决定
        private V value;

        public K getKey() {
            return key;
        }
        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }
        public void setValue(V value) {
            this.value = value;
        }

    }

    public static void main(String[] args) {
        add(1, 2);
        add(1.0, 3);
        add(4.5f, 1.0);

        Point<String> p = new Point<String>();      // 里面的 var 类型为 String 类型
        p.setVar("it");
        System.out.println(p.getVar().length());

        Notepad<String, Integer> t = null;          // 定义两个泛型类型的对象
        t = new Notepad<String, Integer>();         // 里面的key为String，value为Integer
        t.setKey("Tom");
        t.setValue(20);
        System.out.print("name: " + t.getKey());        // 获取信息
        System.out.print(", age: " + t.getValue());
    }
}