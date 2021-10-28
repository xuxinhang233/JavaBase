/**
 * @Author: lenovo
 * @Date:   2021/10/28 10:30
 * @Desc:   描述封装及其优点
 */
public class _01_encapsulation {
    public class person {
        // Person 类下封装的 三个属性
        private String name;
        private int gender;     // gender 属性使用 int 数据类型进行存储，封装使得用户注意不到这种实现细节
        private int age;

        public String getName() {
            return name;
        }

        public String getGender() {
            return gender == 0 ? "male" : "female";
        }

        // 外界无法获取 age 属性，但 age 属性可以供 work() 方法使用
        public void work() {
            if (age >= 18 && age <= 50) {
                System.out.println(name + " is working very hard!");
            } else {
                System.out.println(name + " can't work any more!");
            }
        }
    }
}