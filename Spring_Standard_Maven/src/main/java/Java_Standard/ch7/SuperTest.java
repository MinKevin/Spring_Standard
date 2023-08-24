package Java_Standard.ch7;

public class SuperTest {
    class Parent {
        int x = 10;

        void method(){
            System.out.println("parentMethod");
        }
    }

    class Child extends Parent {
        int x = 20;
        void method() {
            super.method();
            int x = 30;
            System.out.println("x = " + x);
            System.out.println("this.x = " + this.x);
            System.out.println("super.x = " + super.x);
        }
    }
    public static void main(String[] args) {
        SuperTest superTest = new SuperTest();
        Child c = superTest.new Child();
        c.method();
    }
}

