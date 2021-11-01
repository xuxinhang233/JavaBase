import com.sun.xml.internal.ws.api.streaming.XMLStreamWriterFactory;

/**
 * @Author: lenovo
 * @Date: 2021/11/1 14:06
 * @Desc: 接口的成员类型，与接口的实现
 */
public class _09_interface {
    public interface InterfaceExample {
        void func1();

        default void func2() {                  // 接口中，支持默认实现的方法
            System.out.println("func2");
        }

        void fun4();

        int x = 123;
//        int y;                            // Variable 'y' might not have been initialized
        public int z = 0;                   // Modifier 'public' is redundant for interface field
        static final int p = 1;
//        private int k = 0;                // Modifier 'private' not allowed here
//        protected int l = 0;              // Modifier 'protected' not allowed here
//        private void func3();             // Modifier 'private' not allowed here
    }

    private static class InterfaceImplementExample implements InterfaceExample {
        @Override
        public void func1() {
            System.out.println("func1");
        }

        public void fun4(){};           // 实现接口时，必须实现接口所有的抽象方法
    }

    public static void main(String[] args) {
        InterfaceExample ie2 = new InterfaceImplementExample();
        ie2.func1();
        System.out.println(InterfaceExample.x);
        System.out.println(InterfaceExample.z);
    }
}