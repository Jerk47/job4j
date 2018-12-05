package strategy;

public class Paint {
    private Shape shape;

    public Paint(Shape shape) {
        this.shape = shape;
    }

    public String executeShape() {
        return shape.draw();
    }
}