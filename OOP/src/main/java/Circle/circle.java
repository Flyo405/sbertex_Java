package Circle;

class Main {
    public static void main(String[] args) {
        circle circle1 = new circle(7, "blue");
        circle circle2 = new circle(11, "yellow");

        System.out.println("S1 = " + circle1.area());
        System.out.println("P2 = " + circle2.perimeter());

        System.out.println("1 figure: \n" + circle1.toString());
        System.out.println("2 figure: \n" + circle2.toString());
    }
}



public class circle {
    private int radius;
    private String color;

    public circle(int radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    public String toString() {
        return "Circle {" +
                "radius: " + radius +
                " color: " + color +
                " area: " + area() +
                ", perimeter: " + perimeter() +
                '}';
    }
}
