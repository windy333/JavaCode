package object;

//非静态内部类依赖于外部类的实例，而静态内部类不需要。

public class OuterClass {

    class InnerClass {
    }

    static class StaticInnerClass {
    }


    public static void main(String[] args) {
        // InnerClass innerClass = new InnerClass(); // 'OuterClass.this' cannot be referenced from a static context
        OuterClass outerClass = new OuterClass();
        InnerClass innerClass = outerClass.new InnerClass();
        StaticInnerClass staticInnerClass = new StaticInnerClass();
    }
}
