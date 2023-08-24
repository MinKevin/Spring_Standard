package Java_Standard.ch7;

public class Interface7_5{
    class Tv {
        protected boolean power;
        protected int channel;
        protected int volume;

        public void power() { power = !power; }
        public void channelUp() { channel++; }
        public void channelDown() { channel--; }
        public void volumeUp() { volume++; }
        public void volumeDown() { volume--; }
    }

    public class VCR {
        protected int counter;

        public void play() {}
        public void stop() {}
        public void reset() {
            counter = 0;
        }
        public int getCounter() {
            return counter;
        }
        public void setCounter(int c) {
            counter = c;
        }
    }

    //VCR클래스에 정의된 메서드와 일치하는 추상메서드를 갖는 인터페이스
    public interface IVCR {
        public void play();
        public void stop();
        public void reset();
        public int getCounter();
        public void setCounter(int c);
    }

    //IVCR을 구현하고 Tv를 상속받는 TVCR클래스 생성
    public class TVCR extends Tv implements IVCR{
        //VCR클래스 타입의 참조변수를 멤버변수로 선언
        //=> IVCR인터페이스의 추상 메서드를 구현하는데 사용
        VCR vcr = new VCR();
        @Override
        public void play() {vcr.play();}

        @Override
        public void stop() {vcr.stop();}

        @Override
        public void reset() {vcr.reset();}

        @Override
        public int getCounter() {return vcr.getCounter();}

        @Override
        public void setCounter(int c) {vcr.setCounter(c);}
    }
}
