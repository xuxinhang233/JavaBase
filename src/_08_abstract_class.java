/**
 * @Author: lenovo
 * @Date: 2021/11/1 13:40
 * @Desc: 抽象类的子类实现，与对象创建
 */
public class _08_abstract_class {
    public static abstract class AbstractClassExample {            // 抽象类
        protected int x;                                    // 子类可访问
        private int y;                                      // 类自身可访问

        public abstract void func1();                       // 带有抽象方法的类一定是一个抽象类
                                                            // 但抽象类不一定包含抽象方法

        public void func2() {
            System.out.println("func2");
        }
    }


    public static class AbstractExtendClassExample extends AbstractClassExample {
        @Override
        public void func1() {                               // 重载抽象方法
            System.out.println("func1");
        }
    }

    public abstract static class NoMethodAbstractMethod {       // 没有抽象方法的抽象类
        private int i;
    }

    // 创建对象时，只能创建重载它方法的子类，即使没有抽象方法
    private static NoMethodAbstractMethod noMethodAbstractMethod = new NoMethodAbstractMethod() {
    };


    public static void main(String[] args) {
        AbstractClassExample ac = new AbstractExtendClassExample();
        ac.func1();

        AbstractClassExample ac1 = new AbstractClassExample() {     // 在创建对象的时候，重载方法
            @Override
            public void func1() {
                System.out.println("wodiu");
            }
        };
        ac1.func1();


        noMethodAbstractMethod.i = 6;

//        NoMethodAbstractMethod p = new NoMethodAbstractMethod();
    }
}