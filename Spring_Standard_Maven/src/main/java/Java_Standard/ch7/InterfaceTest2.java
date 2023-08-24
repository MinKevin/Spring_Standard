package Java_Standard.ch7;

public class InterfaceTest2 {
    public static void main(String[] args) {
        InterfaceTest2 it2 = new InterfaceTest2();
        A a = it2.new A();
        a.autoPlay(it2.new B());
        a.autoPlay(it2.new C());
    }

    class A {
        void autoPlay(I i) {
            i.play();
        }
    }

    interface I {
        public abstract void play();
    }

    class B implements I {
        public void play(){
            System.out.println("play in B class");
        }
    }

    class C implements I {
        public void play(){
            System.out.println("play in C class");
        }
    }
}
