import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[] inputs;
    static Map<String, Integer> counts = new HashMap<>();
    static int cnt;

    public static void main(String[] args) throws IOException {
        inputs = br.readLine().split("");
        
        for(String input:inputs) {
            if(!counts.containsKey(input)) {
                counts.put(input, 0);
            } else {
                counts.put(input, counts.get(input) + 1);
            }
        }

        System.out.println(solve());
    }

    public static int solve() {
        String sentence1 = "";
        String sentence2 = "";

        for (String key : counts.keySet()) {
            sentence1 += key;
            sentence1 += String.valueOf(counts.get(key));
        }

        for (int i = 1; i < inputs.length; i++) {
            if (inputs[i - 1].equals(inputs[i])) {
                cnt ++;
            } else {
                sentence2 += inputs[i - 1];
                sentence2 += String.valueOf(cnt);
                cnt = 0; // 초기화
            }
        }

        return Math.max(sentence1.length(), sentence2.length());
    }
}