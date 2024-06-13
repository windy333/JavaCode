package _5HashMap;

import java.util.HashSet;

public class Test3 {
    public static void main(String[] args) {
        HashSet<User> set = new HashSet<>();
        User user1=new User("311","123");
        User user2=new User("312","123");
        set.add(user1);
        set.add(user2);

        System.out.println(set.contains(user1));
        System.out.println(set.contains(new User("311", "123")));

    }
}
