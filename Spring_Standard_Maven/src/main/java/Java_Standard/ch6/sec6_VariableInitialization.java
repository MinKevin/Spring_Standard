package Java_Standard.ch6;

public class sec6_VariableInitialization {
    static void ProductTest(){
        Product p1 = new Product();
        Product p2 = new Product();
        Product p3 = new Product();

        System.out.printf("p1's serialNo is %d %n", p1.serialNo);
        System.out.printf("p2's serialNo is %d %n", p2.serialNo);
        System.out.printf("p3's serialNo is %d %n", p3.serialNo);
        System.out.printf("produced product count is %d %n", Product.count);

    }
    public static void main(String[] args) {
        ProductTest();
    }
}

class Product {
    static int count = 0;
    int serialNo;

    {
        serialNo = ++count;
    }

    public Product() {
    }
}
