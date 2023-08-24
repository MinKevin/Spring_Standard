package Java_Standard.ch7;

public class RepairableTest {
    public static void main(String[] args) {
        RepairableTest rt = new RepairableTest();
        Tank tank = rt.new Tank();
        Dropship dropship = rt.new Dropship();

        Marine marine = rt.new Marine();
        SCV scv = rt.new SCV();

        scv.repair(tank);
        scv.repair(dropship);
        // scv.repair(marine);
    }

    interface Repairable { }

    class Unit {
        int hitPoint;
        final int MAX_HP;
        Unit(int hp){
            MAX_HP = hp;
        }
    }

    class GroundUnit extends Unit {
        GroundUnit(int hp){
            super(hp);
        }
    }

    class AirUnit extends Unit {
        AirUnit (int hp) {
            super(hp);
        }
    }

    class Tank extends GroundUnit implements Repairable {
        Tank(){
            super(150);
            hitPoint = MAX_HP;
        }

        public String toString(){
            return "Tank";
        }
    }

    class Dropship extends AirUnit implements Repairable {
        Dropship() {
            super(125);
            hitPoint = MAX_HP;
        }

        public String toString() {
            return "Dropship";
        }
    }

    class Marine extends GroundUnit {
        Marine(){
            super(40);
            hitPoint = MAX_HP;
        }
    }

    class SCV extends GroundUnit implements Repairable {
        SCV() {
            super(60);
            hitPoint = MAX_HP;
        }

        void repair(Repairable r){
            if (r instanceof Unit){
                Unit u = (Unit)r;
                while(u.hitPoint != u.MAX_HP){
                    u.hitPoint++;
                }
                System.out.println(u.toString() + "의 수리가 끝났습니다.");
            }
        }
    }
}
