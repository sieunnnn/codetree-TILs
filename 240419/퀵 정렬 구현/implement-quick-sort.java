import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] numbers;
    static int[] temp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        temp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        devide(0, numbers.length -1);
        print();
    }

    public static void devide(int low, int hight) {
        if (low < hight) {
            int middle = partition(low, hight);
            devide(low, middle - 1);
            devide(middle, hight);
        }
    }

    public static int partition(int low, int hight) {
        int pivot = numbers[(low + hight) / 2];

        while (low <= hight) {
            while (numbers[low] < pivot) low++;
            while (numbers[hight] > pivot) hight--;
            if (low <= hight) {
                swap (low, hight);
                low++;
                hight++;
            }
        }
        return low;
    }

    public static void swap(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void print() {
        for (int number : numbers) {
            sb.append(number).append(" ");
        }

        System.out.println(sb.toString());
    }
}