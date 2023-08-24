package Java_Standard.ch7;

public class InnerEx1 {
    public static void main(String[] args) {
        System.out.println(InstanceInner.CONST);
        System.out.println(StaticInner.cv);
    }
    class InstanceInner {
        int iv = 100;
        // error! static 변수를 선언할 수 없다.
        // static int cv = 100;

        //final static 은 상수이므로 허용
        final static int CONST = 100;
    }

    static class StaticInner {
        int iv = 200;
        static int cv = 200;
    }

    void myMethod() {
        class LocalInner {
            int iv = 300;
            //error! static 변수 선언 불가
            //static int cv = 300;
            final static int CONST = 300;
        }
    }
}
