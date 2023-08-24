package Java_Standard.ch5;


import java.util.Arrays;

public class sec1 {
    static void ArrayEx6(){
        int[] score = {79, 88, 91, 33, 100, 55, 95};

        int max = score[0];
        int min = score[1];

        for (int i = 0; i < score.length; i++){
            if (score[i] > max)
                max = score[i];
            else if (score[i] < min)
                min = score[i];
        }

        System.out.println("최댓값 : " + max);
        System.out.println("최솟값 : " + min);
    }

    static void ArrayEx7(){
        int[] numArr = new int[10];
        for (int i = 0; i < 10; i++){
            numArr[i] = i;
        }

        for (int i = 0; i < 10; i++){
            int n = (int)(Math.random() * 10);
            int tmp = numArr[i];
            numArr[i] = numArr[n];
            numArr[n] = tmp;
        }

        for (int v : numArr)
            System.out.print(v);
        System.out.println();
    }

    static void ArrayEx9(){
        int[] code = {0, 1, 2, 3, 4, 5};
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++){
            int idx = (int)(Math.random() * code.length);
            arr[i] = code[idx];
        }

        System.out.println(Arrays.toString(arr));
    }

    static void ArrayEx10(){
        int numArr[] = new int[10];
        for (int i = 0; i < 10; i++)
            numArr[i] = (int)(Math.random() * 10);

        for (int i = 0; i < numArr.length - 1; i++){
            boolean isChanged = false;
            for (int j = 0; j  < numArr.length - 1 - i; j++){
                if (numArr[j] > numArr[j + 1]){
                    int tmp = numArr[j];
                    numArr[j] = numArr[j + 1];
                    numArr[j + 1] = tmp;
                    isChanged = true;
                }
            }
            if (!isChanged)
                break;
        }

        for (int v : numArr)
            System.out.print(v);
        System.out.println();
    }

    static void ArrayEx11(){
        int[] numArr = new int[10];
        int[] counter = new int[10];

        for (int i = 0; i < numArr.length; i++)
            numArr[i] = (int)(Math.random() * 10);

        for (int i = 0; i < numArr.length; i++)
            counter[numArr[i]]++;

        System.out.println(Arrays.toString(numArr));
        System.out.println(Arrays.toString(counter));
    }
    public static void main(String[] args){
        System.out.println("Ex6");
        ArrayEx6();

        System.out.println("\nEx7");
        ArrayEx7();

        System.out.println("\nEx9");
        ArrayEx9();

        System.out.println("\nEx10");
        ArrayEx10();

        System.out.println("\nEx11");
        ArrayEx11();
    }


}
