import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        numbers = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++) {
            for(int j = 1; j < n; j++) {
                if(numbers[j - 1] > numbers[j]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j - 1];
                    numbers[j - 1] = temp;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            sb.append(numbers[i]).append(" ");
        }

        System.out.println(sb.toString());
    }
}