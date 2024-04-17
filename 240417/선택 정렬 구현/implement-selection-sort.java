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
        for (int i = 0; i < n - 1; i++) {
            min = numbers[i];
            for (int j = i + 1; j < n; j++) {
                if (min > numbers[j]) {
                    min = numbers[j];
                    minIdx = j;
                }
            }
            
            if (min != numbers[i]) {
                numbers[minIdx] = numbers[i];
                numbers[i] = min;
            }
        }
    }

    public static void print() {
        for (int number : numbers) {
            sb.append(number).append(" ");
        }

        System.out.println(sb.toString());
    }
}