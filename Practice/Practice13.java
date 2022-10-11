package Practice;

public class Practice13 {
	 
    public static void main(String[] args) {
        Shape donut = new Circle(10);
        donut.redraw();
        System.out.println("면적은 "+ donut.getArea());
 
    }
 
}
 
class Circle implements Shape{
    private int r;
    
    public Circle(int r) {
        this.r = r;
    }
    @Override
    public void draw() {
        System.out.println(" 반지름이 "+ r+"인 원입니다.");
        
    }
 
    @Override
    public double getArea() {
        
        return r*r*PI;
    }
    
}
 
interface Shape{
    final double PI = 3.14;
    void draw();
    double getArea();
    
    default public void redraw() {
        System.out.print("--- 다시 그립니다.");
        draw();
    }
}
