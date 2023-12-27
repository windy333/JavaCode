import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        // 创建一个HashMap
        Map<String, Integer> ages = new HashMap<>();

        // 添加键值对
        ages.put("Alice", 25);
        ages.put("Bob", 30);
        ages.put("Charlie", 22);

        // 访问元素
        System.out.println("Alice's age: " + ages.get("Alice"));

        // 删除元素
        ages.remove("Charlie");

        // 遍历映射
        for (Map.Entry<String, Integer> entry : ages.entrySet()) {
            String name = entry.getKey();
            Integer age = entry.getValue();
            System.out.println(name + " is " + age + " years old.");
        }
    }
}
