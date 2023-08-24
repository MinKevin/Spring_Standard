package Java_Standard.ch7;

class BindingTest {
    public static void main(String[] args) {
        BindingTest bt = new BindingTest();
        Parent p = bt.new Child();
        Child c = bt.new Child();

        System.out.println("p.x = " + p.x);
        p.method();
        System.out.println("c.x = " + c.x);
        c.method();
    }

    class Parent {
        int x = 100;
        void method() {
            System.out.println("Parent Method");
        }
    }

    class Child extends Parent {
        int x = 200;

        void method(){
            System.out.println("Child Method");
        }
    }
}
