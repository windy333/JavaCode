package tupu;

import java.nio.charset.StandardCharsets;

public class Translate {
    public static void main(String[] args) {

        //byte转化为string
        byte[] byteArray = {65, 66, 67}; // 举例一个 byte 数组
        String str =new String(byteArray,StandardCharsets.UTF_8);
        System.out.println(str); // 输出 ABC


        //将string转化为long（只能转换数字），byte需要先转为string再转long
        String str2 = "321312";
        long number2 =Long.parseLong(str2);
        System.out.println(number2); // 输出 42


        //int强转byte，丢失精度
        int intValue = 300; // 举例一个 int 值
        byte byteValue = (byte) intValue; // 强制转换为 byte
        System.out.println(byteValue); // 输出 44，因为300超出了 byte 类型的范围，所以会取低 8 位的值


        /* 存在两个类，B 继承 A，C 继承 B，我们能将 B 转换为 C 么? 如 C = (C) B；
        可以，向下转型。但是不建议使用，容易出现类型转型异常.*/

       /* 关于string，首先是不可变的，因为设计者认为字符串使用非常频繁，将字符串设置为不可变可以
        允许多个客户端之间共享相同的字符串。其次 Switch 中使用 String 本质是使用字符串的 hash code*/
    }


}
