import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[] numbers;
    static int min;
    static int minIdx;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        numbers = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        sortNumbers();
        print();
    }

    public static void sortNumbers() {
        for (int i = 1; i < n; i++) {
            int temp = numbers[i];
            int tempIdx = i - 1;

            while(tempIdx >= 0 && numbers[tempIdx] > temp) {
                numbers[tempIdx + 1] = numbers[tempIdx];
                tempIdx--;
            }
            numbers[tempIdx + 1] = temp;
        }
    }

    public static void print() {
        for (int number : numbers) {
            sb.append(number).append(" ");
        }

        System.out.println(sb.toString());
    }
}