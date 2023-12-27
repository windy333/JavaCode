public class Test {
    public static void main(String args[]){
        shape shape[]=new shape[10];
        double totol_area=0.0;
        int k=0;
        for(int i=0;i<shape.length;i++){
            k=(int)Math.ceil(Math.random()*3);
            System.out.println("k is "+k);
            switch(k){
            case 1:shape[i]=new circle(Math.random());break;
            case 2:shape[i]=new tangle(Math.random(), Math.random());break;
            case 3:shape[i]=new square(Math.random());break;
        }
        }
        
        for(int i=0;i<shape.length;i++){
            totol_area+=shape[i].getArea();
        }
        
        System.out.println(totol_area);



    }
}
