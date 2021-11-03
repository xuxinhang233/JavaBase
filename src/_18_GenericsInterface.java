/**
 * @Author: lenovo
 * @Date: 2021/11/2 14:27
 * @Desc: 泛型接口
 */
public class _18_GenericsInterface {
    interface Info<T> {                 // 在接口上定义泛型
        public T getVar();              // 定义抽象方法，抽象方法的返回值就是泛型类型
    }

    static class InfoImpl<T> implements Info<T> {      // 定义泛型接口的子类
        private T var;
        public InfoImpl(T var) {                // 通过构造方法设置属性内容
            this.setVar(var);
        }

        private void setVar(T var) {
            this.var = var;
        }

        public T getVar() {
            return null;
        }
    }

    public static void main(String[] args) {
        Info<String> i = null;                          // 声明接口对象
        i = new InfoImpl<String>("Tom");            // 通过子类实例化对象
        System.out.println("content: " + i.getVar());
    }
 }