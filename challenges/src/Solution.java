import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'counterGame' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts LONG_INTEGER n as parameter.
     */

    public static String counterGame(long n) {
        String player = "Louise";
        long current = n;

        while (current > 1) {
            if (isPowerOfTwo(current)) { current = current / 2; }
            else { current = current - nextPowerOfTwo(n); }
            if (current != 1) {
                player = player.equals("Louise") ? "Richard" : "Louise";
            }
        }

        return player;
    }

    public static boolean isPowerOfTwo(long n) {
        return (Math.log(n)/Math.log(2) % 1.0 == 0);
    }

    public static long nextPowerOfTwo(long n) {
        double nextLowestFactor = Math.floor(Math.log(n)/Math.log(2));
        long nextPower = (long) Math.pow(2, nextLowestFactor);
        return nextPower; 
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        System.out.println("asdf");
        // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        // int t = Integer.parseInt(bufferedReader.readLine().trim());
        int t = 1;
        for (int tItr = 0; tItr < t; tItr++) {
            // long n = Long.parseLong(bufferedReader.readLine().trim());
            long n = 1384145241;
            String result = Result.counterGame(n);

            // bufferedWriter.write(result);
            System.out.println(result);
            // bufferedWriter.newLine();
        }

        // bufferedReader.close();
        // bufferedWriter.close();
    }
}
