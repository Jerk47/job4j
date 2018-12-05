package strategy;

public class PaintShape {
    public static void main(String[] args) {
        Paint paintTriangle = new Paint();
        Paint paintSquare = new Paint();
        new Paint().draw(new Triangle());
        new Paint().draw(new Square());

    }
}
