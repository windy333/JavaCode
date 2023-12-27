import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
在这个例子中，我们首先创建了一个字符串列表 words。然后通过调用 stream()
方法在这个列表上创建一个流。接着使用 map() 方法应用 String::toUpperCase
方法到流中的每一个元素，将它们转换为大写。最后，我们使用 collect() 方法
将结果收集到一个新的列表中。
*/

public class pipOutput {
    //管道流demo
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hello", "world", "java", "stream");

        List<String> upperCaseWords = words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(upperCaseWords);
        // 输出: [HELLO, WORLD, JAVA, STREAM]
    }
}