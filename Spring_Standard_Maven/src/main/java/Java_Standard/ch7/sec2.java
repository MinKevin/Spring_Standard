package Java_Standard.ch7;

public class sec2 {
}

class Parent {
    void parentMethod() {}
}

class Child extends Parent {
    void parentMethod() {} // 오버라이딩
    void parentMethod(int i) {} // 오버로딩

    void childMethod() {}
    void childMethod(int i) {} // 오버로딩
}
