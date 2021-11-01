/**
 * @Author: lenovo
 * @Date: 2021/11/1 10:04
 * @Desc:
 */
public class _06_funcParameter {
    public static class Dog {
        String name;
        Dog (String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        String getObjectAddress() {
            return super.toString();
        }
    }

    private static void func(Dog dog) {
        System.out.println(dog.getObjectAddress());         // _06_funcParameter$Dog@1b6d3586
        dog = new Dog("B");                           // 改变副本的值，但是值传递导致 dog = A 其实在 func() 外不会改变
                                                            // 但是对 A 指向的对象 new Dog() 会造成真实影响
        System.out.println(dog.getObjectAddress());         // _06_funcParameter$Dog@4554617c
        System.out.println(dog.getName());                  // B
    }

    private static void change(Dog dog) {
        dog.setName("C");
    }

    public static class PassByValueExample {
        public static void main(String[] args) {
            Dog dog = new Dog("A");                   // 创建 Dog 对象，dog是对象引用
            System.out.println(dog.getObjectAddress());     // _06_funcParameter$Dog@1b6d3586
            func(dog);                                      // 进行值传递，拷贝dog副本传入func()中
            System.out.println(dog.getObjectAddress());     // _06_funcParameter$Dog@1b6d3586，退出func()方法，dog变为原来的值
            System.out.println(dog.getName());              // A

            change(dog);
            System.out.println(dog.getObjectAddress());     // _06_funcParameter$Dog@1b6d3586
            System.out.println(dog.getName());              // C
        }
    }
}