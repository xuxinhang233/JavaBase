/**
 * @Author: lenovo
 * @Date: 2021/10/28 12:55
 * @Desc: 测试包装类型两种方式的区别：
 *          new Integer 每次新建一个对象
 *          Integer.valueOf() 如果int值在 [-128, 127] 中，会直接从缓冲池拿对象（引用类型指向同一个对象）而不用新建对象
 */
public class _03_bufferPool {
    public static void main(String[] args) {
        Integer x = 123;
        Integer y = 123;
        System.out.println(x == y);     // true

        Integer m = Integer.valueOf(6);
        Integer n = Integer.valueOf(6);
        System.out.println(m == n);     // true

        Integer a = new Integer(7);
        Integer b = new Integer(7);
        System.out.println(a == b);     // false

        Integer p = Integer.valueOf(666);
        Integer q = Integer.valueOf(666);
        System.out.println(p == q);     // false
    }
}