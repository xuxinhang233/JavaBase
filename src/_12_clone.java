/**
 * @Author: lenovo
 * @Date: 2021/11/1 16:30
 * @Desc: 显式的重写 clone() 这个 protect 方法的类，才能被其他类调用该类实例的 clone() 方法.
 *        继承 Cloneable 接口，如果一个类没有实现 Cloneable 接口又调用了 clone() 方法，就会抛出 CloneNotSupportedException。
 */
public class _12_clone {
    public static class CloneExample implements Cloneable{
        private int a;
        private int b;

        @Override
        protected CloneExample clone() throws CloneNotSupportedException {
            return (CloneExample)super.clone();
        }

    }

    public static void main(String[] args) {

        CloneExample e1 = new CloneExample();
        // 抛出 java.lang.CloneNotSupportedException，这是因为 CloneExample 没有实现 Cloneable 接口
        // implements Cloneable 就可以
        try {
            CloneExample e2 = e1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}