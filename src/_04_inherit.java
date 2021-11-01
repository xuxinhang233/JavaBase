/**
 * @Author: lenovo
 * @Date: 2021/10/28 13:43
 * @Desc: 测试类之间的继承关系
 */
public class _04_inherit {

    public static class Animal {
        private int age;
        private int height;

        public void run() {
            System.out.println("Animal run...");
        }

        final public void eat() {              // 该方法不可被更改，但可以被继承
            System.out.println("Animal eat...");
        }

        private void walk() {                  // 该方法不可被继承
            System.out.println("Animal walk...");
        }


    }

    public static class Cat extends Animal {
        @Override
        public void run(){
            System.out.println("Cat run...");
        }
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.run();          // Cat run...
        cat.eat();          // Animal eat...
//        cat.walk();     // private，不可用
    }
}