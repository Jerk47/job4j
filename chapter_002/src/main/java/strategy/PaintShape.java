package strategy;

public class PaintShape {
    public static void main(String[] args) {
        Paint paintTriangle = new Paint(new Triangle());
        Paint paintSquare = new Paint(new Square());
        System.out.println(paintTriangle.executeShape());
        System.out.println(paintSquare.executeShape());
    }
}
