/**
 * @Author: lenovo
 * @Date: 2021/11/1 13:28
 * @Desc: 测试一个其他类能够访问类中内部类的默认成员变量访问权限
 */
public class _07_inner_class_authority {
    public static class AccessWithInnerClassExample {
        private class InnerClass {                      // 内部类，拥有一个非 private 的成员变量
            int x;                                      // 同一个包下，可以被访问
        }

        private InnerClass innerClass;                  // 类的私有成员变量

        public AccessWithInnerClassExample() {          // 构造方法
            innerClass = new InnerClass();
        }

        public int getValue() {
            return innerClass.x;                        // 直接访问
        }
    }

    public static void main(String[] args) {
        AccessWithInnerClassExample accessWithInnerClassExample = new AccessWithInnerClassExample();
        AccessWithInnerClassExample.InnerClass innerClass = accessWithInnerClassExample.innerClass;
        innerClass.x = 666;
        System.out.println(accessWithInnerClassExample.innerClass.x);
    }
}