import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        // 创建一个HashSet
        Set<String> cities = new HashSet<>();

        // 添加元素
        cities.add("New York");
        cities.add("London");
        cities.add("Paris");
        cities.add("New York"); // 重复元素不会被添加

        // 检查元素是否存在
        if (cities.contains("London")) {
            System.out.println("London is in the set.");
        }

        // 遍历集合
        for (String city : cities) {
            System.out.println(city);
        }
    }
}
