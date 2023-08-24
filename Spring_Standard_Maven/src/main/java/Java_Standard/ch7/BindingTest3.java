package Java_Standard.ch7;

import javax.naming.Binding;

public class BindingTest3 {
    public static void main(String[] args) {
        BindingTest3 bt3 = new BindingTest3();
        Parent p = bt3.new Child();
        Child c = bt3.new Child();

        System.out.println("p.x = " + p.x);
        p.method();

        System.out.println();
        System.out.println("c.x = " + c.x);
        c.method();
        System.out.println();
        c.pMethod();
    }

    class Parent {
        int x = 100;
        void method() {
            System.out.println("Parent Method");
        }

        void pMethod() {
            System.out.println("x = " + x);
            System.out.println("this.x = " + this.x);
        }
    }

    class Child extends Parent {
        int x = 200;

        void method() {
            System.out.println("x = " + x);
            System.out.println("this.x = " + this.x);
            System.out.println("super.x = " + super.x);
        }
    }
}


