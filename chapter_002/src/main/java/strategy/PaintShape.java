package strategy;

public class PaintShape {
    public static void main(String[] args) {
        Paint paint = new Paint(new Triangle());
        System.out.println(paint.executeStrategy());
    }
}
