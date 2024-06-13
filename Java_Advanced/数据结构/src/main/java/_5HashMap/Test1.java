package _5HashMap;

import java.util.HashMap;

public class Test1 {
    public static void main(String[] args) {
        HashMap<String,Integer> map1 = new HashMap<>();
        map1.put("one", 1001);
        map1.put("two", 1002);
        map1.put("three", 1003);

        // 通过键获取值
        System.out.println("The value for 'one' is " + map1.get("one"));

        // 检查 HashMap 中是否包含某个键
        System.out.println("Does the map contain 'two'? " + map1.containsKey("two"));

        // 获取 HashMap 中的所有键和值
        System.out.println("All keys in the map: " + map1.keySet());
        System.out.println("All values in the map: " + map1.values());


        map1.remove("two");
        System.out.println(map1);

        for(String key: map1.keySet()){
            System.out.println("Key: " + key + " Value: " + map1.get(key));
        }


    }
}
