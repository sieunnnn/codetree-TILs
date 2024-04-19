import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] numbers;
    static int[] temp;  // 전역 임시 배열

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        temp = new int[N];  // 초기화 위치 변경

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        devide(numbers, 0, numbers.length -1);
        print();
    }

    public static void devide(int[] numbers, int start, int last) {
        if (start < last) {
            int middle = (start + last) / 2;
            devide(numbers, start, middle);
            devide(numbers, middle + 1, last);
            merge(numbers, start, middle, last);
        }
    }

    public static void merge(int[] numbers, int start, int middle, int last) {
        int i = start;
        int j = middle + 1;
        int temp_idx = start;

        while (i <= middle && j <= last) {
            if(numbers[i] < numbers[j]) {
                temp[temp_idx++] = numbers[i++];
            } else {
                temp[temp_idx++] = numbers[j++];
            }
        }
        
        while (i <= middle) {
            temp[temp_idx++] = numbers[i++];
        }

        while (j <= last) {
            temp[temp_idx++] = numbers[j++];
        }

        for (int k = start; k < temp_idx; k++) {
            numbers[k] = temp[k];
        }
    }

    public static void print() {
        for (int number : numbers) {
            sb.append(number).append(" ");
        }

        System.out.println(sb.toString());
    }
}