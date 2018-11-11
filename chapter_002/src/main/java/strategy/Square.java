package strategy;

public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder sb = new StringBuilder();
        sb.append("+ + + +\n");
        sb.append("+     +\n");
        sb.append("+     +\n");
        sb.append("+ + + +\n");
        return sb.toString();
    }
}
