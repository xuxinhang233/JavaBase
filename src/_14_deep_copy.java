import java.util.Set;

/**
 * @Author: lenovo
 * @Date: 2021/11/1 17:00
 * @Desc: 深拷贝，拷贝的是对象本身
 */
public class _14_deep_copy {
    public static class DeepCloneExample implements Cloneable {
        private int[] arr;
        private int[] p;

        public DeepCloneExample() {
            arr = new int[10];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
            }

            p = new int[10];
            for (int i = 0; i < p.length; i++) {
                arr[i] = 1;
            }
        }

        public int getP(int index) {
            return p[index];
        }

        public void setP(int index, int value) {
            p[index] = value;
        }

        public void set (int index, int value) {
            arr[index] = value;
        }

        public int get (int index) {
            return arr[index];
        }

        // 深拷贝
        @Override
        protected DeepCloneExample clone() throws CloneNotSupportedException {
            DeepCloneExample res = (DeepCloneExample) super.clone();                // 与浅拷贝相同，都是相同的对象引用
            res.arr = new int[arr.length];                                          // 拷贝时，重开了一片内存分给 arr 对象
            for (int i = 0; i < arr.length; i++) {
                res.arr[i] = arr[i];
            }
            return res;
        }
    }

    public static void main(String[] args) {
        DeepCloneExample e1 = new DeepCloneExample();
        DeepCloneExample e2 = null;
        try {
            e2 = e1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        e1.set(2,222);                               // e1 与 e2 的 arr 两个是独立的对象
        System.out.println(e2.get(2));               // 1

        e1.setP(5,66);                   // e1 与 e2 的 p 仍是同一个对象，所以只有在 Clone() 方法中特意重写的对象才会被深拷贝
        System.out.println(e2.getP(5));        // 66
    }
}
