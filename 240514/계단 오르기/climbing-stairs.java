import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] steps = new int[1001];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        makeSteps();
        System.out.println(steps[n]);
    }

    public static void makeSteps() {
        steps[2] = 1;
        steps[3] = 1;
        steps[4] = 1;

        for (int i = 5; i < 1001; i++) {
            steps[i] = steps[i - 2] + steps[i - 3];
        }
    }
}