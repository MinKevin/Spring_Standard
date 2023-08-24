package Java_Standard.ch7;

public abstract class Player {
    boolean pause;
    int currentPos;

    //추상 클래스도 생성자 필요
    Player() {
        pause = false;
        currentPos = 0;
    }
    abstract void play(int pos);

    abstract void stop();

    void play() {
        //추상 메서드 사용 가능
        play(currentPos);
    }

    void pause() {
        if (pause) {
            pause = false;
            play(currentPos);
        } else {
            pause = true;
            stop();
        }
    }
}