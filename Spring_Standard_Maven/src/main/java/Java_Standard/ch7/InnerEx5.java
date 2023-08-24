package Java_Standard.ch7;

public class InnerEx5 {
    public static void main(String[] args) {
        Outer3 outer = new Outer3();
        Outer3.Inner inner = outer.new Inner();
        inner.method1();
    }
}

class Outer3 {
    //Outer.this.value
    int value = 10;

    class Inner {
        // this.value
        int value = 20;

        void method1() {
            int value = 30;
            System.out.println("value = " + value);
            System.out.println("this.value = " + this.value);
            System.out.println("Outer3.this.value = " + Outer3.this.value);
        }
    }
}