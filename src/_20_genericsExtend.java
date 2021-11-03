/**
 * @Author: lenovo
 * @Date: 2021/11/2 15:21
 * @Desc: 泛型的上下限
 */
public class _20_genericsExtend {
    static class Info<T extends Number> {      // 此处的泛型 T 只能是 Number 或其子类，即数字类型，给出上限
        private T var;                  // 定义泛型变量
        public void setVar(T var) {
            this.var = var;
        }
        public T getVar() {
            return this.var;
        }
        public String toString() {      // 直接打印
            return this.var.toString();
        }
    }

    static class Info1<T> {
        private T var;                  // 定义泛型变量
        public void setVar(T var) {
            this.var = var;
        }
        public T getVar() {
            return this.var;
        }
        public String toString() {      // 直接打印
            return this.var.toString();
        }
    }

    // 只能接收到 String 或 Object 类型的泛型，String类的父类只有Object类
    public static void fun(Info1<? super String> temp) {
        System.out.println(temp + ", ");
    }

    public static void main(String[] args) {
        Info<Integer> i1 = new Info<Integer>();     // 声明 Integer 的泛型对象
        System.out.println(i1.getVar());

        Info1<String> i2 = new Info1<String>();     // 声明 String 类型的对象
        Info1<Object> i3 = new Info1<Object>();     // 声明 Object 类型的对象
        i2.setVar("hello");
        i3.setVar(new Object());
        fun(i2);
        fun(i3);
    }
}