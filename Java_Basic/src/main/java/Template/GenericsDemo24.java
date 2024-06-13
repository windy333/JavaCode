package Template;

//简单的泛型接口
interface Info<T>{
    public T getVar();
}

class InfoImpl<T> implements Info<T>{
    private T var;

    public InfoImpl(T var) {
        this.var = var;
    }

    public void setVar(T var) {
        this.var = var;
    }

    @Override
    public T getVar() {
        return this.var;
    }
}

public class GenericsDemo24{  
    public static void main(String arsg[]){  
        InfoImpl<String> info=new InfoImpl<String>("TOM");
        System.out.println(info.getVar());
    }  
}  
