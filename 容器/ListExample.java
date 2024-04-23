import java.util.ArrayList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        // 创建ArrayList
        List<String> fruits = new ArrayList<>();

        // 添加元素
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Date");
        fruits.add("Elderberry");

        // 在指定位置添加元素
        fruits.add(1, "BlueBerry");

        // 删除元素
        fruits.remove("Date"); // 通过对象删除
        //fruits.remove(3); // 通过索引删除

        // 查找元素
        int index = fruits.indexOf("Cherry"); // 查找元素的索引
        boolean containsApple = fruits.contains("Apple"); // 检查是否包含某个元素

        // 改变元素的值
        fruits.set(index, "Cherry Tomato"); // 将"Cherry"更改为"Cherry Tomato"

        // 访问元素
        String fruit = fruits.get(0); // 访问第一个元素

        // 1、遍历ArrayList
        System.out.println("Fruits List:");
        for (String f : fruits) {
            System.out.println(f);
        }

        // 2、使用for循环遍历
        /*
        System.out.println("\nUsing for loop:");
        for (int i = 0; i < fruits.size(); i++) {
            System.out.println(fruits.get(i));
        }
         */


        // 3、使用方法引用遍历
        System.out.println("\nUsing method reference:");
        fruits.forEach(System.out::println);

        // 清空ArrayList
        fruits.clear();

        // 检查ArrayList是否为空
        boolean isEmpty = fruits.isEmpty();

        System.out.println("\nIs the fruits list empty? \n" + isEmpty);
    }
}
