package Template;

class Point<T>{
    private T var;
    public T getVar() {
        return var;
    }
     public void setVar(T var){
            this.var=var;
     }
}

public class GenericsDemo06{
    public static void main(String[] args) {
        Point<String> point =new Point<String>();
        point.setVar("her");
        System.out.println(point.getVar().length());
    }

}


