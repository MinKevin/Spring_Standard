package Java_Standard.ch7;

import java.util.Vector;

public class PolyArgumentTest {
    class Product {
        int price;
        int bonusPoint;

        Product(int price) {
            this.price = price;
            bonusPoint = (int) (price / 10);
        }
    }

    class Tv extends Product {
        Tv() {
            super(100);
        }

        public String toString() {
            return "TV";
        }
    }

    class Computer extends Product {
        Computer() {
            super(200);
        }

        public String toString() {
            return "Computer";
        }
    }

    class Audio extends Product {
        Audio() {
            super(50);
        }

        public String toString() {
            return "Audio";
        }
    }

    class Buyer {
        int money = 1000;
        int bonusPoint = 0;
        Vector item = new Vector();
        int i = 0;
        void buy(Product p) {
            if (money < p.price) {
                System.out.println("잔액이 부족합니다.");
                return;
            }
            money -= p.price;
            bonusPoint += p.bonusPoint;
            item.add(p);
            System.out.println(p + "을 구입했습니다.");
        }

        void summary() {
            int sum = 0;
            String itemList = "";

            for (int i = 0; i < item.size(); i++){
                Product p = (Product)item.get(i);
                sum += p.price;
                itemList += (i == 0) ? p : ", " + p;
            }
            System.out.println("sum = " + sum);
            System.out.println("itemList = " + itemList);
        }
    }

    void test1() {
        PolyArgumentTest pat = new PolyArgumentTest();
        Buyer b = pat.new Buyer();

        b.buy(new Tv());
        b.buy(new Computer());

        System.out.println("b.money = " + b.money);
        System.out.println("b.bonusPoint = " + b.bonusPoint);
    }

    void test2(){
        PolyArgumentTest pat = new PolyArgumentTest();
        Buyer b = pat.new Buyer();

        b.buy(new Tv());
        b.buy(new Computer());
        b.buy(new Audio());
        b.summary();
    }

    public static void main(String[] args) {
        PolyArgumentTest pat = new PolyArgumentTest();
        pat.test2();
        ;
    }
}




