/**
 * @Author: lenovo
 * @Date: 2021/11/1 16:47
 * @Desc: 浅拷贝，拷贝是对象的引用
 */
public class _13_shallow_copy {
    public static class ShallowCloneExample implements Cloneable {
        private int[] arr;                  // 数组对象
        private int x = 3;

        public ShallowCloneExample() {
            arr = new int[10];                              // 初始化
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
            }
        }

        public void set (int index, int value) {            // 改
            arr[index] = value;
        }

        public int get (int index) {                        // 查
            return arr[index];
        }

        @Override
        protected ShallowCloneExample clone() throws CloneNotSupportedException {
            return (ShallowCloneExample) super.clone();
        }
    }

    public static void main(String[] args) {
        ShallowCloneExample e1 = new ShallowCloneExample();
        ShallowCloneExample e2 = null;
        try {
            e2 = e1.clone();                                // 浅拷贝，e1、e2 是具有相同值的对象引用，均指向数组 arr 的起始位置
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        e1.set(2, 222);
        System.out.println(e2.get(2));                      // 222

        System.out.println(e1.x);                           // 3
        e2.x = 5;
        System.out.println(e1.x);                           // 3
        System.out.println(e2.x);                           // 5
    }
}