package object;

import java.util.HashSet;
import java.util.Objects;

public class EqualExample {


    private int x;
    private int y;
    private int z;

    public EqualExample(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

   /*
    hashCode() 返回散列值，而 equals() 是用来判断两个对象是否等价。
    等价的两个对象散列值一定相同，但是散列值相同的两个对象不一定等价。
    */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EqualExample)) return false;
        EqualExample that = (EqualExample) o;
        return x == that.x && y == that.y && z == that.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    public static void main(String args[]){

        EqualExample e1 = new EqualExample(1, 1, 1);
        EqualExample e2 = new EqualExample(1, 1, 1);
        System.out.println(e1==e2);
        System.out.println(e1.equals(e2)); // true
        HashSet<EqualExample> set = new HashSet<>();
        set.add(e1);
        set.add(e2);
        System.out.println(set.size());   // 2

    }

}
