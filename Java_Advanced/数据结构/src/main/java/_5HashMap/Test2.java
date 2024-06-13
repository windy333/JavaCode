package _5HashMap;

import java.util.HashMap;

public class Test2 {
    public static void main(String[] args) {
        HashMap<User,String> map = new HashMap<>();
        User user1=new User("alice","123456");
        User user2=new User("311","123456");

        map.put(user1,"管理员");
        map.put(user2,"员工");

        System.out.println(map.get(user1));
        System.out.println(map.get(user2));
        System.out.println(map.keySet());

    }
}
