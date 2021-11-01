/**
 * @Author: lenovo
 * @Date: 2021/11/1 17:45
 * @Desc: 使用拷贝构造函数、拷贝工厂替代 clone()方法来拷贝一个对象
 */
public class _15_CloneConstructor {
    public static class CloneConstructorExample {
        private int[] arr;

        public CloneConstructorExample() {                      // 构造方法
            arr = new int[10];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
            }
        }

        public CloneConstructorExample(CloneConstructorExample original) {      // 拷贝工厂，参数是一个该类的对象，给该对象赋予一个独立的arr
            arr = new int[original.arr.length];
            for (int i = 0; i < original.arr.length; i++) {
                arr[i] = original.arr[i];
            }
        }

        public int get(int index) {
            return arr[index];
        }

        public void set(int index, int value) {
            arr[index] = value;
        }
    }

    public static void main(String[] args) {
        CloneConstructorExample e1 = new CloneConstructorExample();
        CloneConstructorExample e2 = new CloneConstructorExample(e1);
        e1.set(2, 222);
        System.out.println(e2.get(2));          // 2
    }
}