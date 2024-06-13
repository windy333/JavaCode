package Template;

class NotePad<K,V>{
    private K key;
    private V value;

    public K getKey() {
        return key;
    }
    public void setKey(K key) {
        this.key = key;
    }
    public void setValue(V value) {
        this.value = value;
    }
    public V getValue() {
        return value;
    }

}

public class GenericsDemo09{  
    public static void main(String args[]){
        NotePad<String,Integer> t=new NotePad<String, Integer>();
        //NotePad<String,Integer> t =null; // 定义两个泛型类型的对象
        //t=new NotePad<String, Integer>(); // 里面的key为String，value为Integer
        t.setKey("TOM");
        t.setValue(20);
        System.out.println("name: "+t.getKey());
        System.out.println("age: "+t.getValue());
    }  
}
