package Java_Standard.ch6;

public class sec5_Constructor {
    static void ConstructorTest() {
        Data1 d1 = new Data1();
//      Data2 d2 = new Data2(); // Error
    }

    static void CarTest() {
        Car c1 = new Car();
        c1.color = "white";
        c1.gearType = "auto";
        c1.door = 4;

        Car c2 = new Car("white", "auto", 4);

        System.out.printf("c1의 color=%s, gearType=%s, door=%d %n", c1.color, c1.gearType, c1.door);
        System.out.printf("c2의 color=%s, gearType=%s, door=%d %n", c2.color, c2.gearType, c2.door);
    }

    static void CarTest2() {
        Car c1 = new Car();
        Car c2 = new Car("blue");

        System.out.printf("c1의 color=%s, gearType=%s, door=%d %n", c1.color, c1.gearType, c1.door);
        System.out.printf("c2의 color=%s, gearType=%s, door=%d %n", c2.color, c2.gearType, c2.door);
    }

    static void CarTest3() {
        Car c1 = new Car();
        Car c2 = new Car(c1);

        System.out.printf("c1의 color=%s, gearType=%s, door=%d %n", c1.color, c1.gearType, c1.door);
        System.out.printf("c2의 color=%s, gearType=%s, door=%d %n", c2.color, c2.gearType, c2.door);

        c1.door = 100;
        System.out.printf("c1의 color=%s, gearType=%s, door=%d %n", c1.color, c1.gearType, c1.door);
        System.out.printf("c2의 color=%s, gearType=%s, door=%d %n", c2.color, c2.gearType, c2.door);
    }

    public static void main(String[] args) {
        CarTest();

        System.out.println();
        CarTest2();

        System.out.println();
        CarTest3();

        System.out.println();
        System.out.println("1. new BlockTest()");
        new BlockTest();
        System.out.println("2. new BlockTest()");
        new BlockTest();

    }
}

class Data1 {
    int value;
}

class Data2 {
    int value;

    Data2(int x) {
        value = x;
    }
}

class Car {
    String color;
    String gearType;
    int door;

    Car() {
        this("white", "auto", 4);
    }

    Car(String color) {
        this(color, "auto", 4);
    }

    Car(Car car) {
        this(car.color, car.gearType, car.door);
    }

    Car(String color, String gearType, int door) {
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }
}

class BlockTest {
    static {
        System.out.println("static initialization block => static {}");
    }

    {
        System.out.println("instance initialization block => {}");
    }

    public BlockTest() {
        System.out.println("Constructor");
    }
}

class StaticBlockTest {
    static int[] arr = new int[10];

    static {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)Math.random() * 10 + 1;
        }
    }
}