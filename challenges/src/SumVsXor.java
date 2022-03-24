public class SumVsXor {
    public static long sumXor(long n) {
        // Write your code here
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
        while (index < nstr.length()) {
            if (nstr.charAt(index) == '0') zeros++;
            index++;
        }
        long result = Math.pow(2, 1 + zeros);
        return result;
    }

    public static void main(String[] args) {
        
    }
}
