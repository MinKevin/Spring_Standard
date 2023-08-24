package Java_Standard.ch7;

public class InterfaceTest {
    public static void main(String[] args) {
        InterfaceTest it = new InterfaceTest();
        A a = it.new A();
        a.methodA(it.new B());
    }

    interface I {
        public abstract void methodB();
    }
    class A {
        public void methodA(I i) {
            i.methodB();
        }
    }

    class B implements I {
        public void methodB() {
            System.out.println("methodB");
        }
    }
}
