package Java_Standard.ch7;

import static java.lang.System.out;
import static java.lang.Math.*;

public class StaticImportEx1 {
    public static void main(String[] args) {
        out.println(Math.random());
        out.println(random());

        out.println("Math.PI : " + PI);
    }
}
