import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] numbers;
    static int min = Integer.MAX_VALUE;
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        numbers = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        solve(numbers[0], 0, 0);
        
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        
        } else {
            System.out.println(min);
        }
    }

    public static void solve(int max, int currentId, int count) {
        if (currentId == n - 1) {
            min = Math.min(min, count);
            return;

        } else if (currentId >= n) {
            return;
        }

        for (int i = 1; i <= max; i++) {
            int nextId = currentId + i;
            solve(numbers[nextId], nextId, count + 1);
        }
    }
}