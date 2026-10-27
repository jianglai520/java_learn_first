import www.horsefly.Triangle;
import java.util.Date;

public class flyhorse {
    public static void main(String args[]) {
        Triangle triangle = new Triangle(12, 3, 104);
        triangle.jsmj();
        triangle.set(3, 4, 5);
        triangle.jsmj();
        Date 今天 = new Date();
        System.out.println("今天是:" + 今天);
    }
}
