public class SumVsXor {
    public static long sumXor(long n) {
        long defaultans = 1;
        if (n < 0) return defaultans;
        long zeros = 0;
        // convert n to a binary string
        String nstr = Long.toString(n, 2);
        // find index of first 1
        int index = -1;
        for (int i = 0; i < nstr.length() && index == -1; i++) {
            if (nstr.charAt(i) == '1') index = i;
        }
        //  starting with the index we just identified (if found)
        //  iterate through the string and for each 0 found increase result by one
        if (index >= 0) {
        while (index < nstr.length()) {
            if (nstr.charAt(index) == '0') zeros++;
            index++;
        }
        }
        long result = (long) Math.pow(2, zeros);
        return result;
    }

    public static void main(String[] args) {
        
    }
}
