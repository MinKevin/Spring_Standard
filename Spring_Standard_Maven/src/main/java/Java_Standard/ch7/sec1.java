package Java_Standard.ch7;

public class sec1 {
    static void CaptionTvTest(){
        CaptionTv ctv = new CaptionTv();
        ctv.channel = 10;
        ctv.channelUp();
        System.out.println(ctv.channel);
        ctv.displayCaption("Hello, World");
        ctv.caption = true;
        ctv.displayCaption("Hello, World2");
    }
    public static void main(String[] args) {
        CaptionTvTest();
    }
}

class Tv {
    boolean power;
    int channel;

    void power() {
        power = !power;
    }

    void channelUp() {
        ++channel;
    }

    void channelDown() {
        --channel;
    }
}

class CaptionTv extends Tv {
    boolean caption;

    void displayCaption(String text){
        if (caption){
            System.out.println(text);
        }
    }
}
