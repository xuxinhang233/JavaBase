/**
 * @Author: lenovo
 * @Date: 2021/10/28 14:34
 * @Desc:
 */
public class _05_intern_method {
    public static void main(String[] args) {
        String s1 = new String("aaa");
        String s2 = new String("aaa");
        System.out.println(s1 == s2);               // false

        String s3 = s1.intern();
        System.out.println(s1.intern() == s3);      // true
    }

}