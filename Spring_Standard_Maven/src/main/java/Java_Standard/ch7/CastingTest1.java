package Java_Standard.ch7;

public class CastingTest1 {
    public static void main(String[] args) {
        Car car = null;
        Car car2 = new Car();
        FireEngine fe = new FireEngine();
        FireEngine fe2 = null;

        fe.water();
        //car = (Car)fe; 와 같음
        car = fe;
        //car.water(); compile error
        System.out.println(car instanceof FireEngine);
        fe2 = (FireEngine)car;
        fe2.water();
        System.out.println(car2 instanceof FireEngine);
        fe2 = (FireEngine)car2; //runtimeError
        fe2.water();

    }
}

class Car {
    String color;
    int door;

    void drive() {
        System.out.println("drive, Brrrr~");
    }

    void stop() {
        System.out.println("stop!!!");
    }
}

class FireEngine extends Car {
    void water() {
        System.out.println("water!!");
    }
}

class Ambulance extends Car {
    void siren() {
        System.out.println("siren~~");
    }
}
