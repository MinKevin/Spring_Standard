package Java_Standard.ch7;

public class InterfaceTest3 {
    public static void main(String[] args) {
        A a = new A();
        a.methodA();
    }

    static class A {
        void methodA() {
            I i = InstanceManager.getInstance();
            i.methodB();
            //i로 Object 클래스의 메서드 호출 가능
            System.out.println(i.toString());
        }
    }

    interface I {
        public abstract void methodB();
    }

    static class B implements I {
        public void methodB() {
            System.out.println("methodB in B class");
        }

        public String toString() {
            return "class B";
        }
    }

    static class InstanceManager {
        public static I getInstance() {
            return new B();
        }
    }
}
