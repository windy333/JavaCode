package object;

public class CloneExample implements Cloneable {
   /* clone() 方法并不是 Cloneable 接口的方法，而是 Object 的一个 protected 方法。
    Cloneable 接口只是规定，如果一个类没有实现 Cloneable 接口又调用了 clone() 方法，
    就会抛出 CloneNotSupportedException。

     这里还会区分深拷贝和浅拷贝：
     浅拷贝：拷贝对象和原始对象的引用类型引用同一个对象。
     深拷贝：拷贝对象和原始对象的引用类型引用不同对象。
*/

    private int a;
    private int b;

    public CloneExample(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    public static void main(String[] at) {
        CloneExample e1 = new CloneExample(1, 1);
        CloneExample e2 = null;
        CloneExample e3 = e1;
        try {
            e2 = (CloneExample) e1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);
    }
}