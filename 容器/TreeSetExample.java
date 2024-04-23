import java.util.TreeSet;
import java.util.Set;

public class TreeSetExample {
    public static void main(String[] args) {
        // 创建一个TreeSet
        Set<Integer> numbers = new TreeSet<>();

        // 添加元素
        numbers.add(40);
        numbers.add(10);
        numbers.add(30);
        numbers.add(20);

        // 集合已经被排序
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
