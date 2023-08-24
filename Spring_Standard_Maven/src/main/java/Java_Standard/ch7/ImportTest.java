package Java_Standard.ch7;

import java.text.SimpleDateFormat;
import java.util.Date;
public class ImportTest {
    public static void main(String[] args) {
        Date today = new Date();

        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss a");

        System.out.println(today);
        System.out.println("today is " + date.format(today));
        System.out.println("present time is " + time.format(today));
    }
}
