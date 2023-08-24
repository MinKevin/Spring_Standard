package Java_Standard.ch7;

public class CDPlayer extends Player {
    int currentTrack;

    @Override
    void play(int pos) {
        System.out.println("play");
    }

    @Override
    void stop() {
        System.out.println("stop");
    }

    void nextTrack() {
        currentTrack++;
    }

    void preTrack() {
        if (currentTrack > 1) {
            currentTrack--;
        }
    }
}
