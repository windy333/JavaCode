public class circle implements shape {
    protected double radius;
    circle(double radius){
        this.radius=radius;
    }
    public double getArea(){
        return Math.PI*radius*radius;
    }
}
