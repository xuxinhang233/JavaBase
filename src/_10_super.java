import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * @Author: lenovo
 * @Date: 2021/11/1 14:51
 * @Desc: 子类使用super访问父类的成员
 */
public class _10_super {
    static public class SuperExample {
        protected int x ;       // protected关键字，表示子类可见
        protected int y ;

        // 构造方法
        public SuperExample(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void func() {
            System.out.println("SuperExample.func()");
        }
    }

    public static class SuperExtendExample extends SuperExample {      // 子类
        private int z;
        public SuperExtendExample(int x, int y, int z) {
            super(x, y);
            this.z = z;
        }

        @Override
        public void func() {
            super.func();
            System.out.println("SuperExtendExample.func()");
            System.out.println(super.x);
        }
    }

    public static void main(String[] args) {
        SuperExample e = new SuperExtendExample(1,2,3);
        e.func();           // SuperExample.func()
                            // SuperExtendExample.func()

    }
}