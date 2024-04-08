import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String input;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        input = br.readLine();

        // 문자가 1 개 일 때
        if (input.length() == 1) {
            System.out.println(2);
            return;
        }

        for (int i = 0; i < input.length(); i++) {
            shiftString();
            int encodedLength = encodedRLE();
            min = Math.min(min, encodedLength);
        }

        System.out.println(min);
    }

    public static void shiftString() {
        StringBuilder sb = new StringBuilder();
        int lastIdx = input.length() - 1;

        sb.append(input.charAt(lastIdx)).append(input.substring(0, lastIdx));
        input = sb.toString();
    }

    private static int encodedRLE() {
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i - 1) == input.charAt(i)) {
                cnt++;
            } else {
                sb.append(input.charAt(i - 1));
                sb.append(cnt);
                cnt = 1; // 초기화
            }
        }

        // 마지막 문자
        sb.append(input.charAt(input.length() - 1));
        sb.append(cnt);

        return sb.toString().length();
    }
}