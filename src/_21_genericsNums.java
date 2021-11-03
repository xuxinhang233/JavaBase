import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: lenovo
 * @Date: 2021/11/2 16:04
 * @Desc: 泛型数组
 */
public class _21_genericsNums {

    public static <T> T[] func1(T...args) {     // 接收可变参数
        return args;                            // 返回泛型数组
    }

    public static <T> void func2(T param[]) {   // 输出
        System.out.println("接收泛型数组: ");
        for (T t : param) {
            System.out.print(t + "、");
        }
    }

    public static void main(String[] args) throws Exception {
        Integer i[] = func1(1, 2, 3, 4, 5, 6);
        func2(i);

        // 证明泛型的类型擦除是存在的
        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list1.add("anc");
        list2.add(1);
        System.out.println(list1.getClass() == list2.getClass());

        // 通过反射添加其他元素
        ArrayList<Integer> list = new ArrayList<Integer>();
        // 这样调用 add 只能存储整形，因为泛型类型的实例 Integer
        list.add(1);
        // 通过反射向 list 中添加本来不能满足 Integer 类型的对象 —— 字符串类型
        // 这说明了 Integer 泛型实例在编译之后被擦除掉了，只保留了原始类型
        list.getClass().getMethod("add", Object.class).invoke(list,"asd");
        for (int i1 = 0; i1 < list.size(); i1++) {
            System.out.println(list.get(i1));
        }

    }
}