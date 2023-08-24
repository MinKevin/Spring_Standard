package Java_Standard.ch6;


class Tv{
    //Tv의 속성 (멤버변수)
    String color;
    boolean power;
    int channel;

    //Tv의 기능 (메서드)
    void power(){
        power = !power;
    }

    void channelUp(){
        ++channel;
    }
    void channelDown(){
        --channel;
    }
}
public class sec2 {
    static void TvTest(){
        Tv t;
        t = new Tv();
        t.channel = 7;
        t.channelDown();
        System.out.println("현재 채널은 : " + t.channel);
    }

    static void TvTest2(){
        Tv t1 = new Tv();
        Tv t2 = new Tv();

        System.out.println("t1's channel value is " + t1.channel);
        System.out.println("t2's channel value is " + t2.channel);

        t1.channel = 7;

        System.out.println("t1's channel value is " + t1.channel);
        System.out.println("t2's channel value is " + t2.channel);
    }

    static void TvTest3(){
        // Tv 클래스 타입의 참조형 변수 t1에 새로운 Tv 인스턴스의 주소값을 할당
        Tv t1 = new Tv();
        Tv t2 = new Tv();
        System.out.println("t1's channel value is " + t1.channel);
        System.out.println("t2's channel value is " + t2.channel);

        //참조 변수 t2의 값에 t1이 가르키는 인스턴스의 주소를 할당
        t2 = t1;
        t1.channel = 7;

        System.out.println("t1's channel value is " + t1.channel);
        System.out.println("t2's channel value is " + t2.channel);
    }

    static void TvTest4(){
        Tv[] tvArr = new Tv[3];
        for (int i = 0; i < tvArr.length; i++){
            tvArr[i] = new Tv();
            tvArr[i].channel = i;
        }

        for (int i = 0; i < tvArr.length; i++){
            tvArr[i].channelUp();
            System.out.printf("tvArr[%d].channel = %d%n", i, tvArr[i].channel);
        }
    }

    class Time{
        private int hour;
        private int minute;
        private int second;

        public int  getHour(){return hour;}
        public int getMinute(){return minute;}
        public int getSecond(){return second;}

        public void setHour(int h){
            if (0 <= h && h <= 23)
                hour = h;
        }

        public void setMinute(int m){
            if (0 <= m && m <= 59)
                minute = m;
        }

        public void setSecond(int s){
            if (0 <= s && s <= 59)
                second = s;
        }
    }
    static void ObjectArray(){
        Tv[] tvArr = new Tv[3];
        tvArr[0] = new Tv();
        tvArr[1] = new Tv();
        tvArr[2] = new Tv();

        Tv[] tvArr2 = {new Tv(), new Tv(), new Tv()};

        Tv[] tvArr3 = new Tv[100];
        for (int i = 0; i < tvArr3.length; i++)
            tvArr3[i] = new Tv();
    }
    public static void main(String[] args) {
        TvTest();

        TvTest2();

        TvTest3();

        TvTest4();
        //객체 배열을 초기화하는 방법
        ObjectArray();
    }
}
