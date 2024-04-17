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
        int max = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, numbers[i]);
        }

        int maxLength = String.valueOf(max).length();
        sortNumbers(numbers, maxLength);
        print();
    }

    public static void sortNumbers(int[] numbers, int maxLength) {
        int digit = 1;
        Queue<Integer>[] bucket = new LinkedList[10];

        // bucket 초기화
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new LinkedList<Integer>();
        }

        for (int i = 0; i < maxLength; i++) { // 가장 긴 데이터의 길이만큼 반복
            for (int j = 0; j < numbers.length; j++) {
                int index = (numbers[j] / digit) % 10;
                bucket[index].offer(numbers[j]);
            }
        

            for (int bucketIdx = 0, numbersIdx = 0; bucketIdx < 10; bucketIdx++) {
                while(!bucket[bucketIdx].isEmpty()) {
                    numbers[numbersIdx++] = bucket[bucketIdx].poll();
                }
            }
            digit *= 10;
        }
    }

    public static void print() {
        for (int number : numbers) {
            sb.append(number).append(" ");
        }

        System.out.println(sb.toString());
    }
}