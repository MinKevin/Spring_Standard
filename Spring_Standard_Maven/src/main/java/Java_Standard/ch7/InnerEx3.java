package Java_Standard.ch7;

public class InnerEx3 {
    private int outerIv = 0;
    static int outerCv = 0;

    class InstanceInner {
        //외부 클래스의 private멤버도 접근 가능
        int iiv = outerIv;
        int iiv2 = outerCv;
    }

    void myMethod() {
        int lv = 0; //앞에 컴파일러가 final 삽입 (LocalInner가 있기 때문에)
        final int LV = 0;

        class LocalInner {
            int liv = outerIv;
            int liv2 = outerCv;
            int liv3 = lv;
            int liv4 = LV;
        }
    }
}
