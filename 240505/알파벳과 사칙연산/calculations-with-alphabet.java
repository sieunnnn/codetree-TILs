import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] numbers = {1, 2, 3, 4};
    static List<String> operations = new ArrayList<>();
    static int count;
    static int maxResult = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split("");
        int id = 0;
        
        for (int i = 0; i < input.length; i++) {
            if (i % 2 != 0) { // 홀수 -> 연산자
                operations.add(input[i]);
            } else {
                count++;
            }
        } 

        solve(0, new ArrayList<>());
        System.out.println(maxResult);
    }

    public static void solve(int depth, List<Integer> current) {
        if (depth == count) {
            int result = calculateResult(current);
            maxResult = Math.max(maxResult, result);
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            current.add(numbers[i]);
            solve(depth + 1, current);
            current.remove(current.size() - 1);
        }
    }

    public static int calculateResult(List<Integer> numbers) {
        int result = numbers.get(0);

        for (int i = 1; i < numbers.size(); i++) {
            String operation = operations.get(i - 1);
            int nextNum = numbers.get(i);

            if (operation.equals("+")) {
                result += nextNum;

            } else if (operation.equals("-")) {
                result -= nextNum;
                
            } else if (operation.equals("*")){
                result *= nextNum;
            }
        }

        return result;
    }
}