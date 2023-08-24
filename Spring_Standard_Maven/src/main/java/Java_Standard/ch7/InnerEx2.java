package Java_Standard.ch7;

public class InnerEx2 {
    public static void main(String[] args) {

    }

    class InstanceInner {}
    static class StaticInner {}

    //인스턴스 멤버 간에는 서로 직접 접근이 가능
    InstanceInner iv = new InstanceInner();

    //static 멤버 간에는 서로 직접 접근이 가능
    static StaticInner cv = new StaticInner();
    StaticInner cv2 = new StaticInner();

    static void staticMethod() {
        //static 멤버는 인스턴스 멤버에 직접 접근할 수 없다.
//        InstanceInner obj1 = new InstanceInner();
        StaticInner obj2 = new StaticInner();

        //굳이 접근하려면 아래와 같이 객체를 생성
        InnerEx2 outer = new InnerEx2();
        InstanceInner obj1 = outer.new InstanceInner();
    }

    void instanceMethod() {
        //인스턴스메서드에서는 인스턴스 멤버와 static멤버 모두 접근 가능
        InstanceInner obj1 = new InstanceInner();
        StaticInner obj2 = new StaticInner();

        //메서드 내에 지역적으로 선언ㄷ뇐 내부 클래스는 외부에서 접근할 수 없다.
//        LocalInner lv = new LocalInner();
    }

    void myMethod() {
        class LocalInner {}
        LocalInner lv = new LocalInner();
    }
}
