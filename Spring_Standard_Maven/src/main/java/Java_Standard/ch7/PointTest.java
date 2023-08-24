package Java_Standard.ch7;

public class PointTest {
    public static void main(String[] args) {
        Point3D p3 = new PointTest().new Point3D(1, 2, 3);
        System.out.println("p3.x = " + p3.x);
        System.out.println("p3.y = " + p3.y);
        System.out.println("p3.z = " + p3.z);
    }

    class Point {
        int x, y;

        Point(int x, int y) {
            // 생성자 첫 줄에 다른 생성자를 호출하지 않았으므로,
            // 컴파일러가 삽입 (Object()를 의미)
            super();
            this.x = x;
            this.y = y;
        }

        String getLocation() {
            return "x : " + x + ", y : " + y;
        }
    }

    class Point3D extends Point {
        int z;

        Point3D() {
            this(100, 200, 300);
        }
        Point3D(int x, int y, int z) {
            super(x, y);
            this.z = z;
        }

        String getLocation() {
            return "x : " + x + ", y : " + y + ", z : " + z;
        }
    }
}


