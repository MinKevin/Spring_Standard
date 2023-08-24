package Java_Standard.ch7;

public abstract class Unit {
    int x, y;
    abstract void move(int x, int y);
    void stop(){}
}

class Marine extends Unit{
    void move(int x, int y) {}
    void steamPack() {}
}

class Tank extends Unit{
    void move(int x, int y) {}
    void changeMode() {}
}

class DropShip extends Unit{
    void move(int x, int y) {}
    void load() {}
    void unload() {}
}
