/**
 * @Author: lenovo
 * @Date: 2021/11/2 14:37
 * @Desc: 泛型方法
 */
public class _19_GenericsMethod {
    // 一个简单的泛型方法
    public static <T> T add(T x, T y) {
        return y;
    }

    public static void main(String[] args) {
        // 不指定泛型时
        int i = _19_GenericsMethod.add(1,2);       // 这两个参数都为 Integer，所以 T 为 Integer 类型
        Number f = _19_GenericsMethod.add(1, 1.2); // 这两个参数一个是 Integer，一个是Float，所以取同一父类的最小级，为 Number
        Object o = _19_GenericsMethod.add(1, "asd");   // 一个参数Integer，一个是String，取同一父类的最小级，为 Object

        // 指定泛型时
        int a = _19_GenericsMethod.<Integer>add(1, 2);      // 指定了Integer，所以只能为 Integer 类型或其子类型
//        int b = _19_GenericsMethod.<Integer>add(1,2.2);       // 编译错误，不能为 Float
        Number c = _19_GenericsMethod.<Number>add(1,2.2);   // 指定为Number，所以可以为 Integer 和 Float
    }
}