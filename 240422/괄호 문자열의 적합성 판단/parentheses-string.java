import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static String[] brakets;
    static Stack<String> stack = new Stack<>();
    static String answer = "No";

    public static void main(String[] args) throws IOException {
        brakets = br.readLine().split("");
        
        for (int i = 0; i < brakets.length; i++) {
            if (brakets[i].equals("(")) {
                stack.push("(");
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }

        if (stack.isEmpty()) {
            answer = "Yes";
        }

        System.out.println(answer);
    }
}