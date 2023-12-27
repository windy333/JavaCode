public class tangle implements shape{
    protected double wide,height;
    public tangle(double wide,double height){
        this.wide=wide;
        this.height=height;
    }
    public double getArea(){
         return wide*height;   
    }
}
