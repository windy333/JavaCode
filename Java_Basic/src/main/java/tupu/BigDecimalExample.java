package tupu;

import java.math.BigDecimal;
/*在处理价格等需要精确计算的场景中，使用double可能会导致精度丢失和舍入误差。
这是因为double是基于二进制浮点数表示的，无法精确表示某些十进制小数，例如0.1。
BigDecimal类提供了精确的十进制数学运算，可以避免由于浮点数表示误差而导致的计
算错误。BigDecimal可以表示任意精度的十进制数，不会丢失精度，也可以控制舍入方式，
确保计算结果的准确性。
*/
public class BigDecimalExample {
    public static void main(String a[]){
        BigDecimal price1 =new BigDecimal("10.99");
        BigDecimal price2 =new BigDecimal("3.09");
        BigDecimal total = price1.add(price2);
        BigDecimal total2 =price1.subtract(price2);
        System.out.println(total);
        System.out.println(total2);
    }
}
