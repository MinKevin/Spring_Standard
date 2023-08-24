package Java_Standard.ch6;

import org.springframework.web.bind.annotation.RequestMapping;

public class sec3 {
    static void CardTest() {
        // 클래스 변수는 객체 생성 없이 '클래스이름.클래스변수'로 직접 사용 가능
        System.out.println("Card width = " + Card.width);
        System.out.println("Card height = " + Card.height);

        // 참조변수와 인스턴스 생성 이후,
        Card c1 = new Card();
        c1.kind = "heart";
        c1.number = 7;

        Card c2 = new Card();
        c2.kind = "Spade";
        c2.number = 4;

        System.out.printf("c1 is %s, %d and size is width = %d, height = %d %n",
                c1.kind, c1.number, c1.width, c1.height);
        System.out.printf("c2 is %s, %d and size is width = %d, height = %d %n",
                c2.kind, c2.number, c2.width, c2.height);

        c1.width = 50;
        Card.height = 80;
        System.out.printf("c1 is %s, %d and size is width = %d, height = %d %n",
                c1.kind, c1.number, c1.width, c1.height);
        System.out.printf("c2 is %s, %d and size is width = %d, height = %d %n",
                c2.kind, c2.number, c2.width, c2.height);
    }

    static void MyMathTest(){
        MyMath mm = new MyMath();
        long result1 = mm.add(5, 3);
        long result2 = mm.subtract(5L, 3L);
        long result3 = mm.multiply(5L, 3L);
        double result4 = mm.divide(5L, 3L);

        System.out.printf("results are %d %d %d %f", result1, result2, result3, result4);
    }

    static void CallStackTest(){
        firstMethod();
    }

    static void firstMethod(){
        System.out.println("firstMethod start");
        secondMethod();
        System.out.println("firstMethod end");
    }

    static void secondMethod(){
        System.out.println("secondMethod start");
        System.out.println("secondMethod end");
    }

    static void CallStackTest2(){
        System.out.println("CallStackTest2 start");
        firstMethod();
        System.out.println("CallStackTest2 end");
    }

    static void PrimitiveParamEx(){
        Data d = new Data();
        d.x = 10;
        System.out.printf("main() : x = %d %n", d.x);
        change(d.x);
        System.out.printf("After change(d.x)%n main() : x = %d %n", d.x);

    }

    static void change(int x){
        x = 1000;
        System.out.printf("change() : x = %d %n", x);
    }

    static void ReferenceParamEx(){
        Data d = new Data();
        d.x = 10;
        System.out.printf("main() : x = %d %n", d.x);
        change(d);
        System.out.printf("After change(d.x)%n main() : x = %d %n", d.x);
    }

    static void change(Data d){
        d.x = 1000;
        System.out.printf("change() : x = %d %n", d.x);
    }

    static void ReferenceParamEx2(){
        int[] x = {10};
        System.out.printf("main() : x = %d%n", x[0]);

        change(x);
        System.out.printf("After change(x)%nmain() : x = %d%n", x[0]);
    }

    static void change(int[] x){
        x[0] = 1000;
        System.out.printf("change() : x = %d%n", x[0]);
    }

    static void ReferenceParamEx3(){
        int[] arr = new int[]{3, 2, 1, 6, 5, 4};
        printArr(arr);
        sortArr(arr);
        printArr(arr);
        System.out.printf("sum = %d %n", sumArr(arr));
    }

    static void printArr(int[] arr){
        System.out.print("[");
        for (int i : arr)
            System.out.printf("%d, ", i);
        System.out.println("]");
    }

    static int sumArr(int[] arr){
        int sum = 0;
        for (int i : arr)
            sum += i;
        return sum;
    }

