package Java_Standard.ch7;

class SingletonTest {
    public static void main(String[] args) {
        //SingleTon s = new SingleTon();
        Singleton s = Singleton.getInstance();
    }
}

final class Singleton {
    private static Singleton s = new Singleton();
    private Singleton(){

    }

    public static Singleton getInstance() {
        if (s == null)
            s = new Singleton();
        return s;
    }
}
