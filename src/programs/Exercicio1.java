package programs;

import java.util.Arrays;

public class Exercicio1 {

    public void runProgram() {
        int iArr[] = {16223, 898, 12, 906, 235, 23, 9, 1532, 6388, 2511, 8};
        radixSort(iArr);
        for (int i : iArr) {
            System.out.print(i + " ");
        }
    }

    public static void radixSort(int iArr[]) {
        int arrLength = iArr.length;
        int max = getMax(iArr, arrLength);

        for (int exp = 1; max / exp > 0; exp *= 10)
            countSort(iArr, arrLength, exp);
    }

    public static int getMax(int iArr[], int arrLength) {
        int max = iArr[0];
        for (int i = 1; i < arrLength; i++)
            if (iArr[i] > max)
                max = iArr[i];
        return max;
    }

    public static void countSort(int iArr[], int arrLength, int exp) {
        int output[] = new int[arrLength];
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        for (i = 0; i < arrLength; i++)
            count[(iArr[i] / exp) % 10]++;

        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (i = arrLength - 1; i >= 0; i--) {
            output[count[(iArr[i] / exp) % 10] - 1] = iArr[i];
            count[(iArr[i] / exp) % 10]--;
        }

        for (i = 0; i < arrLength; i++)
            iArr[i] = output[i];
    }

}