    static void sortArr(int[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            for (int j = 0; j < arr.length - 1 - i; j++){
                if (arr[j] > arr[j + 1]){
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    static void ReferenceReturnEx(){
        Data d = new Data();
        d.x = 10;
        Data d2 = copy(d);

        System.out.printf("d.x = %d %n", d.x);
        System.out.printf("d2.x = %d %n", d2.x);
    }

    static Data copy(Data d){
        Data tmp = new Data();
        tmp.x = d.x;
        return tmp;
    }

    static void MyMathTest2(){
        //클래스 메서드는 인스턴스 생성 없이 호출 가능
        System.out.println(MyMath2.add(200L, 100L));
        System.out.println(MyMath2.subtract(200L, 100L));
        System.out.println(MyMath2.multiply(200L, 100L));
        System.out.println(MyMath2.divide(200.0, 100));

        //인스턴스 메서드는 객체 생성 후에 호출 가능
        MyMath2 mm = new MyMath2();
        mm.a = 200L;
        mm.b = 100L;

        System.out.println(mm.add());
        System.out.println(mm.subtract());
        System.out.println(mm.multiply());
        System.out.println(mm.divide());
    }
    public static void main(String[] args) {
        CardTest();

        MyMathTest();

        CallStackTest();

        System.out.println();
        CallStackTest2();

        System.out.println();
        PrimitiveParamEx();

        System.out.println();
        ReferenceParamEx();

        System.out.println();
        ReferenceParamEx2();

        System.out.println();
        ReferenceParamEx3();

        System.out.println();
        ReturnTest r = new ReturnTest();

        System.out.println();
        ReferenceReturnEx();

        System.out.println();
        MyMathTest2();
    }
}

class Card {
    String kind;
    int number;
    static int width = 100;
    static int height = 250;
}

class MyMath {
    long add(long a, long b) {
        long result = a + b;
        return result;
    }

    long subtract(long a, long b) {
        return a - b;
    }

    long multiply(long a, long b) {
        return a * b;
    }

    double divide(double a, double b){
        return a / b;
    }
}

class MyMath2{
    long a, b;

    //인스턴스 변수 a, b를 이용해서 작업 => 매개변수 필요 x
    long add(){return a + b;}
    long subtract(){return a - b;}
    long multiply(){return a * b;}
    double divide(){return a / b;}

    //인스턴스 변수와 관계없이 매개변수만으로 작업이 가능
    static long add(long a, long b){return a + b;}
    static long subtract(long a, long b) {return a - b;}
    static long multiply(long a, long b) {return a * b;}
    static double divide(double a, double b) {return a / b;}
}

class Data{
    int x;
}

class ReturnTest{
    {
        int result = this.add(3, 5);
        System.out.println(result);

        int[] result2 = {0};
        this.add(3, 5, result2);
        System.out.println(result2[0]);

    }
    int add(int a, int b){
        return a + b;
    }

    void add(int a, int b, int[] result){
        result[0] = a + b;
    }
}

class MemberCall{
    int iv = 10;
    static int cv = 20;
    int iv2 = cv;
//    static int cv2 = iv; //error. 클래스 변수는 인스턴스 변수를 사용할 수 없음
    static int cv3 = new MemberCall().iv; //이처럼 객체를 생성해야 사용가능

    static void staticMethod1(){
        System.out.println(cv);
//        System.out.println(iv); //error. 클래스 메서드에서 인스턴스 변수 사용 불가
        MemberCall c = new MemberCall();
        System.out.println(c.iv); //객체를 생성한 후에야 인스턴스 변수 참조 가능
    }
    void instanceMethod1(){
        System.out.println(cv);
        System.out.println(iv);
    }
    static void staticMethod2(){
        staticMethod1();
//        instanceMethod1();//error. 클래스 메서드에서는 인스턴스 메서드를 호출할 수 없음
        MemberCall c = new MemberCall();
        c.instanceMethod1(); //인스턴스를 생성한 후에 인스턴스 메서드 호출 가능
    }
    void instanceMethod2(){
        staticMethod1();
        instanceMethod1();
    }
}