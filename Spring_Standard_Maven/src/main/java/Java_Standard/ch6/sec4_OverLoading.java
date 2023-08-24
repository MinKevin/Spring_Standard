package Java_Standard.ch6;


public class sec4_OverLoading {
    static void VarArgsEx(){
        String[] strArr = {"100", "200", "300"};
        System.out.println(concatenate("", "100", "200", "300"));
        System.out.println(concatenate("-", strArr));
        System.out.println(concatenate(", ", new String[]{"1", "2", "3"}));
        System.out.println(concatenate(",", new String[0]));
        System.out.println(concatenate(","));
    }

    static String concatenate(String delim, String... args){
        String result = "";
        for(int i = 0; i < args.length; i++){
            result += args[i] + delim;
        }
        return result;
    }

//    static String concatenate(String... args){
//        return concatenate("", args);
//    }
    public static void main(String[] args) {

    }
}
